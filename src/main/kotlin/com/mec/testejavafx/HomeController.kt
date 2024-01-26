package com.mec.testejavafx

import com.mec.testejavafx.constants.Messages
import com.mec.testejavafx.service.UserService
import com.mec.testejavafx.service.VehicleService
import com.mec.testejavafx.utils.*
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Alert
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.VBox
import javafx.stage.Stage

class HomeController {

    private lateinit var stage: Stage

    fun setStage(stage: Stage) {
        this.stage = stage
    }

    var screenWidth: Double = 0.0
    var screenHeight: Double = 0.0

    @FXML
    private lateinit var addItem: TextField

    @FXML
    private lateinit var vBox: VBox

    private val strings = listOf("Item 1", "Item 2", "Item 3")

    @FXML
    private lateinit var cpfField: TextField

    @FXML
    private lateinit var placaField: TextField

    @FXML
    private lateinit var nomeDetail: Label

    @FXML
    private lateinit var cpfDetail: Label

    @FXML
    private lateinit var emailDetail: Label

    @FXML
    private lateinit var telefoneDetail: Label

    @FXML
    private lateinit var marcaDetail: Label

    @FXML
    private lateinit var modeloDetail: Label

    @FXML
    private lateinit var anoDetail: Label

    @FXML
    private lateinit var placaDetail: Label

    @FXML
    private lateinit var obsDetail: Label

    @FXML
    fun initialize() {
        charLimit(cpfField, 11)
        charLimit(placaField, 7)
        addItem.apply {
            isEditable = false

            focusedProperty().addListener { _, _, newValue ->
                isEditable = newValue
            }
        }
        strings.forEach { str ->
            val textField = TextField(str)
            vBox.children.add(textField)
        }
        cpfField.setOnAction {
            cpfFieldAction()
        }
        placaField.setOnAction {
            placaFieldAction()
        }
    }

    private fun cpfFieldAction() {
        val user = UserService().getUser(cpfField.text)
        if (user == null)
            showAlert(
                Messages.CUSTOMER_NOT_FOUND,
                Alert.AlertType.ERROR,
                Messages.CUSTOMER_NOT_FOUND_TITLE
            )
        else {
            nomeDetail.text = "Nome: ${user.nome}"
            cpfDetail.text = "CPF: ${cpfFormat(user.cpf)}"
            emailDetail.text = "E-mail: ${user.email}"
            telefoneDetail.text = "Telefone: ${phoneFormat(user.telefone)}"
        }
    }

    private fun placaFieldAction() {
        val vehicle = VehicleService().getVehicle(placaField.text.uppercase())
        if (vehicle == null)
            showAlert(
                Messages.VEHICLE_NOT_FOUND,
                Alert.AlertType.ERROR,
                Messages.VEHICLE_NOT_FOUND_TITLE
            )
        else {
            marcaDetail.text = "Marca: ${vehicle.marca}"
            modeloDetail.text = "Modelo: ${vehicle.modelo}"
            anoDetail.text = "Ano: ${vehicle.ano}"
            placaDetail.text = "Placa: ${plateFormat(vehicle.placa)}"
            obsDetail.text = "Obs: ${vehicle.obs}"
        }
    }

    @FXML
    private fun openUserFormScreen() {
        val width = screenWidth * 0.5 // 100% da largura da tela
        val height = screenHeight * 0.6 // 90% da altura da tela
        changeScene("user-form.fxml", "Cadastro de Cliente")
//        changeScene("user-form.fxml", width, height, "Cadastro de Cliente")
    }

    @FXML
    private fun openVehicleFormScreen() {
        val width = screenWidth * 0.5 // 100% da largura da tela
        val height = screenHeight * 0.6 // 90% da altura da tela
        changeScene("vehicle-form.fxml", "Cadastro de veículo")
//        changeScene("vehicle-form.fxml", width, height, "Cadastro de veículo")
    }

    @FXML
    private fun abrirTela2() {
        val width = screenWidth * 0.4
        val height = screenHeight * 0.4
        changeScene("later.fxml", "em breve")
//        changeScene("later.fxml", width, height, "em breve")
    }

    @FXML
    private fun abrirTela3() {
        val width = screenWidth * 0.4
        val height = screenHeight * 0.4
        changeScene("later.fxml", "em breve")
//        changeScene("later.fxml", width, height, "em breve")
    }


//    private fun changeScene(fxmlFile: String, width: Double, height: Double, title: String) {
//        val root = FXMLLoader.load<Parent>(javaClass.getResource(fxmlFile))
//        stage.title = title
//        stage.scene = Scene(root, width, height)
//    }

    private fun changeScene(fxmlFile: String, title: String) {
        val root = FXMLLoader.load<Parent>(javaClass.getResource(fxmlFile))
        val stage = Stage()
        stage.title = title
        stage.scene = Scene(root)
        stage.show()
    }
}


