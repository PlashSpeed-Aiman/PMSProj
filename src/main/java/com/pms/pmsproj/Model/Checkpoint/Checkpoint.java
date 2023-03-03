package com.pms.pmsproj.Model.Checkpoint;

public class Checkpoint {
    private String checkPointId = "";
    private String checkPointLocation = "";
    private String checkPointDescription = "";
    private String checkInTime = "";

    public Checkpoint(String id,String loc,String desc,String time){
        this.checkPointId = id;
        this.checkPointDescription = desc;
        this.checkPointLocation = loc;
        this.checkInTime = time;
    }

    @Override
    public String toString(){
        return String.format("ID:%s\nLocation:%s\nDescription:%s\nTime=%s",this.checkPointId,this.checkPointLocation,this.checkPointDescription,this.checkInTime);
    }


}
