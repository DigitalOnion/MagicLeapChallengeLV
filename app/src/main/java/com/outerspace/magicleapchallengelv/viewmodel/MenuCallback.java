package com.outerspace.magicleapchallengelv.viewmodel;

import java.util.List;

import com.outerspace.magicleapchallengelv.api.CoffeeMenu;
import com.outerspace.magicleapchallengelv.api.CoffeeMenuItem;

public interface MenuCallback {

    public void onCoffeeMenuResponse(List<CoffeeMenu> coffeeMenuList);

    public void onCoffeeMenuItemResponse(CoffeeMenuItem coffeeMenuItem);

    public void onDataError(String message);

}
