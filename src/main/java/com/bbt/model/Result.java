package com.bbt.model;

import java.util.HashMap;

/**
 * Created by yuan on 7/29/16.
 */
public class Result extends HashMap<String,Object>{
    public static final String keyStatusCode="statusCode";
    public static final Integer statusCode_Ok=1;
    public static final Integer getStatusCode_Fail=0;

    public static final String keyData="data";

    public Result(){
        this.put(keyStatusCode,getStatusCode_Fail);
    }

    public void setStatusOk(){
        this.put(keyStatusCode,statusCode_Ok);
    }
    public void setStatusFail(){
        this.put(keyStatusCode,getStatusCode_Fail);
    }

    public void setData(Object data){
        this.put(keyData,data);
    }
}
