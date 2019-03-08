package com.example.practicante3.wsvehiculoedwin;

import com.apm.request.models.RequestConfiguration;

import java.io.Serializable;
import java.util.List;

public class Vehiculo implements Serializable {
    private int Count;
    private String Message;
    private String SearchCriteria;
    private List<Results> Results;

    public Vehiculo(MainActivity mainActivity, RequestConfiguration mRequestConfiguration) {
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getSearchCriteria() {
        return SearchCriteria;
    }

    public void setSearchCriteria(String searchCriteria) {
        SearchCriteria = searchCriteria;
    }

    public List<com.example.practicante3.wsvehiculoedwin.Results> getResults() {
        return Results;
    }

    public void setResults(List<com.example.practicante3.wsvehiculoedwin.Results> results) {
        Results = results;
    }

}

