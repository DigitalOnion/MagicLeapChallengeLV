package com.outerspace.magicleapchallengelv.api;

import com.outerspace.magicleapchallengelv.BR;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class CoffeeMenuItemWrapper extends BaseObservable {
    private CoffeeMenuItem coffee;

    public CoffeeMenuItemWrapper() {
        coffee = new CoffeeMenuItem();
    }

    @Bindable
    public String getLastUpdatedAt() {
        return coffee.lastUpdatedAt;
    }

    public void setLastUpdatedAt(String lastUpdatedAt) {
        this.coffee.lastUpdatedAt = lastUpdatedAt;
        notifyPropertyChanged(BR.lastUpdatedAt);
    }

    @Bindable
    public String getDesc() {
        return coffee.desc;
    }

    public void setDesc(String desc) {
        this.coffee.desc = desc;
        notifyPropertyChanged(BR.desc);
    }

    @Bindable
    public String getImageUrl() {
        return coffee.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.coffee.imageUrl = imageUrl;
        notifyPropertyChanged(BR.imageUrl);
    }

    @Bindable
    public String getId() {
        return coffee.id;
    }

    public void setId(String id) {
        this.coffee.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getName() {
        return coffee.name;
    }

    public void setName(String name) {
        this.coffee.name = name;
        notifyPropertyChanged(BR.name);
    }
}
