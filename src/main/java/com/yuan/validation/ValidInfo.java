package com.yuan.validation;

import java.util.List;

/**
 * Created by yuan on 10/2/16.
 */
public class ValidInfo {
    private List<String> errorFieldNames;
    private boolean result;

    public List<String> getErrorFieldNames() {
        return errorFieldNames;
    }

    public boolean hasError() {
        return result;
    }

    public void setErrorFieldNames(List<String> errorFieldNames) {
        this.errorFieldNames = errorFieldNames;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public ValidInfo(){}
    public ValidInfo(List<String> errorFieldNames,boolean result){
        this.errorFieldNames=errorFieldNames;
        this.result=result;
    }
}
