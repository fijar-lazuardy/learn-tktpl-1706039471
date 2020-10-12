package id.ac.ui.cs.mobileprogramming.fijar.tktpl.lab_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import id.ac.ui.cs.mobileprogramming.fijar.tktpl.R
import id.ac.ui.cs.mobileprogramming.fijar.tktpl.lab_4.ui.InputPersonFragment
import id.ac.ui.cs.mobileprogramming.fijar.tktpl.lab_4.view_model.SharedViewModel

class Lab4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lab_4)

        val fragmentManager = supportFragmentManager.beginTransaction()
        fragmentManager.add(R.id.fragment_holder, InputPersonFragment())
        fragmentManager.commit()
    }
}