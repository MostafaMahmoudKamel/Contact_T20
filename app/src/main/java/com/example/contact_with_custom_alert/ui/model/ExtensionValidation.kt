package com.example.contact_with_custom_alert.ui.model

fun Contact.validateInput():Boolean{
    return this.name.isNotEmpty()&&this.phone.isNotEmpty()&&this.address.isNotEmpty()
}