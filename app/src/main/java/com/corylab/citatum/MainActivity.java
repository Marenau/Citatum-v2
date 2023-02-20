package com.corylab.citatum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initIt();
    }

    private void initIt() {
        TextView pageText = findViewById(R.id.page_name);
        pageText.setText(R.string.home_app_text);

        TextView welcomeText = findViewById(R.id.welcome_text);
        welcomeText.setText(R.string.welcome_day_text);

        TextView dateText = findViewById(R.id.date_text);
        dateText.setText(R.string.temp_date);

        TextView tagsText = findViewById(R.id.tags_text);
        tagsText.setText(R.string.tags_text);

        ImageView image = findViewById(R.id.image);
        image.setImageResource(R.drawable.colors);
    }
}