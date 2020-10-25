package com.dmytro.kuchura.cityplaces;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;
import com.dmytro.kuchura.cityplaces.adapters.OnBoardingAdapter;
import com.dmytro.kuchura.cityplaces.models.OnBoardingItem;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class OnBoardingActivity extends AppCompatActivity {

    private OnBoardingAdapter onBoardingAdapter;
    private LinearLayout layoutOnBoardingIndicators;
    private MaterialButton buttonOnBoardingActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        layoutOnBoardingIndicators = findViewById(R.id.layoutOnBoardingIndicators);
        buttonOnBoardingActivity = findViewById(R.id.buttonOnBoardingAction);

        setupOnBoardingItems();

        final ViewPager2 onBoardingViewPager = findViewById(R.id.onBoardingViewPager);
        onBoardingViewPager.setAdapter(onBoardingAdapter);

        setupOnBoardingIndicators();

        setCurrentOnBoardingIndicator(0);

        onBoardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnBoardingIndicator(position);
            }
        });

        buttonOnBoardingActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onBoardingViewPager.getCurrentItem() + 1 < onBoardingAdapter.getItemCount()) {
                    onBoardingViewPager.setCurrentItem(onBoardingViewPager.getCurrentItem() + 1);
                } else {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
            }
        });
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

    private void setupOnBoardingIndicators() {
        ImageView[] indicators = new ImageView[onBoardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        layoutParams.setMargins(8, 0, 8, 0);

        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(),
                    R.drawable.on_boarding_indicator_inactive
            ));

            indicators[i].setLayoutParams(layoutParams);
            layoutOnBoardingIndicators.addView(indicators[i]);
        }
    }

    private void setCurrentOnBoardingIndicator(int index) {
        int childCount = layoutOnBoardingIndicators.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) layoutOnBoardingIndicators.getChildAt(i);

            if (i == index) {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.on_boarding_indicator_active)
                );
            } else {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.on_boarding_indicator_inactive)
                );
            }
        }

        if (index == onBoardingAdapter.getItemCount() - 1) {
            buttonOnBoardingActivity.setText("Start");
        } else {
            buttonOnBoardingActivity.setText("Next");
        }
    }
}