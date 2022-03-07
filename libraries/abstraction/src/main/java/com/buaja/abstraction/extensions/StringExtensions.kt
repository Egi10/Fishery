package com.buaja.abstraction.extensions

import java.security.MessageDigest
import java.text.NumberFormat
import java.util.*


/**
 * @created 06/03/22 19.06
 * @author Julsapargi Nursam
 * @project Fishery
 **/

fun String.formatRp(): String {
    return if (this.isEmpty()) {
        "Rp0"
    } else {
        val localeID = Locale("in", "ID")
        val formatRupiah: NumberFormat = NumberFormat.getInstance(localeID)
        "Rp${formatRupiah.format(this.toDouble())}"
    }
}

fun String.formatZero(): String {
    return this.ifEmpty {
        "0"
    }
}

fun String.removeSpaceFirst(): String {
    return if (this.isNotEmpty()) {
        if (this.first() == ' ') {
            this.replace(" ", "")
        } else {
            this
        }
    } else {
        ""
    }
}

fun String.getInitials(): String {
    var str = this.trim()
    str = str.replace("\\s+".toRegex(), " ")
    str = str.uppercase(Locale.getDefault())

    if (str.isEmpty()) {
        return "-"
    }

    if (str.length <= 2) {
        return str
    }

    var result: String = str[0].toString()

    val token = str.split(" ")
    if (token.size >= 2) {
        // Get Last Name
        val second = token[1][0]
        result += second
    } else if (this.length >= 2) {
        // If no last name, use second character of first name
        val second = str[1].toString()
        result += second
    }

    return result
}

fun String.hashString(): String {
    return MessageDigest
        .getInstance("SHA-256")
        .digest(this.toByteArray())
        .fold("") { str, it -> str + "%02x".format(it) }
}