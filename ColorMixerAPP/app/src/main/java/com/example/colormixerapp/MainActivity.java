package com.example.colormixerapp;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    private SeekBar seekbBarRed, seekbBarGreen, seekbBarBlue;
    private int red = 0 , green = 0, blue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Powiązanie widoków
        seekbBarRed = findViewById(R.id.seekBarRed);
        seekbBarGreen = findViewById(R.id.seekBarGreen);
        seekbBarBlue = findViewById(R.id.seekBarBlue);
        View viewColor = findViewById(R.id.viewColor);

        // 2. Obsługa SeekBar (Zmiana rozmiaru tekstu)
        seekbBarRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                viewColor.setBackgroundColor(Color.rgb(progress,green, blue));
                red = progress;
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
        // 2. Obsługa SeekBar (Zmiana rozmiaru tekstu)
        seekbBarGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                viewColor.setBackgroundColor(Color.rgb(red,progress, blue));
                green = progress;
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
        // 2. Obsługa SeekBar (Zmiana rozmiaru tekstu)
        seekbBarBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                viewColor.setBackgroundColor(Color.rgb(red,green, progress));
                blue = progress;
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
    }
}