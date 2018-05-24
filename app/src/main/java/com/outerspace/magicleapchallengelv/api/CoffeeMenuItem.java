package com.outerspace.magicleapchallengelv.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CoffeeMenuItem {
    @SerializedName("last_updated_at")
    @Expose
    public String lastUpdatedAt;
    @SerializedName("desc")
    @Expose
    public String desc;
    @SerializedName("image_url")
    @Expose
    public String imageUrl;
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("name")
    @Expose
    public String name;
}