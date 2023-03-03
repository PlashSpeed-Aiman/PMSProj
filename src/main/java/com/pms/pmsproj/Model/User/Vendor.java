package com.pms.pmsproj.Model.User;

public class Vendor extends User {

    private String shopId = "";
    private int ageVal = 0 ;
    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public int getAgeVal() {
        return ageVal;
    }

    public void setAgeVal(int ageVal) {
        this.ageVal = ageVal;
    }
}
