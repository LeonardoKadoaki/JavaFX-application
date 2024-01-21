package com.mec.testejavafx

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Screen
import javafx.stage.Stage

class HelloApplication : Application() {
//    override fun start(stage: Stage) {
////        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("hello-view.fxml"))
//        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("user-form.fxml"))
//        val scene = Scene(fxmlLoader.load(), 1100.0, 618.0)
//        stage.title = "Hello!"
//        stage.scene = scene
//        stage.show()
//    }

    override fun start(stage: Stage) {
//        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("hello-view.fxml"))
        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("user-form.fxml"))
//        val scene = Scene(fxmlLoader.load(), 1100.0, 618.0)

        // Obtém as dimensões da tela
        val screenSize = Screen.getPrimary().bounds
        val screenWidth = screenSize.width
        val screenHeight = screenSize.height

        // Define a largura e altura da cena como uma porcentagem das dimensões da tela
        val width = screenWidth * 1 // 100% da largura da tela
        val height = screenHeight * 0.9 // 90% da altura da tela

        stage.scene = Scene(fxmlLoader.load(), width, height)
        stage.show()
    }
}

fun main() {
    Application.launch(HelloApplication::class.java)
}