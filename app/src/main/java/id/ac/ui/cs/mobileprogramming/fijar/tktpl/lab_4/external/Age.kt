package id.ac.ui.cs.mobileprogramming.fijar.tktpl.lab_4.external

import kotlin.jvm.Throws

class Age {
    @Throws(IllegalArgumentException::class)
    external fun addAge(age: Int): Int

    companion object {
        init {
            System.loadLibrary("helloworld-c")
        }
    }
}