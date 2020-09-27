package com.smart.cst.pwcfgd.staff;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.Gson;
import com.smart.cst.pwcfgd.R;
import com.smart.cst.pwcfgd.app.AndroidMultiPartEntity;
import com.smart.cst.pwcfgd.app.AppConfig;
import com.smart.cst.pwcfgd.app.AppController;
import com.smart.cst.pwcfgd.app.GlideApp;
import com.smart.cst.pwcfgd.app.Imageutils;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.smart.cst.pwcfgd.app.AppConfig.mypreference;

/**
 * Created by user_1 on 11-07-2018.
 */

public class StaffRegister extends AppCompatActivity implements Imageutils.ImageAttachmentListener {

    private static final String[] DESIGNATION = new String[]{
            "Director", "Coordinator", "Accountant"
    };

    private MaterialBetterSpinner designation;
    private MaterialBetterSpinner department;

    EditText name;
    EditText contact;
    EditText address;
    EditText password;
    EditText confirmPass;
    EditText graduate;
    EditText gmail;
    EditText specialization;
    DbStaff dbStaff;

    private static final String[] DEPARTMENT = new String[]{
            "BIOCHEMISTRY", "BIOTECHNOLOGY", "BOTANY", "COMPUTER SCIENCE", "INFORMATION TECHNOLOGY", "MATHEMATICS", "STATISTICS", "ENGLISH", "FRENCH", "HINDI", "HISTORY", "SANSKRIT", "TAMIL"
            , "BUSINESS ADMINISTRATION", "COMMERCE", "COMMERCE COMPUTER APPLICATIONS", "ECONOMICS", "HUMAN RESOURCE MANAGEMENT", "LIBRARY", "PHYSICAL EDUCATION", "CHEMISTRY", "ELECTRONICS",
            "PHYSICS", "SOFTWARE DEVELOPMENT AND SYSTEM ADMINISTRATION", "VISUAL COMMUNICATION TECHNOLOGY"
    };

    private TextView submit;

    private ProgressDialog pDialog;

    SharedPreferences sharedpreferences;

