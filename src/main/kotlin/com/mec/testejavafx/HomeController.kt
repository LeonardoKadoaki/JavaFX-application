package com.mec.testejavafx

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

class HomeController {

    private lateinit var stage: Stage

    fun setStage(stage: Stage) {
        this.stage = stage
    }

    var screenWidth: Double = 0.0
    var screenHeight: Double = 0.0

    @FXML
    private fun openUserFormScreen() {
        val width = screenWidth * 0.4 // 100% da largura da tela
        val height = screenHeight * 0.5 // 90% da altura da tela
        changeScene("user-form.fxml", width, height, "Cadastro de Cliente")
    }

    @FXML
    private fun abrirTela2() {
        val width = screenWidth * 0.4
        val height = screenHeight * 0.4
        changeScene("later.fxml", width, height, "em breve")
    }

    @FXML
    private fun abrirTela3() {
        val width = screenWidth * 0.4
        val height = screenHeight * 0.4
        changeScene("later.fxml", width, height, "em breve")
    }


    private fun changeScene(fxmlFile: String, width: Double, height: Double, title: String) {
        val root = FXMLLoader.load<Parent>(javaClass.getResource(fxmlFile))
        stage.title = title
        stage.scene = Scene(root, width, height)
    }
}


