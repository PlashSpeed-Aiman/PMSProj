package com.pms.pmsproj.Model.Complaints;

import com.pms.pmsproj.Model.User.User;

import java.time.LocalDate;

public class Complaint {

    public Complaint(String type,String details,String userId){
        this.complaintType = type;
        this.complaintDetail = details;
        this.complaintDate = LocalDate.now().toString();
        this.complaintStatus = "PENDING";
        this.complaintId = "complaint--"+complaintDate+"--"+userId;
        this.userId = userId;
    }
    public Complaint(){

    }
    private String complaintId = "";
    private String complaintDate = LocalDate.now().toString();
    private String complaintType = "";
    private String complaintDetail = "";
    private String complaintStatus = "";

    private String userId ="";

    public String getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(String complaintId) {
        this.complaintId = complaintId;
    }

    public String getComplaintDate() {
        return complaintDate;
    }

    public void setComplaintDate(String complaintDate) {
        this.complaintDate = complaintDate;
    }

    public String getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(String complaintType) {
        this.complaintType = complaintType;
    }

    public String getComplaintDetail() {
        return complaintDetail;
    }

    public void setComplaintDetail(String complaintDetail) {
        this.complaintDetail = complaintDetail;
    }

    public String getComplaintStatus() {
        return complaintStatus;
    }

    public void setComplaintStatus(String complaintStatus) {
        this.complaintStatus = complaintStatus;
    }

    @Override
    public String toString(){
        return String.format("ID:%s\nDate:%s\nDetail:%s\nStatus=%s",this.complaintId,this.complaintDate,this.complaintDetail,this.complaintStatus);
    }
}
