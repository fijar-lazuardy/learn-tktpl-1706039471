package id.ac.ui.cs.mobileprogramming.fijar.tktpl.lab_2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import id.ac.ui.cs.mobileprogramming.fijar.tktpl.R
import kotlinx.android.synthetic.main.activity_degree_converter.*
import java.math.RoundingMode
import java.text.DecimalFormat

class DegreeConverterActivity: AppCompatActivity(), DegreeCalculator {
    private lateinit var presenter: DegreeCalculatorPresenter
    private lateinit var convertButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_degree_converter)

        var degreeInput = findViewById<EditText>(R.id.degreeInput)
        val convertedDegree = findViewById<TextView>(R.id.converted_degree)
        convertButton = findViewById(R.id.degree_convert_button)
        convertButton.setOnClickListener{
            convertedDegree.text = convertDegree()
        }
        presenter = DegreeCalculatorPresenter(this, DegreeModel())
    }

    override fun convertDegree(): String {
        return presenter.convertDegree(degreeInput.text.toString())
    }
}
