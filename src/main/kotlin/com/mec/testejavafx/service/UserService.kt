package com.mec.testejavafx.service

import com.mec.testejavafx.domain.User

class UserService {

    fun getUser(cpf: String): User? {
        val users = listOf(
            User("Leonardo Amaral", "10123403050", "leo.kadoaki@gmail.com", "11958800871", null),
            User("Flavio Favila", "00011122233", "tb4tgb@gmail.com", "11958800871", null),
            User("Murilo Amaral", "11122233344", "345gwrtbr@gmail.com", "11958800871", null),
            User("Karina Toledo", "22233344455", "498gbh4@gmail.com", "11958800871", null),
            User("Douglas Silva", "33344455566", "0g9jg@gmail.com", "11958800871", null),
            User("Paula Leite", "44455566677", "3479rgb9utg@gmail.com", "11958800871", null),
        )
        return users.find { it.cpf == cpf }
    }
}