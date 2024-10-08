package com.example.kotlinapp23

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.VideoView
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [second.newInstance] factory method to
 * create an instance of this fragment.
 */
class second : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_second, container, false)

        button = view.findViewById(R.id.button_2);

        button.setOnClickListener {
            findNavController().navigate(R.id.action_second_to_third)
        }

        var videoView: VideoView = view.findViewById(R.id.videoView);

        videoView.setVideoPath("android.resource://"+ view.context.packageName +"/raw/pvz")
        videoView.start();

        var button2 = view.findViewById<Button>(R.id.button_2_1);

        button2.setOnClickListener { view ->

            val newFragment = third()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, newFragment)
                .addToBackStack(null) // Optional: Add to back stack for navigation
                .commit()
        }
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
         * @return A new instance of fragment second.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            second().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}