//module com.mec.testejavafx {
//    requires javafx.controls;
//    requires javafx.fxml;
//    requires javafx.web;
//    requires kotlin.stdlib;
//
//    requires org.controlsfx.controls;
//    requires com.dlsc.formsfx;
//    requires net.synedra.validatorfx;
//    requires org.kordamp.ikonli.javafx;
//    requires org.kordamp.bootstrapfx.core;
//    requires com.fasterxml.jackson.annotation;
//    requires com.fasterxml.jackson.databind;
//    requires com.fasterxml.jackson.datatype.jsr310;
//    requires com.fasterxml.jackson.kotlin;
////    requires eu.hansolo.tilesfx;
//
//    opens com.mec.testejavafx.rest to com.fasterxml.jackson.databind, com.fasterxml.jackson.annotation, com.fasterxml.jackson.datatype.jsr310, com.fasterxml.jackson.kotlin;
//    exports com.mec.testejavafx.rest to com.fasterxml.jackson.databind, com.fasterxml.jackson.annotation, com.fasterxml.jackson.datatype.jsr310, com.fasterxml.jackson.kotlin;
//
//    opens com.mec.testejavafx to javafx.fxml;
//    exports com.mec.testejavafx;
//
//
//}