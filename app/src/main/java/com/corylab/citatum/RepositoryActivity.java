package com.corylab.citatum;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.corylab.citatum.databinding.ActivityRepositoryBinding;

public class RepositoryActivity extends AppCompatActivity {

    private ActivityRepositoryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRepositoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initIt();
    }

    private void initIt() {
        binding.pageName.setText(R.string.repository_page);
        binding.returnButton.setText(R.string.return_button);

        Bundle argument = getIntent().getExtras();
        String text = argument.get("Text").toString();
        binding.transmissionText.setText(text);

        binding.returnButton.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.putExtra("resultText", "Первая активность");
            setResult(Activity.RESULT_OK, intent);
            finish();
        });
    }
}