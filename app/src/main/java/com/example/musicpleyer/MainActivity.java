package com.example.musicpleyer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

    private MediaPlayer mediaPlayer;
    private ImageButton playButton, pauseButton, nextButton, previousButton;
    private int currentSongIndex = 0;
    private int[] songs = {R.raw.mus2, R.raw.mus3, R.raw.music1, R.raw.mus4}; // Replace with your audio files

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, songs[currentSongIndex]);

        playButton = findViewById(R.id.imageButton9);
        pauseButton = findViewById(R.id.imageButton8);
        nextButton = findViewById(R.id.imageButton10);
        previousButton = findViewById(R.id.imageButton7);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentSongIndex < songs.length - 1) {
                    currentSongIndex++;
                } else {
                    currentSongIndex = 0;
                }
                mediaPlayer.release();
                mediaPlayer = MediaPlayer.create(MainActivity.this, songs[currentSongIndex]);
                mediaPlayer.start();
            }
        });

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentSongIndex > 0) {
                    currentSongIndex--;
                } else {
                    currentSongIndex = songs.length - 1;
                }
                mediaPlayer.release();
                mediaPlayer = MediaPlayer.create(MainActivity.this, songs[currentSongIndex]);
                mediaPlayer.start();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
/*public class MainActivity extends AppCompatActivity*/