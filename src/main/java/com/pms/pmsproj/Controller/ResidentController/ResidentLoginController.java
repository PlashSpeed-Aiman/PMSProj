package com.pms.pmsproj.Controller.ResidentController;

import com.pms.pmsproj.Controller.VisitorController.VisitorPassViewController;
import com.pms.pmsproj.HelloApplication;
import com.pms.pmsproj.Model.User.Visitor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ResidentLoginController {
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Label errorText;
    @FXML
    private GridPane container;

    public void checkUserLogin(ActionEvent actionEvent) throws IOException {
        if (username.getText().equals("") || password.getText().equals("")) {
            errorText.setText("Please complete all fields!");
            return;
        }
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("resident-view.fxml"));
        Parent root = loader.load();
//        VisitorPassViewController vpv = loader.getController();
        System.out.println(username.getText());
//        vpv.setVisitor(new Visitor(username.getText(),password.getText()));
        Stage stage = (Stage) container.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Pass");
        stage.setScene(scene);
    }

    public void backButtonPressed(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Stage stage = (Stage) container.getScene().getWindow();
        Scene scene = new Scene(loader.load());
        stage.setTitle("Home");
        stage.setScene(scene);
    }

    public void debugTextfield(ActionEvent actionEvent) {
    }
}
