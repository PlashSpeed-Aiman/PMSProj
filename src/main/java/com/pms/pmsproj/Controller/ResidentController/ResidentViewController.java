package com.pms.pmsproj.Controller.ResidentController;

import com.google.gson.Gson;
import com.pms.pmsproj.HelloApplication;
import com.pms.pmsproj.Model.Complaints.Complaint;
import com.pms.pmsproj.Model.FinanceRecord.FinanceRecord;
import com.pms.pmsproj.Model.FinanceRecord.FinanceRecordTypes;
import com.pms.pmsproj.Model.FinanceRecord.Payment;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ResourceBundle;

public class ResidentViewController implements Initializable {

    @FXML
    private VBox container;
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
    Gson gson = new Gson();
    private ObservableList<FinanceRecord> financeRecords;
    private ObservableList<Complaint> complaints;
    //    payment history / pending fee/ invoice / statement / receipt
    private Vendor vendor;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBoxPaymentType.getItems().addAll("rental", "utilities ", "services");
        comboBoxPaymentType.setValue("rental");
        comboBoxFinanceType.getItems().addAll("payment history" , "pending fee", "invoice" , "statement" , "receipt");
        comboBoxFinanceType.setValue("payment history");
        listViewFinanceRecords.setItems(financeRecords);
        listviewComplaints.setItems(complaints);


    }
    public ResidentViewController(){
        financeRecords = FXCollections.observableArrayList();
        complaints = FXCollections.observableArrayList();
        vendor = new Vendor();
        vendor.setId("120113");

    }

    //Polymorphism
    //This method can execute without using if statements, and will also output result depending on the input arguments
    public void getFinanceData(FinanceRecordTypes financeRecordTypes, String s){
        try {
            List<String> allLines = Files.readAllLines(Paths.get(financeRecordTypes.name().toLowerCase()+".txt"));

            for (String line : allLines) {
                financeRecords.add(gson.fromJson(line, (Type) Class.forName("com.pms.pmsproj.Model.FinanceRecord."+financeRecordTypes.name())));
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void MakePayment() throws IOException {

        Payment payment = new Payment();
        payment.setPaymentID("payment-"+ LocalDate.now()+"-"+ LocalTime.now());
        payment.setPayeeID(vendor.getId());
        payment.setAmount(Double.valueOf(amountTextField.getText()));
        payment.setPaymentType(comboBoxPaymentType.getValue());
        System.out.println(payment.getPaymentID());
        try (PrintWriter out = new PrintWriter(new FileWriter("payment.txt",true))) {
            Gson gson = new Gson();
            String jsonString = gson.toJson(payment);
            out.write(jsonString+"\n");

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
    public void commitTransaction(FinanceRecord financeRecord){


    }


    public void onConfirmPaymentButtonClicked(ActionEvent actionEvent) throws IOException {
        MakePayment();
    }

    public void onDeleteComplaintButtonClicked(ActionEvent actionEvent) {
        int selectedID = listviewComplaints.getSelectionModel().getSelectedIndex();
        complaints.remove(selectedID);
        try (PrintWriter out = new PrintWriter(new FileWriter("complaint.txt",false))) {
            Gson gson = new Gson();
            for (var complaint:complaints) {
                String jsonString = gson.toJson(complaint);
                out.write(jsonString+"\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onFileComplaintButtonClicked(ActionEvent actionEvent) {
        var complaint = new Complaint(newComplaintTypeField.getText(),newComplaintDetailsField.getText(),vendor.getId());
        complaints.add(complaint);
        try (PrintWriter out = new PrintWriter(new FileWriter("complaint.txt",true))) {
            Gson gson = new Gson();
            String jsonString = gson.toJson(complaint);
            out.write(jsonString+"\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onGetDataButtonClicked(ActionEvent actionEvent) {
        String temp = comboBoxFinanceType.getValue();
        if(temp.contains("payment")){
            getFinanceData(FinanceRecordTypes.Payment,"payment.txt");

        }
        else if(temp.contains("pending")){
            getFinanceData(FinanceRecordTypes.Pending,"pending.txt");

        }
        else if(temp.contains("statement")){
            getFinanceData(FinanceRecordTypes.Statement,"statement.txt");

        }
        else if(temp.contains("invoice")){
            getFinanceData(FinanceRecordTypes.Invoice,"invoice.txt");

        }
        else if(temp.contains("receipt")){
            getFinanceData(FinanceRecordTypes.Receipt,"receipt.txt");

        }
    }

    public void logoutButtonClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Stage stage = (Stage) container.getScene().getWindow();
        Scene scene = new Scene(loader.load());
        stage.setTitle("Dashboard ");
        stage.setScene(scene);
    }
}
