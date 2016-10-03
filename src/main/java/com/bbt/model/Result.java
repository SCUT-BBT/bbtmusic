package com.bbt.model;

import java.util.HashMap;

/**
 * Created by yuan on 7/29/16.
 */
public class Result extends HashMap<String,Object>{
    public static final String keyCode="code";

    public static final String keyData="data";

    public Result(){
        this.put(keyCode,0);
    }

    public void setCode(int code){
        this.put(keyCode,code);
    }

    public void setData(Object data){
        this.put(keyData,data);
    }
}
