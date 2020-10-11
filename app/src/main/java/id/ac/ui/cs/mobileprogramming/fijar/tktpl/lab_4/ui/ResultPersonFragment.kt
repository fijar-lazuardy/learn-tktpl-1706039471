package id.ac.ui.cs.mobileprogramming.fijar.tktpl.lab_4.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.ac.ui.cs.mobileprogramming.fijar.tktpl.R
import id.ac.ui.cs.mobileprogramming.fijar.tktpl.lab_4.model.Person
import id.ac.ui.cs.mobileprogramming.fijar.tktpl.lab_4.view_model.SharedViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ResultPersonFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResultPersonFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private lateinit var goodLuckText: TextView
    private lateinit var viewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_result_person, container, false)
        goodLuckText = view.findViewById(R.id.good_luck_text)
        viewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        val args = arguments
        viewModel.submittedPerson.observe(viewLifecycleOwner, Observer<Person> {
            var lifeText = ""
            lifeText = when {
                it.age < 20 ->
                    "teenager life"
                it.age < 30 -> {
                    "20's"
                }
                else -> {
                    "adult life"
                }
            }
            val textToBeDisplayed = "Good Luck %s on your %s".format(it.name, lifeText)
            goodLuckText.text = textToBeDisplayed
        })

                // Inflate the layout for this fragment
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ResultPersonFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ResultPersonFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}