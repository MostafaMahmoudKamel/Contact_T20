package com.example.contact_with_custom_alert.ui.model

import com.example.contact_with_custom_alert.R

fun listOfContact(): List<Contact> {
    var contacts: MutableList<Contact> = mutableListOf()
    contacts.add(Contact("Mostafa", "010107017", "Egypt", R.drawable.img2))
    contacts.add(Contact("Ahmed", "010133307017", "Egypt",R.drawable.h1))
    contacts.add(Contact("Mohamed", "", "Tak",R.drawable.img2))
    contacts.add(Contact("Kamel", "017770107017", "Cairo",R.drawable.orange))
    contacts.add(Contact("Abod", "010976107017", "Egypt",R.drawable.mango))
    contacts.add(Contact("Desha", "01010724017", "Cairo",R.drawable.panana))
    contacts.add(Contact("Abod", "010105727017", "Talkha",R.drawable.strawberry))
    contacts.add(Contact("yaho", "010157307017", "",R.drawable.watermelon))
    contacts.add(Contact("Ali", "010107256017", "Egypt",R.drawable.panana))
    contacts.add(Contact("Alaa", "05510107017", "Cairo",R.drawable.strawberry))
    contacts.add(Contact("Tarek", "0150107017", "Giza",R.drawable.mango))
    contacts.add(Contact("Awad", "015550107017", "Aswan",R.drawable.orange))
    return contacts
}
