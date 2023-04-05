package model;

/**
 * This class represents a employee
 * */
public class Employee {
    private String name;
    private String position;
/**
 * Employee : add new knowledge capsule
 * @param name to add the employee name
 * @param position to add the employee position
 * */
    public Employee(String name, String position){
        this.name = name;
        this.position = position;
    }

    public String getName(){
        return name;
    }

    public String getPosition(){
        return position;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPosition(String position){
        this.position = position;
    }
}
