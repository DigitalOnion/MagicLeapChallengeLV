package com.outerspace.magicleapchallengelv.viewmodel;

import java.util.List;

import com.outerspace.magicleapchallengelv.R;
import com.outerspace.magicleapchallengelv.api.CoffeeMenu;
import com.outerspace.magicleapchallengelv.api.CoffeeMenuItem;
import com.outerspace.magicleapchallengelv.model.CoffeeModel;
import com.outerspace.magicleapchallengelv.model.CoffeeModelInterface;
import com.outerspace.magicleapchallengelv.view.MainViewInterface;

import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.TextView;

public class MainActivityViewModel {
    MainViewInterface view = null;

    CoffeeModelInterface model;

    public MainActivityViewModel(MainViewInterface view) {
        this.view = view;
        model = new CoffeeModel(
                new MyMenuCallback(view)
        );
    }

    public void fetchCoffeeMenu() {
        model.requestCoffeeMenu();
    }

    private class MyMenuCallback implements  MenuCallback {
        private MainViewInterface view;

        public MyMenuCallback(MainViewInterface view) {
            this.view = view;
        }

        @Override
        public void onCoffeeMenuResponse(List<CoffeeMenu> coffeeMenuList) {
            view.onCoffeeMenuListReady(coffeeMenuList);
        }

        @Override
        public void onCoffeeMenuItemResponse(CoffeeMenuItem coffeeMenuItem) { }

        @Override
        public void onDataError(String message) {
            view.onCoffeeMenuListError(message);
        }
    }



}
