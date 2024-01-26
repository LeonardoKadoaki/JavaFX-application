package com.mec.testejavafx.domain

import com.mec.testejavafx.rest.dto.Address

data class User (
    val nome: String,
    val cpf: String,
    val email: String,
    val telefone: String,
    val endereco: Address?
)