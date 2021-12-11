package com.example.testapp

import android.content.Context
import android.os.Bundle
import android.system.Os.bind
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testapp.databinding.ActivityMainBinding
import com.example.testapp.databinding.ActivityMainBinding.bind

class HomeFragment : Fragment(R.layout.fragment_home) {

    //private lateinit var listener: OnFragmentClickListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        //listener = context as OnFragmentClickListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(requireContext())

        val binding = HomeFragment.bind(view)
        setContentView(binding.root)

        binding.apply {
            val prefs = getSharedPreferences("MyAppPrefs", AppCompatActivity.MODE_PRIVATE)

            if (prefs.getString("name","Ivan")?.isEmpty() == true){
                txt.text = "Sign up"
                btn.text = "Sign up"
            } else{
                txt.text = "Login"
                btn.text = "Login"
            }

            btn.setOnClickListener{
                val editor = prefs.edit()
                //editor.putString("title",txt.text.toString())
                editor.putString("name",editName.text.toString())
                editor.putString("password",editPassword.text.toString())
                editor.apply()
            }
        }

    }


}