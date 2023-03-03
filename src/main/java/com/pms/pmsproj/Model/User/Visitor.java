package com.pms.pmsproj.Model.User;


public class Visitor extends User {

    public Visitor(){

    }
    public Visitor(String name,String password){
        this.name = name;
        this.password = password;
        System.out.println(name+password);
    }
    private boolean isPassValid = false;

    public boolean isPassValid() {
        return isPassValid;
    }

    public void setPassValid(boolean passValid) {
        isPassValid = passValid;
    }

    @Override
    public String toString(){
        return "Name: " + this.getName() + "\n" + "ID: " + this.getId() + "\n" + "Pass Valid?: " + this.isPassValid() + "\n";
    }
}
