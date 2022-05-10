package com.example.mycontactlist.data

import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import com.example.mycontactlist.R
import java.util.ArrayList

object Contacts {

    val ITEMS: MutableList<ContactItem> = ArrayList()


    private val COUNT = 10

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addContact(createPlaceholderItem(i))
        }
    }

    fun addContact(item: ContactItem) {
        ITEMS.add(item)
        Log.i("ADD CONTACT", item.id.toString())
    }

    private fun createPlaceholderItem(position: Int): ContactItem {
        return ContactItem(position.toString(), "Item " + position, "Bitrh " + position,
                           "Phone_number " + position, getImg())
    }

    private fun getImg(): Int {
        return R.drawable.avatar_1
    }
}

data class ContactItem(val id: String, val name: String,val birthday: String, val phoneNumber: String, val genImg: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()
    ) {
    }

    override fun toString(): String = name
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(birthday)
        parcel.writeString(phoneNumber)
        parcel.writeInt(genImg)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ContactItem> {
        override fun createFromParcel(parcel: Parcel): ContactItem {
            return ContactItem(parcel)
        }

        override fun newArray(size: Int): Array<ContactItem?> {
            return arrayOfNulls(size)
        }
    }
}