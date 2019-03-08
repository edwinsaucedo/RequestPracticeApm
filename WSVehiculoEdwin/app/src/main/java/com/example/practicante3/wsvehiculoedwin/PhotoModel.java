package com.example.practicante3.wsvehiculoedwin;

import android.content.Context;
import android.support.annotation.NonNull;

import com.apm.request.abstracts.RequestModel;
import com.apm.request.models.RequestConfiguration;

import java.io.Serializable;

public class PhotoModel extends RequestModel<PhotoModel> implements Serializable {

    //region VARS
    private int albumId;
    private int id;
    private String title;
    private String url;
    private String thumbnailUrl;
    //endregion

    //region CONSTRUCTORS
    public PhotoModel(@NonNull Context context) {
        super(context);
    }

    public PhotoModel(@NonNull Context context, @NonNull RequestConfiguration requestConfiguration) {
        super(context, requestConfiguration);
    }
    //endregion

    //region GETTERS & SETTERS

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) { this.albumId = albumId; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
    //endregion

}
