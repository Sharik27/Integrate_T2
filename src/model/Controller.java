package model;

import java.util.Calendar;


public class Controller {

	private Project[] projects;
	private static final int SIZE = 10;

	public Controller() {

		projects = new Project[SIZE];
	
	}
	
	
	//Incomplete
	public void registerProject(String name, String clientName, Calendar initialDate, Calendar finalDate, double budget) {

		Project project = new Project(name,clientName, initialDate,finalDate, budget);
        int pos = getFirstValidPosition();
        if(pos !=-1){
           projects[pos] = project;
        }
		
	}

	public String addManager(String name, String phone){
		String msg = "No project registered";
		
		if(projects[0] != null){
			Manager manager = new Manager(name, phone);
			msg = projects[0].addManager(manager);
		}
		return msg;
	}

	public int getFirstValidPosition(){
        int pos = -1;
        boolean isFound = false; 
        for(int i = 0; i< SIZE && !isFound; i++){
            if(projects[i] == null){
                pos = i;
                isFound = true;
            }
        }
        return pos;
    }

	//Incomplete
	// Date class also has their own before() and after() method
	public void searchProjectsAfterDate(String nameProject) {

		boolean isFound= false;

		for(int i = 0; i<SIZE && !isFound; i++){
			if(projects[i].getName().equalsIgnoreCase(nameProject)){
				isFound = true;
                System.out.println("The end date of the project is: "+projects[i].getFinalDateFormated());
               
			}else {
				isFound = true;
				System.out.println("Project not foundo");
			}
		}
		

	}
	
	//Incomplete
	// Date class also has their own before() and after() method
	public void searchProjectsBeforeDate(String nameProject){

		boolean isFound= false;

		for(int i = 0; i<SIZE && !isFound; i++){
			if(projects[i].getName().equalsIgnoreCase(nameProject)){
				isFound = true;
				
                System.out.println("the project start date is: "+projects[i].getInitialDateFormated());
			}else{
                isFound = true;
                System.out.println("Project not found");
			}
		}
	}
}
