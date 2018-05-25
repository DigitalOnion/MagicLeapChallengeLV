package com.outerspace.magicleapchallengelv.viewmodel;

import java.util.List;

import com.outerspace.magicleapchallengelv.api.CoffeeMenu;
import com.outerspace.magicleapchallengelv.api.CoffeeMenuItem;
import com.outerspace.magicleapchallengelv.model.CoffeeModel;
import com.outerspace.magicleapchallengelv.model.CoffeeModelInterface;
import com.outerspace.magicleapchallengelv.view.DetailViewInterface;

public class DetailActivityViewModel {
    DetailViewInterface view = null;

    CoffeeModelInterface model;

    public DetailActivityViewModel(DetailViewInterface view) {
        this.view = view;
        model = new CoffeeModel(
                new MyMenuCallback(view)
        );
    }

    public void fetchCoffeeItem(String coffeeId) {
        model.requestCoffeeItem(coffeeId);
    }

    private class MyMenuCallback implements  MenuCallback {
        private DetailViewInterface view;

        public MyMenuCallback(DetailViewInterface view) {
            this.view = view;
        }

        @Override
        public void onCoffeeMenuResponse(List<CoffeeMenu> coffeeMenuList) { }

        @Override
        public void onCoffeeMenuItemResponse(CoffeeMenuItem coffeeMenuItem) {
            view.onSelCoffeeReady(coffeeMenuItem);
        }

        @Override
        public void onDataError(String message) {
            view.onSelCoffeeError(message);
        }
    }



}
