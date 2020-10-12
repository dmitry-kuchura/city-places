package com.dmytro.kuchura.cityplaces.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.dmytro.kuchura.cityplaces.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InstagramPlacesFragment extends Fragment {

    public InstagramPlacesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_instagram_places, container, false);
    }
}