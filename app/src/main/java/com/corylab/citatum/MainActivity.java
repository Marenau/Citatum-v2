package com.corylab.citatum;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.corylab.citatum.databinding.ActivityMainBinding;
import com.corylab.citatum.fragment.BottomNavigationFragment;
import com.corylab.citatum.fragment.HubFragment;
import com.corylab.citatum.fragment.LeftNavigationFragment;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null)
            initFragments();
    }

    private void initFragments() {
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().setReorderingAllowed(true).add(R.id.main_fragment_container_view, HubFragment.class, null).commit();
        fragmentManager.beginTransaction().setReorderingAllowed(true).add(R.id.bottom_fragment_container_view, BottomNavigationFragment.class, null).commit();
        fragmentManager.beginTransaction().setReorderingAllowed(true).add(R.id.left_fragment_container_view, LeftNavigationFragment.class, null).commit();
    }
}