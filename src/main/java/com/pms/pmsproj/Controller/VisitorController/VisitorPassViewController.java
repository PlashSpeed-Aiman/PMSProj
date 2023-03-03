package com.pms.pmsproj.Controller.VisitorController;

import com.pms.pmsproj.Model.User.Visitor;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class VisitorPassViewController  implements Initializable {

    @FXML
    private Label idLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label passValidLabel;
    private Visitor visitor;

    public VisitorPassViewController(){
        visitor = new Visitor();
    }

    public void setVisitor(Visitor visitor){
        this.visitor = visitor;
        nameLabel.setText(visitor.getName());
        idLabel.setText(visitor.getPassword());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(this.visitor.getName());





    }
}
