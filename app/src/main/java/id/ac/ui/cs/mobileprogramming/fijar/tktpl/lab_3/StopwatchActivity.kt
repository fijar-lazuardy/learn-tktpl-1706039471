package id.ac.ui.cs.mobileprogramming.fijar.tktpl.lab_3

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.util.Log.DEBUG
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import id.ac.ui.cs.mobileprogramming.fijar.tktpl.R
import java.util.*

class StopwatchActivity : AppCompatActivity() {
    private var second = 0
    private var isRunning: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stopwatch)

        if (savedInstanceState != null) {
            second = savedInstanceState.getInt("second")
            isRunning = savedInstanceState.getBoolean("isRunning")
        }
        runTimer()
    }

    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setMessage("Are you sure to close?")
            .setPositiveButton("YES") {
                _, _ -> super.onBackPressed()
                finish()
            }
            .setNegativeButton("NO") {
                _, _ ->
            }
            .show()
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        savedInstanceState.putInt("second", second)
        savedInstanceState.putBoolean("isRunning", isRunning)
        super.onSaveInstanceState(savedInstanceState)
    }

    fun onClickStart(v: View) {
        Log.d("on click start", "On click start is running")
        isRunning = true
    }

    fun onClickStop(v: View) {
        isRunning = false
    }

    fun onClickReset(v: View) {
        isRunning = false
        second = 0
    }

    private fun runTimer() {
        Log.d("run timer", "Run timer is running")
        val timeView = findViewById<TextView>(R.id.time_View)
        val handler = Handler(Looper.getMainLooper())
        handler.post(object: Runnable {
            override fun run() {
                val hours = (second/3600)
                val minutes = (second%3600)/60
                val secs = second%60
                val time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, secs)

                timeView.text = time

                Log.d("DEBUG", time)

                if (isRunning) {
                    second++
                    Log.d("increasing second value", second.toString())
                }
                handler.postDelayed(this, 1000)
            }
        })
    }
    
}