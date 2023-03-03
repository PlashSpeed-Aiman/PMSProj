package com.pms.pmsproj.Controller.AdminController;

import com.google.gson.Gson;
import com.pms.pmsproj.HelloApplication;
import com.pms.pmsproj.Model.Bookings.Booking;
import com.pms.pmsproj.Model.Complaints.Complaint;
import com.pms.pmsproj.Model.FinanceRecord.FinanceRecord;
import com.pms.pmsproj.Model.User.AdminExecutive;
import com.pms.pmsproj.Model.User.Employee;
import com.pms.pmsproj.Model.User.Resident;
import com.pms.pmsproj.Model.User.Vendor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminViewController implements Initializable {
    @FXML
    public TextField newResidentUsernameField;
    @FXML
    public PasswordField newResidentPasswordField;
    @FXML
    private TextField newComplaintTypeField;
    @FXML
    private TextField newComplaintDetailsField;
    @FXML
    private ComboBox<String> comboBoxPaymentType;
    @FXML
    private TextField amountTextField;
    @FXML
    private ComboBox<String> comboBoxFinanceType;
    @FXML
    private ListView<FinanceRecord> listViewFinanceRecords;
    @FXML
    private ListView<Complaint> listviewComplaints;
    @FXML
    private VBox container;
    Gson gson = new Gson();
    //Observable list will be attached to ListView
    //No need to update ListView if list is changed,
    //Observable list will update it automatically
    //Make sure to attach it to a ListView first
//    private ObservableList<FinanceRecord> financeRecords;
    private ObservableList<Complaint> complaints;
    private ObservableList<Employee> employees;
    private ObservableList<Booking> bookings;
    private ObservableList<Resident> residents;

    private AdminExecutive adminExecutive;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listviewComplaints.setItems(complaints);


    }
    public AdminViewController(){
        adminExecutive = new AdminExecutive();
//        financeRecords = FXCollections.observableArrayList();
        complaints = FXCollections.observableArrayList();


    }
    public void onDeleteComplaintButtonClicked(ActionEvent actionEvent) {
        int selectedID = listviewComplaints.getSelectionModel().getSelectedIndex();
        complaints.remove(selectedID);
    }

    public void onFileComplaintButtonClicked(ActionEvent actionEvent) {
        complaints.add(new Complaint(newComplaintTypeField.getText(),newComplaintDetailsField.getText(),adminExecutive.getId()));

    }

    public void onRegisterResidentButtonClicked(ActionEvent actionEvent) {

    }

    public void logoutButtonClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Stage stage = (Stage) container.getScene().getWindow();
        Scene scene = new Scene(loader.load());
        stage.setTitle("Dashboard ");
        stage.setScene(scene);
    }
}
