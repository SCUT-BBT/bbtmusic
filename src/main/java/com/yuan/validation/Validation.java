package com.yuan.validation;

import com.yuan.validation.constraints.Pattern;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;

/**
 * Created by yuan on 10/2/16.
 */
public class Validation {
    public static ValidInfo validatePattern(Object o){
        ValidInfo validInfo=new ValidInfo();
        List<String> errors=new LinkedList<String>();
        Class c=o.getClass();
        Field[] fields=c.getDeclaredFields();
        String value=null;
        Matcher matcher=null;
        for(Field field:fields){
            Pattern pattern=field.getAnnotation(Pattern.class);
            if(pattern==null)
                continue;
            String regexp=pattern.regexp();
            boolean notNull=pattern.notNull();
            value=null;
            try {
                value= (String) field.get(o);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                continue;
            }
            if(!notNull&&value==null)
                continue;
            if(value==null){
                errors.add(field.getName());
            }else{
                matcher= java.util.regex.Pattern.compile(regexp).matcher(value);
                if(!matcher.find()){
                    errors.add(field.getName());
                }
            }

        }
        if(errors.size()>0){
            validInfo.setErrorFieldNames(errors);
            validInfo.setResult(false);
        }else{
            validInfo.setResult(true);
        }
        return validInfo;
    }
}
