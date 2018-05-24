package com.outerspace.magicleapchallengelv.view;

import java.util.List;

import com.outerspace.magicleapchallengelv.R;
import com.outerspace.magicleapchallengelv.api.CoffeeMenu;
import com.outerspace.magicleapchallengelv.api.CoffeeMenuItem;
import com.outerspace.magicleapchallengelv.model.MenuModel;
import com.outerspace.magicleapchallengelv.viewmodel.MenuCallback;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickTestButton(View view) {
        MenuCallback callback = new MenuCallback() {
            @Override
            public void onCoffeeMenuResponse(List<CoffeeMenu> coffeeMenuList) {
                StringBuilder sb = new StringBuilder();
                for(CoffeeMenu menu : coffeeMenuList) {
                    sb.append(menu.name).append('\n');
                }

                TextView txt = findViewById(R.id.txt_test);
                txt.setText(sb.toString());
            }

            @Override
            public void onCoffeeMenuItemResponse(CoffeeMenuItem coffeeMenuItem) { }

            @Override
            public void onDataError(String message) { }
        };

        MenuModel model = new MenuModel(callback);
        model.requestCoffeeMenu();
    }
}
