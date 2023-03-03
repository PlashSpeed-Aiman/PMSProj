package com.pms.pmsproj.Model.User;

import com.pms.pmsproj.Model.Complaints.Complaint;
import javafx.collections.ObservableList;

import java.util.List;

public class Resident extends User{

    public Resident(String name,String password,String id,String userType){
        this.name = name;
        this.password = password;
        this.id = id;
        this.userType = userType;
    }
    public Resident(){

    }

}
