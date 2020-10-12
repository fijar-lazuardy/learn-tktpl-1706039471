package id.ac.ui.cs.mobileprogramming.fijar.tktpl.lab_4.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import id.ac.ui.cs.mobileprogramming.fijar.tktpl.R
import id.ac.ui.cs.mobileprogramming.fijar.tktpl.lab_4.Lab4Activity
import id.ac.ui.cs.mobileprogramming.fijar.tktpl.lab_4.view_model.SharedViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [InputPersonFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InputPersonFragment : Fragment() {
    private lateinit var viewModel: SharedViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        val view = inflater.inflate(R.layout.fragment_input_person, container, false)
        val personName: TextView = view.findViewById(R.id.name_input)
        val personAge: TextView = view.findViewById(R.id.age_input)
        val button: Button = view.findViewById(R.id.submit_button)
        button.setOnClickListener{
            viewModel.submitNameAndAge(personName.text.toString(), personAge.text.toString())
            val fragment = ResultPersonFragment()
            fragment.arguments = arguments
            val ft = fragmentManager?.beginTransaction()
            ft?.addToBackStack(null)
            ft?.replace(R.id.fragment_holder, fragment)
            ft?.commit()
        }
        return view
    }
}