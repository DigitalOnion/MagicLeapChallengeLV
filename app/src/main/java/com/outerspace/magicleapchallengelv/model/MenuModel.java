package com.outerspace.magicleapchallengelv.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.outerspace.magicleapchallengelv.api.CoffeeMenu;
import com.outerspace.magicleapchallengelv.api.CoffeeMenuItem;
import com.outerspace.magicleapchallengelv.viewmodel.MenuCallback;
import com.outerspace.magicleapchallengelv.api.CoffeeApi;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MenuModel {

    public static final String INVALID_RESPONSE = "invalid_response";

    private Gson gson = null;
    private Retrofit retrofit = null;
    private CoffeeApi api = null;

    private MenuCallback callback;

    private CompositeDisposable disposables = new CompositeDisposable();

    public MenuModel(MenuCallback callback) {
        this.callback = callback;

        gson = new GsonBuilder()
                .setLenient()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        RxJava2CallAdapterFactory adapter =
                RxJava2CallAdapterFactory.create();

        retrofit = new Retrofit.Builder()
                .baseUrl(CoffeeApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(adapter)
                .build();

        api = retrofit.create(CoffeeApi.class);
    }

    public void requestCoffeeMenu() {
        Single<List<CoffeeMenu>> single =
                api.apiRequestCoffeeMenu();         // query does not need arguments

        Disposable disposable = single
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorReturnItem(new ArrayList<>())
                .subscribe(
                        response -> {
                            if(response.size() > 0)
                                callback.onCoffeeMenuResponse(response);
                            else
                                callback.onDataError(INVALID_RESPONSE);
                        }
                );

        disposables.add(disposable);
    }

    public void requestCoffeeItem(String itemId) {
        Single<CoffeeMenuItem> single =
                api.apiRequestCoffeeMenuItem(itemId);   // query with one argument

        Disposable disposable = single
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorReturnItem(new CoffeeMenuItem())
                .subscribe(
                        response -> {
                            if(response.id == null || response.id.length() == 0)
                                callback.onDataError(INVALID_RESPONSE);
                            else
                                callback.onCoffeeMenuItemResponse(response);
                        }
                );

        disposables.add(disposable);
    }
}
