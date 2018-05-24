package com.outerspace.magicleapchallengelv.api;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CoffeeApi {
    public static final String BASE_URL = "https://demo6983184.mockable.io/";
    public static final String END_POINT = "coffees";
    public static final String END_POINT_ITEM = "coffees/{coffee_id}";

    @GET(END_POINT)
    Single<List<CoffeeMenu>> apiRequestCoffeeMenu();

    @GET(END_POINT_ITEM)
    Single<CoffeeMenuItem> apiRequestCoffeeMenuItem(
            @Path("coffee_id") String coffeeID
    );
}
