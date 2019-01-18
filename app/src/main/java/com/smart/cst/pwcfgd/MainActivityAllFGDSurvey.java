package com.smart.cst.pwcfgd;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.smart.cst.pwcfgd.app.AppController;
import com.smart.cst.pwcfgd.staff.DbStaff;
import com.smart.cst.pwcfgd.staff.Staff;
import com.smart.cst.pwcfgd.staff.StaffUpdate;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.smart.cst.pwcfgd.app.AppConfig.staffIdKey;


public class MainActivityAllFGDSurvey extends AppCompatActivity {


    private ProgressDialog pDialog;
    private RecyclerView mastersList;
    private MasterAllFGDSurveyAdapter mRecyclerAdapterMaster;
    private ArrayList<FGDNewBean> itemArrayList = new ArrayList<>();


    public static final String mypreference = "mypref";
    public static final String buSurveyerId = "buSurveyerIdKey";
    SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_all_fgd_survey);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        getSupportActionBar().setTitle("PWC FGD");
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        sharedpreferences = this.getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);


        FloatingActionButton addMaster = (FloatingActionButton) findViewById(R.id.addSurvey);
        addMaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityAllFGDSurvey.this, MainActivityNewFGD.class);
                startActivity(intent);
            }
        });
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        mastersList = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerAdapterMaster = new MasterAllFGDSurveyAdapter(this, itemArrayList);
        final LinearLayoutManager thirdManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mastersList.setLayoutManager(thirdManager);
        mastersList.setAdapter(mRecyclerAdapterMaster);


        // getAllData();
    }

    private void getAllData() {
        String tag_string_req = "req_register";
        pDialog.setMessage("Validating ...");
        showDialog();
        // showDialog();
        StringRequest strReq = new StringRequest(Request.Method.POST,
                "http://climatesmartcity.com/UBA/get_pwcfgd.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Register Response: ", response.toString());
                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");
                    if (!error) {
                        JSONArray jsonArray = jObj.getJSONArray("crop");
                        itemArrayList = new ArrayList<>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            try {
                                JSONObject dataObject = jsonArray.getJSONObject(i);
                                FGDNewBean mainFGD = new Gson().fromJson(dataObject.getString("data"), FGDNewBean.class);
                                mainFGD.setId(dataObject.getString("formId"));
                                itemArrayList.add(mainFGD);
                            } catch (Exception e) {
                                Log.e("xxxxxxxxxxx", e.toString());
                            }
                        }
                        getSupportActionBar().setSubtitle(String.valueOf(itemArrayList.size()) + " Surveys");
                        mRecyclerAdapterMaster.notifyData(itemArrayList);
                        if (itemArrayList.size() == 0) {
                            Intent intent = new Intent(MainActivityAllFGDSurvey.this, MainActivityNewFGD.class);
                            startActivity(intent);
                        }
                    } else {
                        Intent intent = new Intent(MainActivityAllFGDSurvey.this, MainActivityNewFGD.class);
                        startActivity(intent);

                    }
                } catch (Exception e) {
                    Log.e("xxxxxxxxxxx", e.toString());
                    //     Toast.makeText(getApplicationContext(), "Some Network Error.Try after some time", Toast.LENGTH_SHORT).show();

                }
                hideDialog();

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Registration Error: ", error.getMessage());
                Toast.makeText(getApplicationContext(),
                        "Some Network Error.Try after some time", Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }) {
            protected Map<String, String> getParams() {
                HashMap localHashMap = new HashMap();
                localHashMap.put("key", sharedpreferences.getString(buSurveyerId, ""));
                return localHashMap;
            }
        };
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }


    private void hideDialog() {
        if (this.pDialog.isShowing())
            this.pDialog.dismiss();
    }


    private void showDialog() {
        if (!this.pDialog.isShowing())
            this.pDialog.show();
    }

    @Override
    public void onStart() {
        super.onStart();
        getAllData();

    }


    private boolean isValidString(String string) {

        if (string == null) {
            return false;
        } else if (string.length() <= 0) {
            return false;
        } else if (string.startsWith("http")) {
            return false;
        }

        return true;
    }

    public String getfilename_from_path(String path) {
        return path.substring(path.lastIndexOf('/') + 1, path.length());

    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(R.menu.main_menu, paramMenu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
            case R.id.editProfile:
                Intent io = new Intent(MainActivityAllFGDSurvey.this, StaffUpdate.class);
                startActivity(io);
                return true;
            case R.id.exit:
                AlertDialog diaBox = Option();
                diaBox.show();
                return true;
        }


    }


    private AlertDialog Option() {

        AlertDialog myQuittingDialogBox = new AlertDialog.Builder(this)
                //set message, title, and icon
                .setTitle("Alert")
                .setMessage("Are you sure want to exit?")
                .setPositiveButton("Exit", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        //your deleting code
                        DbStaff dbStaff = new DbStaff(MainActivityAllFGDSurvey.this);
                        Staff staff = new Gson().fromJson(dbStaff.getDataBystaffid(sharedpreferences.getString(staffIdKey, "")).get(1), Staff.class);
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.remove(staffIdKey);
                        editor.commit();
                        Intent io = new Intent(MainActivityAllFGDSurvey.this, LoginActivity.class);
                        startActivity(io);
                        finish();
                    }
                })


                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
        return myQuittingDialogBox;

    }
}


