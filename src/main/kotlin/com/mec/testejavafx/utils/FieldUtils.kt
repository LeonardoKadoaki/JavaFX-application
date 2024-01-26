package com.mec.testejavafx.utils

import javafx.beans.value.ChangeListener
import javafx.scene.control.Alert
import javafx.scene.control.TextField

fun validateFields(fields: Map<TextField, String>): Boolean {

    val emptyFields = fields.filter { it.key.text.isBlank() }.values
    val warningTitle = "Erro de validação"

    return when {
        emptyFields.isEmpty() -> true
        emptyFields.size == 1 -> {
            showAlert("O campo '${emptyFields.first()}' não foi preenchido", Alert.AlertType.WARNING, warningTitle)
            false
        }

        else -> {
            showAlert(
                "Os campos '${emptyFields.joinToString(", ")}' não foram preenchidos",
                Alert.AlertType.WARNING,
                warningTitle
            )
            false
        }
    }
}

fun showAlert(message: String, alertType: Alert.AlertType, alertTitle: String) {
    val alert = Alert(alertType)
    alert.title = alertTitle
    alert.headerText = null
    alert.contentText = message
    alert.showAndWait()
}

fun charLimit(textField: TextField, maxLength: Int) {
    textField.textProperty().addListener(ChangeListener<String> { _, oldValue, newValue ->
        if (newValue.length > maxLength) {
            textField.text = oldValue
        }
    })
}