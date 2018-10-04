/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.gui.client;

import com.dt.project.api.LuckyNumber;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author dell
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost", 6789);
        
        LuckyNumber luckyNumber = (LuckyNumber) registry.lookup("lucky");
        
        VBox root = new VBox(5);
        Label lblNumber = new Label("Lucky Number");
        TextField txtNumber = new TextField();
        Button btnProcess = new Button("Process");
        Label lblResponse = new Label();
        
        btnProcess.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                try {
                    String response = luckyNumber.process(txtNumber.getText());
                    lblResponse.setText(response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        root.getChildren().addAll(lblNumber, txtNumber, btnProcess, lblResponse);
        
        stage.setScene(new Scene(root, 300, 120));
        
        stage.setTitle("RMI GUI Client App");
        
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
