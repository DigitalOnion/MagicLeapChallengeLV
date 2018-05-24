package com.outerspace.magicleapchallengelv.view;

import java.util.List;

import com.outerspace.magicleapchallengelv.R;
import com.outerspace.magicleapchallengelv.api.CoffeeMenu;
import com.outerspace.magicleapchallengelv.api.CoffeeMenuItem;
import com.outerspace.magicleapchallengelv.model.CoffeeModel;
import com.outerspace.magicleapchallengelv.viewmodel.MainActivityViewModel;
import com.outerspace.magicleapchallengelv.viewmodel.MenuCallback;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainViewInterface {

    MainActivityViewModel viewModel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new MainActivityViewModel(this);
    }



    public void onClickTestButton(View view) {
        viewModel.fetchCoffeeMenu();
    }

    @Override
    public void onCoffeeMenuListReady(List<CoffeeMenu> coffeeMenuList) {
        StringBuilder sb = new StringBuilder();
        for(CoffeeMenu menu : coffeeMenuList) {
            sb.append(menu.name).append('\n');
        }

        TextView txt = findViewById(R.id.txt_test);
        txt.setText(sb.toString());
    }

    @Override
    public void onCoffeeMenuListError(String message) {
        TextView txt = findViewById(R.id.txt_test);
        txt.setText(message);
    }

}
