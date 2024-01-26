package com.mec.testejavafx.utils

fun String.capitalizeFirstLetter(): String {
    if (this.isEmpty()) return this
    return this.first().uppercase() + this.substring(1)
}

fun cpfFormat(cpf: String): String {
    return cpf.substring(0, 3) + "." +
            cpf.substring(3, 6) + "." +
            cpf.substring(6, 9) + "-" +
            cpf.substring(9, 11)
}

fun plateFormat(plate: String): String {
    return plate.substring(0, 3) + "-" +
            plate.substring(3, 7)
}

fun phoneFormat(phone: String): String {
    return if (phone.length == 11)
        "(" + phone.substring(0, 2) + ") " +
                phone.substring(2, 7) + "-" +
                phone.substring(7, 11)
    else
        "(" + phone.substring(0, 2) + ") " +
                phone.substring(2, 6) + "-" +
                phone.substring(6, 10)
}