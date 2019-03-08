package com.example.practicante3.wsvehiculoedwin;

import android.content.Context;
import android.support.annotation.NonNull;

import com.apm.request.abstracts.RequestModel;
import com.apm.request.models.RequestConfiguration;

import java.io.Serializable;
import java.util.List;

public class ContactModel extends RequestModel<ContactModel> implements Serializable {

    private String id;
    private String name;
    private String email;
    private String address;
    private String gender;
    private List<PhoneModel>phone;


    public ContactModel(@NonNull Context context) {
        super(context);
    }

    public ContactModel(@NonNull Context context, @NonNull RequestConfiguration requestConfiguration) {
        super(context, requestConfiguration);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<PhoneModel> getPhone() {
        return phone;
    }

    public void setPhone(List<PhoneModel> phone) {
        this.phone = phone;
    }
}
