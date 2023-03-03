package com.pms.pmsproj.Controller;

import com.pms.pmsproj.Controller.VisitorController.VisitorPassViewController;
import com.pms.pmsproj.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    public VBox container;
    @FXML
    protected void onHelloButtonClick() throws IOException {

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("visitor-login-view.fxml"));
        Stage stage = (Stage) container.getScene().getWindow();
        Scene scene = new Scene(loader.load());
        stage.setTitle("Dashboard");
        stage.setScene(scene);

    }

    public void onSecurityButtonClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("guard-management-view.fxml"));
        Stage stage = (Stage) container.getScene().getWindow();
        Scene scene = new Scene(loader.load());
        stage.setTitle("Dashboard");
        stage.setScene(scene);
    }

    public void onVendorButtonClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("vendor-view.fxml"));
        Stage stage = (Stage) container.getScene().getWindow();
        Scene scene = new Scene(loader.load());
        stage.setTitle("Dashboard");
        stage.setScene(scene);
    }
    public void onResidentButtonClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("resident-view.fxml"));
        Stage stage = (Stage) container.getScene().getWindow();
        Scene scene = new Scene(loader.load());
        stage.setTitle("Dashboard");
        stage.setScene(scene);
    }

    public void onAdminButtonClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("admin-view.fxml"));
        Stage stage = (Stage) container.getScene().getWindow();
        Scene scene = new Scene(loader.load());
        stage.setTitle("Dashboard");
        stage.setScene(scene);
    }
}