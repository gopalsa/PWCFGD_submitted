package com.smart.cst.pwcfgd;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.smart.cst.pwcfgd.app.AppConfig;
import com.smart.cst.pwcfgd.app.AppController;
import com.smart.cst.pwcfgd.staff.DbStaff;
import com.smart.cst.pwcfgd.staff.Staff;
import com.smart.cst.pwcfgd.staff.StaffRegister;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.smart.cst.pwcfgd.app.AppConfig.staffIdKey;
import static com.smart.cst.pwcfgd.app.AppConfig.studentIdKey;

public class LoginActivity extends AppCompatActivity {

    public static final String buSurveyerId = "buSurveyerIdKey";
    public static final String mypreference = "mypref";
    SharedPreferences sharedpreferences;
    private ProgressDialog pDialog;
    DbStaff dbStaff;
    EditText username;
    EditText password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        dbStaff=new DbStaff(this);

        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);


        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        final TextView login = (TextView) findViewById(R.id.login);
        final TextView forgotpassword = (TextView) findViewById(R.id.forgotpassword);
        TextView addStaff = (TextView) findViewById(R.id.addfarmer);

        addStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent io = new Intent(LoginActivity.this, StaffRegister.class);
                startActivity(io);
            }
        });
        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent io = new Intent(LoginActivity.this, ForgotPassword.class);
                startActivity(io);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().length() > 0 && password.getText().toString().length() > 0) {
                    loginStaff();
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter username and Password/Mobile", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


    private void loginStaff() {
        String tag_string_req = "req_register";
        pDialog.setMessage("Validating ...");
        showDialog();
        // showDialog();
        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_GET_STAFF, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Register Response: ", response.toString());
                hideDialog();
                try {
                    JSONObject jObj = new JSONObject(response);
                    int success = jObj.getInt("success");
                    String msg = jObj.getString("message");
                    if (success == 1) {
                        dbStaff.deleteAll();
                        Staff staff = new Gson().fromJson(jObj.getString("data"), Staff.class);
                        String id = jObj.getString("id");
                        dbStaff.addData(id, new Gson().toJson(staff));
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.remove(staffIdKey);
                        editor.remove(studentIdKey);
                        editor.putString(staffIdKey, id);
                        editor.putString(buSurveyerId, username.getText().toString() + "_" + password.getText().toString());
                        editor.commit();
                        startActivity(new Intent(LoginActivity.this, MainActivityAllFGDSurvey.class));
                        finish();

                    }
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    Log.e("xxxxxxxxxxx", e.toString());
                    Toast.makeText(getApplicationContext(), "Some Network Error.Try after some time", Toast.LENGTH_SHORT).show();

                }

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
                localHashMap.put("name", username.getText().toString());
                localHashMap.put("password", password.getText().toString());
                return localHashMap;
            }
        };
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}
