package com.example.mycontactlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mycontactlist.data.Contacts
import com.example.mycontactlist.databinding.FragmentItemListBinding

/**
 * A fragment representing a list of Items.
 */
class ContactFragment : Fragment() {
    private lateinit var binding: FragmentItemListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemListBinding.inflate(inflater,container, false)

        // Set the adapter
        with(binding.list){
            layoutManager = LinearLayoutManager(context)
            adapter = MyContactRecyclerViewAdapter(Contacts.ITEMS)
        }

        binding.addButton.setOnClickListener { addButtonClick() }
        return binding.root
    }

    private fun addButtonClick() {
        findNavController().navigate(R.id.action_contactFragment_to_addContactFragment)
    }
}