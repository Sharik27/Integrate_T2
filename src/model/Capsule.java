package model;

public class Capsule {
    
    private static final int EMPLOYEE_SIZE =10;
    private String id;
    private String description;
    private TypeCapsule typeCapsule;
    private boolean approval;
    private Employee[] employees;
    private String publication = "false";
/**
 * capsule: to create a new capsule
 * @param id to add a capsule identifier
 * @param description to add a capsule description
 * @param typeCapsule to add a capsule type
 * @param approval to approval capsule
 * */
    public Capsule(String id, String description, TypeCapsule typeCapsule, boolean approval){
        this.id = id;
        this.description = description;
        this.typeCapsule = typeCapsule;
        this.approval = approval;

        employees = new Employee[EMPLOYEE_SIZE];
    }
/**
 * 
 * @return the search for the identifier
 * */
    public String getId(){
        return id;
    }

    public String getDescription(){
        return description;
    }

    public TypeCapsule getTypeCapsule(){
        return typeCapsule;
    }

    public boolean getApproval(){
        return approval;
    }

    public String getPublication() {
        return publication;
    }

    public void setId(String id){
        this.id = id;
    }
/**
 * 
 * @param description is the description of the capsule and can be modified.
 * */
    public void setDescription(String description){
        this.description = description;
    }

    public void setTypeCapsule(TypeCapsule typeCapsule){
        this.typeCapsule = typeCapsule;
    }

    public void setApproval(boolean approval){
        this.approval = approval;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }
/**
 * 
 * @param employee to add the employee
 * @return is a message that saving if add the employye or not
 * */
    public String addEmployee(Employee employee){
		String msg = "Employee could not be added ";
		int pos = getFirstValidPosition(); 
		if(pos != -1){
			employees[pos] = employee; 
			msg = "Employee added"; 
		}

		return msg;
	}
    /**
     * 
     * @param name to searh for an employee by name 
     * @return the employee's position in the arrangement
     */

    public  int searhEmployee(String name){
		boolean isFound= false;
		int pos = -1;
		for(int i = 0; i<EMPLOYEE_SIZE && !isFound; i++){
			if(employees[i].getName().equalsIgnoreCase(name)){
				isFound = true;
				pos = i;
			}
		}
		return pos;
	}
/**
 * getFirstValidPosition: search in array if exist one valid position
* @return pos -1 if the position does not exist, a number in [0, 9] if exist a valid position

 * */
    public int getFirstValidPosition(){
		int pos = -1; 
		boolean isFound = false; 
		for(int i = 0; i < EMPLOYEE_SIZE && !isFound; i++){
			if(employees[i] == null){
				pos = i; 
				isFound = true;
			}
		}
		return pos; 
	}

    public String toString(){
        return "The id of capsule is: "+ getId()+ "\n"+ "The description of capsule is:"+ getDescription()+ "\n"+ "The type of capsule is: "+ getTypeCapsule();
    }
}
