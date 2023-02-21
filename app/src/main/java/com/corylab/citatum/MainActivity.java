package com.corylab.citatum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.corylab.citatum.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initIt();
    }

    private void initIt() {
        binding.pageName.setText(R.string.home_app_text);
        binding.welcomeText.setText(R.string.welcome_day_text);
        binding.dateText.setText(R.string.temp_date);
        binding.tagsText.setText(R.string.tags_text);
        binding.quoteEditText.setHint(R.string.write_text_request);

        binding.addButton.setText(R.string.add_button);
        binding.addButton.setOnClickListener(view -> Log.i("Citatum", "Button is pressed!"));

        binding.image.setImageResource(R.drawable.colors);
    }
}