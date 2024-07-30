package com.bhardwaj.stopwatch

import android.os.Bundle
import android.os.SystemClock
import android.widget.Chronometer
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView

class MainActivity : AppCompatActivity() {
    private var isPause = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<LottieAnimationView>(R.id.buttonPlayPause).setOnClickListener {
            isPause = !isPause
            if (isPause) {
                findViewById<Chronometer>(R.id.stopWatchTime).let {chronometer ->
                    chronometer.base = SystemClock.elapsedRealtime()
                    chronometer.start()
                }

                findViewById<LottieAnimationView>(R.id.buttonPlayPause).let { lottie ->
                    lottie.speed = 2F
                    lottie.playAnimation()
                }

                findViewById<LottieAnimationView>(R.id.stopWatchAnimation).let { lottie ->
                    lottie.speed = 0.1F
                    lottie.postDelayed({ lottie.playAnimation() }, 100)
                }
            } else {
                findViewById<Chronometer>(R.id.stopWatchTime).stop()

                findViewById<LottieAnimationView>(R.id.buttonPlayPause).let { lottie ->
                    lottie.speed = -2F
                    lottie.playAnimation()
                }

                findViewById<LottieAnimationView>(R.id.stopWatchAnimation).let {lottie ->
                    lottie.speed = 0.1F
                    lottie.postDelayed({ lottie.pauseAnimation() }, 100)
                }
            }
        }
    }
}