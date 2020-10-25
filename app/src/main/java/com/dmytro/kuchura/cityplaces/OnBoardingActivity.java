package com.dmytro.kuchura.cityplaces;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.viewpager2.widget.ViewPager2;
import com.dmytro.kuchura.cityplaces.adapters.OnBoardingAdapter;
import com.dmytro.kuchura.cityplaces.models.OnBoardingItem;

import java.util.ArrayList;
import java.util.List;

public class OnBoardingActivity extends AppCompatActivity {

    private OnBoardingAdapter onBoardingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        setupOnBoardingItems();

        ViewPager2 onBoardingViewPager = findViewById(R.id.onBoardingViewPager);
        onBoardingViewPager.setAdapter(onBoardingAdapter);
    }

    private void setupOnBoardingItems() {
        List<OnBoardingItem> onBoardingItems = new ArrayList<>();

        OnBoardingItem searching = new OnBoardingItem();
        searching.setTitle("Find beautiful places");
        searching.setDescription("Find beautiful places using this app");
        searching.setImage(R.drawable.searching);

        OnBoardingItem vlog = new OnBoardingItem();
        vlog.setTitle("Find palaces for vlog");
        vlog.setDescription("Find palaces for vlog using this app");
        vlog.setImage(R.drawable.vlog);

        OnBoardingItem shopping = new OnBoardingItem();
        shopping.setTitle("Find palaces for shopping");
        shopping.setDescription("Find palaces for shopping using this app");
        shopping.setImage(R.drawable.shopping);

        onBoardingItems.add(searching);
        onBoardingItems.add(vlog);
        onBoardingItems.add(shopping);

        onBoardingAdapter = new OnBoardingAdapter(onBoardingItems);
    }
}