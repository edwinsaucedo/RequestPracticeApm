package com.example.practicante3.wsvehiculoedwin;

import android.content.Context;
import android.support.annotation.NonNull;

import com.apm.request.abstracts.RequestModel;
import com.apm.request.models.RequestConfiguration;

public class AddressModel extends RequestModel<AddressModel> {

    public String adminCode2;
    public String adminCode1;
    public String lng;
    public String distance;
    public String streetNumber;
    public String mtfcc;
    public String placename;
    public String adminName2;
    public String street;
    public String postalcode;
    public String countryCode;
    public String adminName1;
    public String lat;

    public AddressModel(@NonNull Context context) {
        super(context);
    }

    public AddressModel(@NonNull Context context, @NonNull RequestConfiguration requestConfiguration) {
        super(context, requestConfiguration);
    }

    public String getAdminCode2() {
        return adminCode2;
    }

    public void setAdminCode2(String adminCode2) {
        this.adminCode2 = adminCode2;
    }

    public String getAdminCode1() {
        return adminCode1;
    }

    public void setAdminCode1(String adminCode1) {
        this.adminCode1 = adminCode1;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getMtfcc() {
        return mtfcc;
    }

    public void setMtfcc(String mtfcc) {
        this.mtfcc = mtfcc;
    }

    public String getPlacename() {
        return placename;
    }

    public void setPlacename(String placename) {
        this.placename = placename;
    }

    public String getAdminName2() {
        return adminName2;
    }

    public void setAdminName2(String adminName2) {
        this.adminName2 = adminName2;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getAdminName1() {
        return adminName1;
    }

    public void setAdminName1(String adminName1) {
        this.adminName1 = adminName1;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
}
