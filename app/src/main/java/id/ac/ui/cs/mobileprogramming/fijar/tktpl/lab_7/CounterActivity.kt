package id.ac.ui.cs.mobileprogramming.fijar.tktpl.lab_7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import id.ac.ui.cs.mobileprogramming.fijar.tktpl.R

class CounterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)
        var current: Int = 0
        val addButton: Button = findViewById(R.id.add_button)
        val minButton: Button = findViewById(R.id.min_button)
        val counter: TextView = findViewById(R.id.counter)

        addButton.setOnClickListener{
            current = counter.text.toString().toInt() + 1
            counter.text = current.toString()
        }

        minButton.setOnClickListener{
            current = counter.text.toString().toInt() - 1
            counter.text = current.toString()
        }
    }
}