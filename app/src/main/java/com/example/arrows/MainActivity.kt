package com.example.arrows

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import java.util.*

class MainActivity : Activity() {

    var imagePhoto: ImageView? = null
    var counter: Int = 0
    var timer: Timer? = null
    var imageArray: IntArray = intArrayOf(
        R.drawable.animal6,
        R.drawable.animal1,
        R.drawable.animal2,
        R.drawable.animal3,
        R.drawable.animal4,
        R.drawable.animal5,
    )
    var isRun = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imagePhoto = findViewById(R.id.photo)
        imagePhoto?.setImageResource(imageArray[3])
    }


    fun onClickStartStop(view: View) {
        view as ImageView
        if (!isRun) {
            startStop()
            view.setImageResource(R.drawable.button_stop)
            isRun = true
        } else {
            view.setImageResource(R.drawable.button_start)
            timer?.cancel()
            isRun = false
        }
    }


    fun startStop() {
        timer = Timer()

        timer?.schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    imagePhoto?.setImageResource(imageArray[counter])
                    counter++
                    if (counter == 6) counter = 0
                }
            }
        }, 0, 2000)
    }
}