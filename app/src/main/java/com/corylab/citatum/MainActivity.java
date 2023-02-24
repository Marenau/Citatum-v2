package com.corylab.citatum;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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
        binding.dateText.setText(R.string.current_date);
        binding.transmittedText.setText(R.string.default_text);
        binding.quoteEditText.setHint(R.string.write_text_request);

        binding.intentButton.setText(R.string.add_button);

        binding.image.setImageResource(R.drawable.colors);
    }

    public void onButtonClick(View view) {
        Log.i("Citatum", "Button is pressed!");
        Intent intent = new Intent(this, RepositoryActivity.class);
        intent.putExtra("Text", binding.quoteEditText.getText());
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            String resultText = data.getStringExtra("resultText");
            binding.transmittedText.setText(resultText);
        }
    }
}