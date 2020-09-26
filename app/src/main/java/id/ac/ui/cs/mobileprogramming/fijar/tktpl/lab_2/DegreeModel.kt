package id.ac.ui.cs.mobileprogramming.fijar.tktpl.lab_2

class DegreeModel {

    interface OnConvertFinishedListener {
        fun onSuccess()
    }

    fun convertDegree(celsius: Double): Double {
        return (celsius / 5 * 9) + 32
    }
}