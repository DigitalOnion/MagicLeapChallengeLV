package com.outerspace.magicleapchallengelv.view;

import java.util.List;

import com.outerspace.magicleapchallengelv.R;
import com.outerspace.magicleapchallengelv.api.CoffeeMenu;
import com.outerspace.magicleapchallengelv.api.CoffeeMenuItem;
import com.outerspace.magicleapchallengelv.databinding.ActivityMainBinding;
import com.outerspace.magicleapchallengelv.model.CoffeeModel;
import com.outerspace.magicleapchallengelv.viewmodel.MainActivityViewModel;
import com.outerspace.magicleapchallengelv.viewmodel.MenuCallback;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainViewInterface {
    private ActivityMainBinding binding;
    private MainActivityViewModel viewModel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil
                .setContentView(this, R.layout.activity_main);
        viewModel = new MainActivityViewModel(this);
        binding.setViewModel(viewModel);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        binding.recycler.setLayoutManager(manager);
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewModel.fetchCoffeeMenu();
    }

    @Override
    public void onCoffeeMenuListReady(List<CoffeeMenu> coffeeMenuList) {
        StringBuilder sb = new StringBuilder();
        for(CoffeeMenu menu : coffeeMenuList) {
            sb.append(menu.name).append('\n');
        }

        CoffeeRecyclerAdapter adapter = new CoffeeRecyclerAdapter(coffeeMenuList);
        binding.recycler.setAdapter(adapter);

    }

    @Override
    public void onCoffeeMenuListError(String message) {
//        TextView txt = findViewById(R.id.txt_test);
//        txt.setText(message);
    }

}
