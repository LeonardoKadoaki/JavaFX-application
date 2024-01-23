package com.mec.testejavafx

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Screen
import javafx.stage.Stage

//class HelloApplication : Application() {
//
//    override fun start(stage: Stage) {
//        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("home.fxml"))
//
//        // Obtém as dimensões da tela
//        val screenSize = Screen.getPrimary().bounds
//        val screenWidth = screenSize.width
//        val screenHeight = screenSize.height
//
//        // Define a largura e altura da cena como uma porcentagem das dimensões da tela
//        val width = screenWidth * 1 // 100% da largura da tela
//        val height = screenHeight * 0.9 // 90% da altura da tela
//
//        stage.scene = Scene(fxmlLoader.load(), width, height)
//        stage.show()
//    }
//}


class Main : Application() {
    override fun start(primaryStage: Stage) {
        val loader = FXMLLoader(javaClass.getResource("home2.fxml"))
        val root = loader.load<Parent>()
        val controller = loader.getController<HomeController>()
        controller.setStage(primaryStage)

        // Obtém as dimensões da tela
        val screenSize = Screen.getPrimary().bounds
        val screenWidth = screenSize.width
        val screenHeight = screenSize.height

        controller.screenWidth = screenWidth
        controller.screenHeight = screenHeight

        // Define a largura e altura da cena como uma porcentagem das dimensões da tela
        val width = screenWidth * 0.4 // 100% da largura da tela
        val height = screenHeight * 0.5 // 90% da altura da tela

        primaryStage.scene = Scene(root, width, height)
        primaryStage.title = "Página Inicial"
        primaryStage.show()
    }
}

fun main(args: Array<String>) {
    Application.launch(Main::class.java, *args)
}