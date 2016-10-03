package com.bbt.model;

import com.yuan.validation.constraints.Pattern;

/**
 * Created by yuan on 10/2/16.
 */
public class User {

    @Pattern(regexp = ".*")
    private String userName;

    @Pattern(regexp = ".*")
    private String password;


    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {

        return password;
    }

    public String getUserName() {
        return userName;
    }


}
