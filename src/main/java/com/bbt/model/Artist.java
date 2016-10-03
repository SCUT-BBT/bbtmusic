package com.bbt.model;

/**
 * Created by yuan on 8/8/16.
 */
public class Artist {
    private Integer id;
    private String name;
    private String sex;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }
}
