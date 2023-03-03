package com.pms.pmsproj.Model.Incidents;

import java.time.LocalDate;
import java.time.LocalTime;

public class Incident {

    public Incident(String id,String details){
        this.incidentId = id;
        this.incidentDetails = details;
        this.incidentTime = LocalDate.now().toString();
    }

    private String incidentId;
    private String incidentTime;
    private String incidentDetails;

    public String getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(String incidentId) {
        this.incidentId = incidentId;
    }

    public String getIncidentTime() {
        return incidentTime;
    }

    public void setIncidentTime(String incidentTime) {
        this.incidentTime = incidentTime;
    }

    public String getIncidentDetails() {
        return incidentDetails;
    }

    public void setIncidentDetails(String incidentDetails) {
        this.incidentDetails = incidentDetails;
    }
    @Override
    public String toString(){
        return String.format("IncidentID:%s\nIncident Details: %s\nTime Recorded:%s\n",this.incidentId,this.incidentDetails,this.incidentTime);
    }
}
