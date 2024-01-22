package com.mec.testejavafx

import com.mec.testejavafx.utils.showAlert
import com.mec.testejavafx.utils.validateFields
import javafx.fxml.FXML
import javafx.scene.control.Alert
import javafx.scene.control.Alert.AlertType
import javafx.scene.control.TextField

class VechicleFormController {

    @FXML
    private lateinit var marca: TextField
    @FXML
    private lateinit var modelo: TextField
    @FXML
    private lateinit var ano: TextField
    @FXML
    private lateinit var placa: TextField
    @FXML
    private lateinit var observacoes: TextField




    @FXML
    private fun onCadastrarVeiculoButtonClick() {
        val fields = mapOf(
            marca to "Marca",
            modelo to "Modelo",
            ano to "Ano",
            placa to "Placa",
        )
        if (validateFields(fields)){
            val car = "${marca.text} ${modelo.text} ${ano.text} - Placa: ${placa.text}. Obs: ${observacoes.text}"
            println(car)
            showAlert(car, AlertType.INFORMATION, "Veículo cadastrado com sucesso!")
        }

    }


}


