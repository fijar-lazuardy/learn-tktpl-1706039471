package id.ac.ui.cs.mobileprogramming.fijar.tktpl.lab_4.view_model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ui.cs.mobileprogramming.fijar.tktpl.lab_4.model.Person
import java.lang.Error

class SharedViewModel: ViewModel() {
    private val personMutableList = mutableListOf<Person>()
    val submittedPerson = MutableLiveData<Person>()

    fun convertToModel(name: String, age: Int) {
        val person = Person(name, age)
    }

    fun insertToPersonList(name: String, age: Int) {
        try {
            val person = Person(name, age)
            personMutableList.add(person)
        }
        catch (e: Error) {
            Log.d("ERROR", "Error when input object")
        }
    }

    fun submitNameAndAge(name: String, ageString: String) {
        val age = ageString.toInt()
        val person = Person(name, age)
        submittedPerson.value = person
    }
}