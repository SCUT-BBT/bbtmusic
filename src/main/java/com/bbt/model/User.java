package com.bbt.model;

import com.yuan.validation.constraints.Pattern;

/**
 * Created by yuan on 10/2/16.
 */
public class User {

    //用户id
    private int id;

    //用户手机号码(也是登陆账号)
    @Pattern(regexp = "\\d+",notNull = true)
    private String phone;

    @Pattern(regexp = ".*")
    private String password;

    //昵称
    private String nickName;

    private String sex;

    private String picUrl;

    public void setId(int id) {
        this.id = id;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {

        return id;
    }

    public String getNickName() {
        return nickName;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
