package com.bbt.authorization.model;

/**
 * Created by yuan on 10/4/16.
 */
public class UserInfo {
    private int userId;

    public UserInfo(int userId){
        this.userId=userId;
    }

    public UserInfo(){}


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
