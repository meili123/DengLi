package com.example.c.denglizimeijunqi.shujuku;

import org.litepal.crud.DataSupport;

/**
 * Created by C on 2017/10/11.
 */

public class UserData extends DataSupport {
    private String userName;                  //用户名
    private String userPwd;//用户密码
    private  String usertwoPwd;
    private int userId;                       //用户ID号

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPwd() {
        return userPwd;
    }
    public String getUsertwoPwd() { return usertwoPwd;}

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
    public void  setUsertwoPwd(String usertwoPwd){this.usertwoPwd=usertwoPwd;}

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
