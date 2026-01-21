package com.example.beginelementuiapp;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvSample, tvRatingResult;
    private SeekBar sbSize;
    private Switch swVisibility;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Powiązanie widoków
        tvSample = findViewById(R.id.tvSample);
        tvRatingResult = findViewById(R.id.tvRatingResult);
        sbSize = findViewById(R.id.sbSize);
        swVisibility = findViewById(R.id.swVisibility);
        ratingBar = findViewById(R.id.ratingBar);

        // 2. Obsługa SeekBar (Zmiana rozmiaru tekstu)
        sbSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // progress to wartość od 0 do 50.
                // Aby tekst nie zniknął całkowicie, dodajmy bazową wielkość np. 10.
                float newSize = progress + 10;
                tvSample.setTextSize(newSize);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Opcjonalne: np. zmiana koloru na czas przesuwania
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Opcjonalne: np. zapisanie ustawienia do bazy
            }
        });

        // 3. Obsługa Switch (Widoczność)
        swVisibility.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tvSample.setVisibility(View.VISIBLE);
                    swVisibility.setText("Tekst widoczny");
                } else {
                    tvSample.setVisibility(View.INVISIBLE);
                    swVisibility.setText("Tekst ukryty");
                }
            }
        });

        // 4. Obsługa RatingBar (Ocena)
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                tvRatingResult.setText("Ocena: " + rating + "/5");

                // Przykład reakcji na ocenę
                if (rating >= 4) {
                    tvRatingResult.setTextColor(Color.GREEN);
                } else {
                    tvRatingResult.setTextColor(Color.RED);
                }
            }
        });
    }
}