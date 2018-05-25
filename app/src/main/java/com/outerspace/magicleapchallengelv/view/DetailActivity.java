package com.outerspace.magicleapchallengelv.view;

import com.bumptech.glide.Glide;
import com.outerspace.magicleapchallengelv.R;
import com.outerspace.magicleapchallengelv.api.CoffeeMenuItem;
import com.outerspace.magicleapchallengelv.api.CoffeeMenuItemWrapper;
import com.outerspace.magicleapchallengelv.databinding.ActivityDetailBinding;
import com.outerspace.magicleapchallengelv.viewmodel.DetailActivityViewModel;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity implements DetailViewInterface {
    public static final String COFFEE_ID = "coffeeId";

    private String coffeeId;
    private DetailActivityViewModel viewModel;
    private ActivityDetailBinding binding;
    private CoffeeMenuItemWrapper coffeeItem = new CoffeeMenuItemWrapper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil
                .setContentView(this, R.layout.activity_detail);
        binding.setCoffeeItem(coffeeItem);

        Intent intent = getIntent();
        coffeeId = intent.getStringExtra(COFFEE_ID);
        viewModel = new DetailActivityViewModel(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewModel.fetchCoffeeItem(coffeeId);
    }

    @Override
    public void onSelCoffeeReady(CoffeeMenuItem coffeeMenuItem) {
        this.coffeeItem.setId(coffeeMenuItem.id);
        this.coffeeItem.setDesc(coffeeMenuItem.desc);
        this.coffeeItem.setImageUrl(coffeeMenuItem.imageUrl);
        this.coffeeItem.setName(coffeeMenuItem.name);
        this.coffeeItem.setLastUpdatedAt(coffeeMenuItem.lastUpdatedAt);
        Glide.with(this.getBaseContext())
                .load(coffeeMenuItem.imageUrl)
                .into(binding.detailImage);
    }

    @Override
    public void onSelCoffeeError(String message) {

    }
}
