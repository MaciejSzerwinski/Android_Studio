package com.example.mycontactlist.data

import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import com.example.mycontactlist.R
import java.util.ArrayList
import java.util.concurrent.ThreadLocalRandom

fun getImg(): Int {
    val random_value: Int = ThreadLocalRandom.current().nextInt(1,16)
    return when(random_value){
        1 -> R.drawable.avatar_1
        2 -> R.drawable.avatar_2
        3 -> R.drawable.avatar_3
        4 -> R.drawable.avatar_4
        5 -> R.drawable.avatar_5
        6 -> R.drawable.avatar_6
        7 -> R.drawable.avatar_7
        8 -> R.drawable.avatar_8
        9 -> R.drawable.avatar_9
        10 -> R.drawable.avatar_10
        11 -> R.drawable.avatar_11
        12 -> R.drawable.avatar_12
        13 -> R.drawable.avatar_13
        14 -> R.drawable.avatar_14
        15 -> R.drawable.avatar_15
        16 -> R.drawable.avatar_16
        else -> R.drawable.avatar_1
    }
}

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