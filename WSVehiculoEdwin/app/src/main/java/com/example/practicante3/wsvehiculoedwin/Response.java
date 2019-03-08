package com.example.practicante3.wsvehiculoedwin;

import com.apm.request.contracts.IResponse;

public class Response<T> implements IResponse<T> {
    private String type;
    private boolean errors;
    private String exception_name;
    private int code;
    private String code_message;
    private String message;
    private T data;
    @Override
    public String getType() {
        return null;
    }

    @Override
    public boolean hasErrors() {
        return false;
    }

    @Override
    public String getExceptionName() {
        return null;
    }

    @Override
    public int getCode() {
        return 0;
    }

    @Override
    public String getCodeMessage() {
        return null;
    }

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public T getData() {
        return null;
    }

    @Override
    public <T2> T2 getData(Class<T2> aClass) {
        return null;
    }

    @Override
    public void setType(String s) {

    }

    @Override
    public void setErrors(boolean b) {

    }

    @Override
    public void setExceptionName(String s) {

    }

    @Override
    public void setCode(int i) {

    }

    @Override
    public void setCodeMessage(String s) {

    }

    @Override
    public void setMessage(String s) {

    }

    @Override
    public void setData(T t) {

    }
}
