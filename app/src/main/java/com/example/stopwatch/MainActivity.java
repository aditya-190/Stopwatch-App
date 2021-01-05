package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Chronometer;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    Chronometer stopWatchTime;
    LottieAnimationView buttonPlayPause, stopWatchAnimation;
    boolean isPause = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPlayPause = findViewById(R.id.buttonPlayPause);
        stopWatchAnimation = findViewById(R.id.stopWatchAnimation);
        stopWatchTime = findViewById(R.id.stopWatchTime);

        buttonPlayPause.setOnClickListener(v -> {
            isPause = !isPause;
            if (isPause) {
                stopWatchTime.setBase(SystemClock.elapsedRealtime());
                stopWatchTime.start();

                buttonPlayPause.setSpeed(2f);
                buttonPlayPause.playAnimation();

                stopWatchAnimation.setSpeed(0.1f);
                stopWatchAnimation.postDelayed(() -> stopWatchAnimation.playAnimation(), 100);

            } else {
                stopWatchTime.stop();

                buttonPlayPause.setSpeed(-2f);
                buttonPlayPause.playAnimation();

                stopWatchAnimation.setSpeed(0.1f);
                stopWatchAnimation.postDelayed(() -> stopWatchAnimation.pauseAnimation(), 100);
            }
        });
    }
}