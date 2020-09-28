package id.ac.ui.cs.mobileprogramming.fijar.tktpl.lab_2

import java.math.RoundingMode
import java.text.DecimalFormat

class DegreeModel {

    interface OnConvertFinishedListener {
        fun onSuccess()
    }

    fun convertDegree(celsius: Double): Double {
        return (celsius / 5 * 9) + 32
    }

    fun degreeToDisplayOnUI(degreeFromUI: String): String {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.CEILING
        return df.format(convertDegree(degreeFromUI.toDouble())).toString() + "\u00B0F"
    }
}