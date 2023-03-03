package com.pms.pmsproj.Services;

import com.pms.pmsproj.Model.Complaints.Complaint;

public class ComplaintStorage implements DataStorage<Complaint>{
    @Override
    public Complaint loadData() {

        return new Complaint();
    }

    @Override
    public void storeData() {

    }
}
