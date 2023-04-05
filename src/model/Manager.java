package model;

/**
 * This class represents a Manager
 */
public class Manager {
    private String name;
    private String phone;
/**
 * 
 * @param name to add the name manager
 * @param phone to add the phone manager
 * */
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
