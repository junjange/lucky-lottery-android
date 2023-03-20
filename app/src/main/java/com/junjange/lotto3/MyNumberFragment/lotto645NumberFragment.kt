package com.junjange.lotto3.MyNumberFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.junjange.lotto3.Adapter.RecyclerView645Adapter
import com.junjange.lotto3.MainViewModel
import com.junjange.lotto3.MyNumber.Lotto645Dialog
import com.junjange.lotto3.R
import com.junjange.lotto3.databinding.FragmentLotto645NumberBinding
import kotlinx.android.synthetic.main.fragment_lotto645_number.*
import kotlinx.android.synthetic.main.fragment_lotto645_number.recyclerview

class lotto645NumberFragment : Fragment() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         val binding: FragmentLotto645NumberBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_lotto645_number, container, false)
        activity?.let {


            binding.viewModel645 = viewModel
            binding.lifecycleOwner = this
        }
        return binding.root

    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        val mAdapter = RecyclerView645Adapter(requireContext(),viewModel)
        recyclerview.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        viewModel.allUsers645.observe(viewLifecycleOwner, Observer { users ->
            // Update the cached copy of the users in the adapter.
            users?.let { mAdapter.setUsers(it) }

        })

    }
        override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

            add645Btn.setOnClickListener {
                val dlg = Lotto645Dialog(requireContext())
                dlg.show()
            }


        }
}

