package com.junjange.lotto3.ui.randomnumber

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import com.junjange.lotto3.RandomNumber.Lotto720Activity
import com.junjange.lotto3.R
import com.junjange.lotto3.RandomNumber.AmericaActivity
import com.junjange.lotto3.RandomNumber.Lotto645Activity
import com.junjange.lotto3.ui.news.NewsViewModel
import kotlinx.android.synthetic.main.fragment_random_number.*

class RandomNumberFragment : Fragment() {

    private lateinit var randomnumberViewModel: RandomNumberViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        randomnumberViewModel =
            ViewModelProviders.of(this).get(RandomNumberViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_random_number, container, false)

        randomnumberViewModel.text.observe(viewLifecycleOwner) {

        }
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        Lotto645.setOnClickListener {
            activity?.let{

                val intent = Intent(context, Lotto645Activity::class.java)

                startActivity(intent)
            }

        }
        Lotto720.setOnClickListener {
            activity?.let{

                val intent = Intent(context, Lotto720Activity::class.java)

                startActivity(intent)
            }

        }
        America.setOnClickListener {
            activity?.let{

                val intent = Intent(context, AmericaActivity::class.java)

                startActivity(intent)
            }

        }

    }

}



