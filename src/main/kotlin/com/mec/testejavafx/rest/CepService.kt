package com.mec.testejavafx.rest

import com.mec.testejavafx.rest.dto.Address
import com.mec.testejavafx.utils.jsonToObject
import java.net.HttpURLConnection
import java.net.URL


class CepService {

    fun getAddress(cep: String): Address {
        val url = URL("https://viacep.com.br/ws/$cep/json/")

        val connection = url.openConnection() as HttpURLConnection
        var response = ""
        try {
            connection.requestMethod = "GET"
            connection.connect()


            val responseCode = connection.responseCode
            if (responseCode == HttpURLConnection.HTTP_OK) {
                response = connection.inputStream.bufferedReader().use { it.readText() }
                println("Resposta: $response")
            } else {
                println("Request falhou com o código: $responseCode")
                throw IllegalStateException("Não foi possível preencher o endereço. \nVerifique o dado digitado e tente novamente")
            }
        } finally {
            connection.disconnect()
        }
        return response.jsonToObject()
    }
}