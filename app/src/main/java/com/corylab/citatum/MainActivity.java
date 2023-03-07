package com.corylab.citatum;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.corylab.citatum.fragment.BottomNavigationFragment;
import com.corylab.citatum.fragment.HubFragment;
import com.corylab.citatum.fragment.LeftNavigationFragment;
import com.corylab.citatum.fragment.QuoteCreateFragment;
import com.corylab.citatum.fragment.RepositoryFragment;
import com.corylab.citatum.fragment.WithoutBottomNavigationFragment;

public class MainActivity extends AppCompatActivity {

    Fragment bottomHubFragment, withoutBottomNavigationFragment, hubFragment, repositoryFragment, quoteCreateFragment;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomHubFragment = new BottomNavigationFragment();
        withoutBottomNavigationFragment = new WithoutBottomNavigationFragment();
        hubFragment = new HubFragment();
        repositoryFragment = new RepositoryFragment();
        quoteCreateFragment = new QuoteCreateFragment();

        if (savedInstanceState == null)
            initFragments();
    }

    private void initFragments() {
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().setReorderingAllowed(true).add(R.id.main_fragment_container_view, HubFragment.class, null).commit();
        fragmentManager.beginTransaction().setReorderingAllowed(true).add(R.id.bottom_fragment_container_view, BottomNavigationFragment.class, null).commit();
        fragmentManager.beginTransaction().setReorderingAllowed(true).add(R.id.left_fragment_container_view, LeftNavigationFragment.class, null).commit();
    }

    public void changeFragment(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (view.getId()) {
            case R.id.return_button:
                if (hubFragment.isVisible())
                    return;
                fragmentTransaction.replace(R.id.main_fragment_container_view, hubFragment);
                break;
            case R.id.intent_button:
                if (repositoryFragment.isVisible())
                    return;
                fragmentTransaction.replace(R.id.main_fragment_container_view, repositoryFragment);
                break;
            case R.id.create_button:
                if (quoteCreateFragment.isVisible())
                    return;
                fragmentTransaction.replace(R.id.main_fragment_container_view, quoteCreateFragment);
                fragmentTransaction.replace(R.id.bottom_fragment_container_view, withoutBottomNavigationFragment);
                break;
        }

        fragmentTransaction.commit();
    }
}