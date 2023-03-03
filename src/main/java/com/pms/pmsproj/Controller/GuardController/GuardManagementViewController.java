package com.pms.pmsproj.Controller.GuardController;

import com.pms.pmsproj.HelloApplication;
import com.pms.pmsproj.Model.Checkpoint.Checkpoint;
import com.pms.pmsproj.Model.Incidents.Incident;
import com.pms.pmsproj.Model.User.SecurityGuard;
import com.pms.pmsproj.Model.User.Visitor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class GuardManagementViewController implements Initializable {
    @FXML
    private VBox container;
    @FXML
    private TextField incidentDetailsField;
    @FXML
    private TextField incidentIdField;
    @FXML
    private ListView<Incident> incidentListView;
    @FXML
    private ListView<Checkpoint> checkPointListView;
    @FXML
    private TextField checkpointIdField;
    @FXML
    private TextField checkpointDescField;
    @FXML
    private TextField checkpointLocField;
    private ObservableList<Visitor> visitors;
    private ObservableList<Incident> incidents;
    private ObservableList<Checkpoint> checkpoints;

    private SecurityGuard securityGuard;
    public GuardManagementViewController(){
        securityGuard = new SecurityGuard();
        checkpoints = securityGuard.getCheckpoints();
        visitors = FXCollections.observableArrayList();
        incidents = FXCollections.observableArrayList();


    }

    public void recordButtonClicked(ActionEvent actionEvent) {
        incidents.add(new Incident(incidentIdField.getText(),incidentDetailsField.getText()));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        incidentListView.setItems(incidents);
        checkPointListView.setItems(checkpoints);
    }

    public void checkInButtonClicked(ActionEvent actionEvent) {
        checkpoints.add(new Checkpoint(checkpointIdField.getText(),checkpointLocField.getText(),checkpointDescField.getText(), LocalDate.now().toString()));
    }
    public void logoutButtonClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Stage stage = (Stage) container.getScene().getWindow();
        Scene scene = new Scene(loader.load());
        stage.setTitle("Dashboard ");
        stage.setScene(scene);
    }
}
