package com.outerspace.magicleapchallengelv.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CoffeeMenu {
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
