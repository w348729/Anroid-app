package com.example.blade.template;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Blade on 2017/12/28.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String URL = "http://172.17.251.69:8080/ISS_PROJECT_FRONT/mobile/mobileService";

    private Button login;

    private LoginInfo userInfo;

    public LoginInfo loginInfoList;

    private EditText userNameEdit;

    private EditText passwordEdit;

    private ProgressDialog pd;

    private SharedPreferences sf;

    private SharedPreferences.Editor editor;

    private CheckBox rememberPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);
        userNameEdit = (EditText) findViewById(R.id.account);
        passwordEdit = (EditText) findViewById(R.id.password);
        rememberPass = (CheckBox) findViewById(R.id.remember_pass);
        userInfo = new LoginInfo();
        sf = PreferenceManager.getDefaultSharedPreferences(this);
        Boolean isRemember = sf.getBoolean("remember_password", false);
        if (isRemember) {
            String account = sf.getString("account", "");
            String password = sf.getString("password", "");
            userNameEdit.setText(account);
            passwordEdit.setText(password);
            rememberPass.setChecked(true);
        }
    }

    @Override
    public void onClick(View v) {
        //userInfo.setUserName(username);
        //userInfo.setPassword(password);
        switch ((v.getId())) {
            case R.id.login:
                if (userNameEdit==null) {
                    Toast.makeText(this, "please input your account", Toast.LENGTH_SHORT).show();
                }else if(passwordEdit == null) {
                    Toast.makeText(this, "please input your password", Toast.LENGTH_SHORT).show();
                } else{
                    login();
                };
                Log.d("1111", "its here");
                break;
            default:
                break;
        }
    }

    public void login() {
        final String username = userNameEdit.getText().toString();
        final String password = passwordEdit.getText().toString();
        Log.d("username", username);
        userInfo.setUserName(username);
        userInfo.setPassword(password);
        pd = new ProgressDialog(LoginActivity.this);
        pd.setTitle("Login");
        pd.setMessage("wait a moment");
        pd.show();
        final Gson gson = new Gson();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    OkHttpClient client = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder()
                            .add("username", userInfo.getUserName())
                            .add("password", userInfo.getPassword())
                            .build();
                    Request request = new Request.Builder()
                            .url(URL)
                            .post(requestBody)
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    //Log.d("123", responseData);
                    //Log.d("2222", "its here");
                    //parseToGSON(responseData);
                    loginInfoList = gson.fromJson(responseData, LoginInfo.class);
                    String userIdd = String.valueOf(loginInfoList.getUserid());
                    Log.d("123", userIdd);
                    if (loginInfoList != null) {
                        pd.dismiss();
                        rememberPassword(username, password);
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("userid", userIdd);
                        startActivity(intent);
                        finish();
                        Log.d("message1", "get the list");
                    } else {
                        pd.dismiss();
                        runOnUiThread(new Runnable() {
                            public void run() {
                                Toast.makeText(getApplicationContext(), "invaild username or password", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

    private void rememberPassword(String userName, String password) {
        editor = sf.edit();
        if (rememberPass.isChecked()) {
            editor.putBoolean("remember_password", true);
            editor.putString("account", userName);
            editor.putString("password", password);

        } else {
            editor.clear();
        }
        editor.commit();

    }
   /* sprivate void parseToGSON(String jsonData) {
        Gson gson = new Gson();
        LoginInfo loginInfoList = gson.fromJson(jsonData, LoginInfo.class);
        if (loginInfoList != null) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
            Log.d("message1", "get the list");
        } else {
            closeProcessDialog();
        }
    }*/
}
