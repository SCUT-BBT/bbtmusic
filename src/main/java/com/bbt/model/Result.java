package com.bbt.model;

import java.util.HashMap;
import java.util.Map;

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

    /**
     * 给Result添加新的键值对,前提是Result的data是null或者Map
     * @param key
     * @param value
     * @return true-添加成功, false-添加失败
     */
    public boolean addData(String key,Object value){
        Map<String,Object> data=null;
        Object o=this.get(keyData);
        if(o==null)
            data=new HashMap<String,Object>();
        else if(o instanceof Map){
            data=(Map<String,Object>)o;
        }
        if(data==null)
            return false;
        data.put(key,value);
        this.put(keyData,data);
        return true;
    }
}
