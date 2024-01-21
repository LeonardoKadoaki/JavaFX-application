package com.mec.testejavafx.utils

fun String.capitalizeFirstLetter(): String {
    if (this.isEmpty()) return this
    return this.first().uppercase() + this.substring(1)
}