package model;

public class Capsule {
    
    private static final int SIZE =10;
    private String id;
    private String description;
    private String typeCapsule;
    private boolean approval;
    private Employee[] employees;
/**
 * capsule: to create a new capsule
 * @param id to add a capsule identifier
 * @param description to add a capsule description
 * @param typeCapsule to add a capsule type
 * @param approval to approval capsule
 * */
    public Capsule(String id, String description, String typeCapsule, boolean approval){
        this.id = id;
        this.description = description;
        this.typeCapsule = typeCapsule;
        this.approval = approval;

        employees = new Employee[SIZE];
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

    public String getTypeCapsule(){
        return typeCapsule;
    }

    public boolean getApproval(){
        return approval;
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

    public void setTypeCapsule(String typeCapsule){
        this.typeCapsule = typeCapsule;
    }

    public void setApproval(boolean approval){
        this.approval = approval;
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
 * getFirstValidPosition: search in array if exist one valid position
* @return pos -1 if the position does not exist, a number in [0, 9] if exist a valid position

 * */
    public int getFirstValidPosition(){
		int pos = -1; 
		boolean isFound = false; 
		for(int i = 0; i < SIZE && !isFound; i++){
			if(employees[i] == null){
				pos = i; 
				isFound = true;
			}
		}
		return pos; 
	}
}
