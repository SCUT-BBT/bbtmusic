package com.bbt.authorization.model;

/**
 * Created by yuan on 10/4/16.
 */
public class Token {
    private UserInfo userInfo;
    private String tokenStr;

    public Token(){}
    public Token(String str){
        this.tokenStr=str;
        try{
            userInfo=new UserInfo(Integer.valueOf(tokenStr));
        }catch (Exception e){
            userInfo=null;
        }
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getTokenStr() {
        return tokenStr;
    }

    public void setTokenStr(String tokenStr) {
        this.tokenStr = tokenStr;
    }
}