    Imageutils imageutils;
    private CircleImageView staffImage;
    private String imageUrl = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.staff_register);

        imageutils = new Imageutils(this);

        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        dbStaff = new DbStaff(this);
        designation = ((MaterialBetterSpinner) findViewById(R.id.designation));
        ArrayAdapter<String> boardAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, DESIGNATION);
        designation.setAdapter(boardAdapter);

        department = ((MaterialBetterSpinner) findViewById(R.id.department));
        ArrayAdapter<String> departmentAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, DEPARTMENT);
        department.setAdapter(departmentAdapter);


        staffImage = (CircleImageView) findViewById(R.id.staffImage);
        staffImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageutils.imagepicker(1);
            }
        });

        name = (EditText) findViewById(R.id.name);
        contact = (EditText) findViewById(R.id.contact);
        address = (EditText) findViewById(R.id.address);
        graduate = (EditText) findViewById(R.id.graduate);
        gmail = (EditText) findViewById(R.id.gmail);
        specialization = (EditText) findViewById(R.id.specialization);
        password = (EditText) findViewById(R.id.password);
        confirmPass = (EditText) findViewById(R.id.confirmPass);


        submit = (TextView) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().length() > 0 &&
                        contact.getText().toString().length() > 0 &&
                        address.getText().toString().length() > 0 &&
                        designation.getText().toString().length() > 0 &&
                        password.getText().toString().length() > 0 &&
                        confirmPass.getText().toString().length() > 0) {

                    if (!password.getText().toString().equalsIgnoreCase(confirmPass.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Password & Confirm password not matched", Toast.LENGTH_SHORT).show();
                    } else if (contact.getText().toString().length() != 10 || contact.getText().toString().matches(".*[a-zA-Z]+.*")) {
                        Toast.makeText(getApplicationContext(), "Enter a valid Contact", Toast.LENGTH_SHORT).show();
                    } else if (imageUrl == null) {
                        Toast.makeText(getApplicationContext(), "Select a Image", Toast.LENGTH_SHORT).show();
                    } else {
                        Staff staff = new Staff(name.getText().toString(),
                                contact.getText().toString(),
                                address.getText().toString(),
                                designation.getText().toString(),
                                graduate.getText().toString(),
                                specialization.getText().toString(),
                                department.getText().toString(),
                                gmail.getText().toString(),
                                password.getText().toString(),
                                confirmPass.getText().toString(), imageUrl,"");

                        registerUser(new Gson().toJson(staff));
                    }
                }
            }
        });

    }

    private void registerUser(final String mData) {
        String tag_string_req = "req_register";
        pDialog.setMessage("Processing ...");
        showDialog();
        // showDialog();
        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_CREATE_STAFF, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Register Response: ", response.toString());
                hideDialog();
                try {
                    JSONObject jObj = new JSONObject(response.substring(response.indexOf("{"), response.length()));
                    int success = jObj.getInt("success");
                    String msg = jObj.getString("message");
                    if (success == 1) {
                        dbStaff.deleteAll();
                        finish();
                    }
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
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
                localHashMap.put("data", mData);
                localHashMap.put("password", password.getText().toString());
                localHashMap.put("name", name.getText().toString());
                localHashMap.put("contact", contact.getText().toString());
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        imageutils.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        imageutils.request_permission_result(requestCode, permissions, grantResults);
    }

    @Override
    public void image_attachment(int from, String filename, Bitmap file, Uri uri) {
        String path = Environment.getExternalStorageDirectory() + File.separator + "ImageAttach" + File.separator;
        imageutils.createImage(file, filename, path, false);
        pDialog.setMessage("Uploading...");
        showDialog();
        new UploadFileToServer().execute(imageutils.getPath(uri));
    }

    private class UploadFileToServer extends AsyncTask<String, Integer, String> {
        String filepath;
        public long totalSize = 0;

        @Override
        protected void onPreExecute() {
            // setting progress bar to zero

            super.onPreExecute();

        }

        @Override
        protected void onProgressUpdate(Integer... progress) {
            pDialog.setMessage("Uploading..." + (String.valueOf(progress[0])));
        }

        @Override
        protected String doInBackground(String... params) {
            filepath = params[0];
            return uploadFile();
        }

        @SuppressWarnings("deprecation")
        private String uploadFile() {
            String responseString = null;

            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(AppConfig.URL_IMAGE_UPLOAD);
            try {
                AndroidMultiPartEntity entity = new AndroidMultiPartEntity(
                        new AndroidMultiPartEntity.ProgressListener() {

                            @Override
                            public void transferred(long num) {
                                publishProgress((int) ((num / (float) totalSize) * 100));
                            }
                        });

                File sourceFile = new File(filepath);
                // Adding file data to http body
                entity.addPart("image", new FileBody(sourceFile));

                totalSize = entity.getContentLength();
                httppost.setEntity(entity);

                // Making server call
                HttpResponse response = httpclient.execute(httppost);
                HttpEntity r_entity = response.getEntity();

                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode == 200) {
                    // Server response
                    responseString = EntityUtils.toString(r_entity);

                } else {
                    responseString = "Error occurred! Http Status Code: "
                            + statusCode;

                }

            } catch (ClientProtocolException e) {
                responseString = e.toString();
            } catch (IOException e) {
                responseString = e.toString();
            }

            return responseString;

        }

        @Override
        protected void onPostExecute(String result) {
            Log.e("Response from server: ", result);
            try {
                JSONObject jsonObject = new JSONObject(result.toString());
                if (!jsonObject.getBoolean("error")) {
                    GlideApp.with(getApplicationContext())
                            .load(filepath)
                            .dontAnimate()
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .skipMemoryCache(false)
                            .placeholder(R.drawable.profile)
                            .into(staffImage);
                    imageUrl = AppConfig.ipcloud + "/uploads/" + imageutils.getfilename_from_path(filepath);
                } else {
                    imageUrl = null;
                }
                Toast.makeText(getApplicationContext(), jsonObject.getString("message"), Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Image not uploaded", Toast.LENGTH_SHORT).show();
            }
            hideDialog();
            // showing the server response in an alert dialog
            //showAlert(result);


            super.onPostExecute(result);
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        hideDialog();
    }
}
