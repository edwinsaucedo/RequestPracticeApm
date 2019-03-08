package com.example.practicante3.wsvehiculoedwin;

import android.content.Context;
import android.support.annotation.NonNull;

import com.apm.request.abstracts.RequestModel;
import com.apm.request.models.RequestConfiguration;

import java.io.Serializable;


import java.io.Serializable;

public class Results extends RequestModel<Results> implements Serializable  {
    private String Make_ID;
    private String Make_Name;


    public Results(@NonNull Context context) {
        super(context);
    }

    public Results(@NonNull Context context, @NonNull RequestConfiguration requestConfiguration) {
        super(context, requestConfiguration);
    }

    public String getMake_ID() {
        return Make_ID;
    }

    public void setMake_ID(String make_ID) {
        Make_ID = make_ID;
    }

    public String getMake_Name() {
        return Make_Name;
    }
    public void setMake_Name(String make_Name) {
        Make_Name = make_Name;
    }
}
