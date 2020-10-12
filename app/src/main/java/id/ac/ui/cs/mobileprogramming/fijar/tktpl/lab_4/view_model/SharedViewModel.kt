package id.ac.ui.cs.mobileprogramming.fijar.tktpl.lab_4.view_model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ui.cs.mobileprogramming.fijar.tktpl.lab_4.model.Person
import java.lang.Error

class SharedViewModel: ViewModel() {
    val submittedPerson = MutableLiveData<Person>()

    fun submitNameAndAge(name: String, ageString: String) {
        val age = ageString.toInt()
        val person = Person(name, age)
        submittedPerson.value = person
    }
}