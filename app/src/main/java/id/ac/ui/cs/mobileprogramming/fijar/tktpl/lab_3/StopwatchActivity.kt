package id.ac.ui.cs.mobileprogramming.fijar.tktpl.lab_3

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import id.ac.ui.cs.mobileprogramming.fijar.tktpl.R

class StopwatchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stopwatch)
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


}