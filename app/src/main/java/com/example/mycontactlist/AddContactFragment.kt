package com.example.mycontactlist

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.example.mycontactlist.data.ContactItem
import com.example.mycontactlist.data.Contacts
import com.example.mycontactlist.databinding.FragmentAddContactBinding

/**
 * A simple [Fragment] subclass.
 * Use the [AddContactFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddContactFragment : Fragment() {

    private lateinit var binding: FragmentAddContactBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddContactBinding.inflate(inflater, container, false)
        return inflater.inflate(R.layout.fragment_add_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.saveButton.setOnClickListener {saveContact()}
    }

    private fun saveContact() {
        var personalData: String = binding.nameContact.text.toString()
        var birthday: String = binding.dateContact.text.toString()
        var phoneNumber: String = binding.phoneContact.text.toString()
        var picture: Int = 0

        //To do jesli puste sa pola nie zapisuj kontaktow

        val contactItem = ContactItem(
            {personalData}.hashCode().toString(),
            personalData,
            birthday,
            phoneNumber,
            picture
        )

        Contacts.addContact(contactItem)

        val inputMethodManager: InputMethodManager = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(binding.root.windowToken, 0)
    }
}