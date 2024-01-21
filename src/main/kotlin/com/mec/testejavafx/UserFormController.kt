package com.mec.testejavafx

import com.mec.testejavafx.utils.capitalizeFirstLetter
import javafx.fxml.FXML
import javafx.geometry.Insets
import javafx.scene.control.Alert
import javafx.scene.control.TextField
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.CornerRadii
import javafx.scene.paint.Paint

class UserFormController {
    @FXML
    private lateinit var nome: TextField
    @FXML
    private lateinit var email: TextField
    @FXML
    private lateinit var endereco: TextField
    @FXML
    private lateinit var telefone: TextField
    @FXML
    private lateinit var veiculo: TextField
    @FXML
    private lateinit var placa: TextField

    @FXML
    private fun onCadastrarButtonClick() {
        submitAction()
        nome.text = "vc foi hackeado"
//        nomeField.background = Background(BackgroundFill(Paint.valueOf("blue"), CornerRadii(3.0), Insets(2.0)))
        email.text = "vc foi hackeado"
        endereco.text = "vc foi hackeado"
        telefone.text = "vc foi hackeado"
        veiculo.text = "vc foi hackeado"
        placa.text = "vc foi hackeado"
    }

    @FXML
    private fun submitAction() {
        if (validateFields()) {
            val nome = nome.text
            val email = email.text
            val endereco = endereco.text
            val telefone = telefone.text
            val veiculo = veiculo.text
            val placa = placa.text

            // Aqui você pode processar ou salvar os dados capturados
            println("Dados Capturados: ")
            println("Nome: $nome")
            println("E-mail: $email")
            println("Endereço: $endereco")
            println("Telefone: $telefone")
            println("Veículo: $veiculo")
            println("Placa: $placa")
        }
    }

    private fun validateFields(): Boolean {
        val fields = mapOf(
            nome to "Nome",
            email to "E-mail",
            endereco to "Endereço",
            telefone to "Telefone",
            veiculo to "Veículo",
            placa to "Placa"
        )

        val emptyFields = fields.filter { it.key.text.isBlank() }.values

        return when {
            emptyFields.isEmpty() -> true
            emptyFields.size == 1 -> {
                showAlert("O campo '${emptyFields.first()}' não foi preenchido")
                false
            }
            else -> {
                showAlert("Os campos '${emptyFields.joinToString(", ")}' não foram preenchidos")
                false
            }
        }
    }

    private fun showAlert(message: String) {
        val alert = Alert(Alert.AlertType.ERROR)
        alert.title = "Erro de Validação"
        alert.headerText = null
        alert.contentText = message
        alert.showAndWait()
    }

}


