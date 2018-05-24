package com.outerspace.magicleapchallengelv.view;

import java.util.List;

import com.outerspace.magicleapchallengelv.api.CoffeeMenu;

public interface MainViewInterface {

    public void onCoffeeMenuListReady(List<CoffeeMenu> coffeeMenuList);

    public void onCoffeeMenuListError(String message);

}
