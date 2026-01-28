package com.example.ratingbarapp;

import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private TextView tvSample, tvRatingResult;
    private SeekBar sbSize;
    private Switch swVisibility;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvRatingResult = findViewById(R.id.tvRatingResult);
        ratingBar = findViewById(R.id.ratingBar);


        // 4. Obsługa RatingBar (Ocena)
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {


                // Przykład reakcji na ocenę
                if (rating < 2.5) {
                    tvRatingResult.setTextColor(Color.RED);
                    tvRatingResult.setText("Ocena Słabo: " + rating + "/5");
                    Toast.makeText(MainActivity.this, "Słabo", Toast.LENGTH_SHORT).show();
                } else if(rating >= 2.5 && rating < 4.0) {
                    tvRatingResult.setTextColor(Color.MAGENTA);
                    tvRatingResult.setText("Ocena OK: " + rating + "/5");
                    Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
                } else {
                    tvRatingResult.setTextColor(Color.GREEN);
                    tvRatingResult.setText("Ocena Super: " + rating + "/5");
                    Toast.makeText(MainActivity.this, "Super", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}