package com.mec.testejavafx

import com.mec.testejavafx.rest.CepService
import com.mec.testejavafx.utils.showAlert
import com.mec.testejavafx.utils.validateFields
import javafx.beans.value.ChangeListener
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Alert
import javafx.scene.control.Alert.AlertType
import javafx.scene.control.Button
import javafx.scene.control.TextField
import javafx.stage.Stage

class UserFormController {
    @FXML
    private lateinit var cpf: TextField

    @FXML
    private lateinit var nome: TextField

    @FXML
    private lateinit var email: TextField

    @FXML
    private lateinit var telefone: TextField


    @FXML
    private lateinit var cep: TextField

    @FXML
    private lateinit var logradouro: TextField

    @FXML
    private lateinit var bairro: TextField

    @FXML
    private lateinit var cidade: TextField

    @FXML
    private lateinit var uf: TextField

    @FXML
    private lateinit var numero: TextField

    @FXML
    private lateinit var complemento: TextField

    @FXML
    lateinit var homeButton: Button

    @FXML
    fun initialize() {

        homeButton.setOnAction {
            homeButton.scene.window.hide()
        }

        telefone.textProperty().addListener(ChangeListener<String> { _, _, newValue ->
            var value = newValue.filter { it.isDigit() }

            when {
                value.length > 11 -> value = value.substring(0, 11)
                value.length > 6 -> value = value.replaceFirst("(\\d{2})(\\d{5})(\\d+)".toRegex(), "($1) $2-$3")
                value.length > 2 -> value = value.replaceFirst("(\\d{2})(\\d+)".toRegex(), "($1) $2")
            }

            if (value != newValue) {
                telefone.text = value

                // Posiciona o cursor para o final do texto
                telefone.positionCaret(value.length)
            }
        })
    }
    //todo corrigir o bug de voltar para a tela inicial e clicar em outra tela

    @FXML
    private fun onFindAddressButtonClick() {
        try {
            val address = CepService().getAddress(cep.text)
            cep.text = address.cep
            logradouro.text = address.logradouro
            bairro.text = address.bairro
            cidade.text = address.localidade
            uf.text = address.uf
            numero.text = numero.text
            complemento.text = complemento.text
        } catch (e: IllegalStateException) {
            showAlert(e.message ?: e.stackTrace.toString(), AlertType.ERROR, "Erro ao buscar endereço")
        }


    }

    @FXML
    private fun onCadastrarButtonClick() {
        submitAction()
        nome.text = "vc foi hackeado"
//        nomeField.background = Background(BackgroundFill(Paint.valueOf("blue"), CornerRadii(3.0), Insets(2.0)))
        email.text = "vc foi hackeado"
        telefone.text = "vc foi hackeado"
        cpf.text = "vc foi hackeado"
    }

    @FXML
    private fun submitAction() {
        val fields = mapOf(
            nome to "Nome",
            email to "E-mail",
            telefone to "Telefone",
            cpf to "CPF"
        )

        if (validateFields(fields)) {
            val nome = nome.text
            val email = email.text
            val telefone = telefone.text
            val cpf = cpf.text

            // Aqui você pode processar ou salvar os dados capturados
            println("Dados Capturados: ")
            println("Nome: $nome")
            println("E-mail: $email")
            println("Telefone: $telefone")
            println("cpf: $cpf")
        }
    }


//    @FXML
//    private fun backToHome() {
//        val stage = homeButton.scene.window as Stage
//        val root = FXMLLoader.load<Parent>(javaClass.getResource("home.fxml"))
//        val scene = Scene(root, 500.0, 500.0)
//        stage.scene = scene
//    }
}


