package com.outerspace.magicleapchallengelv.view;

import java.util.List;

import com.outerspace.magicleapchallengelv.api.CoffeeMenu;
import com.outerspace.magicleapchallengelv.api.CoffeeMenuItem;

public interface DetailViewInterface {

    public void onSelCoffeeReady(CoffeeMenuItem coffeeMenuItem);

    public void onSelCoffeeError(String message);

}
