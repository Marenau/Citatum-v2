package com.corylab.citatum.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.corylab.citatum.R;

public class HubFragment extends Fragment {

    public HubFragment() {
        super(R.layout.hub_fragment);
    }

    private void showToast(String text) {
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(getContext(), text, duration);
        toast.show();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showToast("onCreate");
        Log.i("Citatum", "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        showToast("onCreateView");
        Log.i("Citatum", "onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        showToast("onViewCreate");
        Log.i("Citatum", "onViewCreate");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        showToast("onViewStateRestored");
        Log.i("Citatum", "onViewStateRestored");
    }

    @Override
    public void onStart() {
        super.onStart();
        showToast("onStart");
        Log.i("Citatum", "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        showToast("onResume");
        Log.i("Citatum", "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        showToast("onPause");
        Log.i("Citatum", "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        showToast("onStop");
        Log.i("Citatum", "onStop");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        showToast("onSaveInstanceState");
        Log.i("Citatum", "onSaveInstanceState");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        showToast("onDestroyView");
        Log.i("Citatum", "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        showToast("onDestroy");
        Log.i("Citatum", "onDestroy");
    }
}