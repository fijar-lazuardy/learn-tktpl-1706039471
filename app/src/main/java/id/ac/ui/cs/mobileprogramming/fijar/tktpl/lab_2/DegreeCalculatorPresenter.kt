package id.ac.ui.cs.mobileprogramming.fijar.tktpl.lab_2

import android.widget.Toast

class DegreeCalculatorPresenter(private var degreeCalculator: DegreeCalculator?, private var degreeModel: DegreeModel) : DegreeModel.OnConvertFinishedListener {

    override fun onSuccess() {

    }

    fun convertDegree(celsius: Double): Double {
        return degreeModel.convertDegree(celsius)
    }

    fun onDestroy() {
        degreeCalculator = null
    }
}