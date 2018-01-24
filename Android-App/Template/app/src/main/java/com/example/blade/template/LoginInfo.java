package com.example.blade.template;

/**
 * Created by Blade on 2017/12/28.
 */

public class LoginInfo {

    private String username;

    private String password;

    private  int userid;

    public int getUserid() {return userid;}

    public void setUserid(int userid) {this.userid = userid;}

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
