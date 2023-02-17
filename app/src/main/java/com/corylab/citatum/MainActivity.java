package com.corylab.citatum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context context;
    private static final String TAG = "Citatum";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();

        showToast("onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        showToast("onStart");
        Log.e(TAG, "OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        showToast("onResume");
        Log.w(TAG, "OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        showToast("onPause");
        Log.i(TAG, "OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showToast("onStop");
        Log.d(TAG, "OnStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        showToast("onRestart");
        Log.v(TAG, "OnRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showToast("onDestroy");
        Log.wtf(TAG, "OnDestroy");
    }

    private void showToast(String text) {
        Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        toast.show();
    }
}