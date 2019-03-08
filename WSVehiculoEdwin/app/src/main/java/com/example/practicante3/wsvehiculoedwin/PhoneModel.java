package com.example.practicante3.wsvehiculoedwin;

import android.content.Context;
import android.support.annotation.NonNull;

import com.apm.request.models.RequestConfiguration;

public class PhoneModel {
    public String mobile;
    public String home;
    public String office;


    public PhoneModel(String mobile, String home, String office) {
        this.mobile = mobile;
        this.home = home;
        this.office = office;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }
}
