package model;

public class Manager {
    private String name;
    private String phone;

    public Manager(String name, String phone){

        this.name = name;
        this.phone = phone;

    }

    public String getName(){
        return name;
    }

    public String getPhone(){
        return phone;
    }
}
