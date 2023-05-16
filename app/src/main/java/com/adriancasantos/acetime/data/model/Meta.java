package com.adriancasantos.acetime.data.model;

import com.google.gson.annotations.SerializedName;


public class Meta {

    @SerializedName("title")
    String title;
    @SerializedName("description")
    String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Meta(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
