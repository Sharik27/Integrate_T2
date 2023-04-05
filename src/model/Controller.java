package model;

/**
 * Controller is a system controller class
 * */

import java.util.Calendar;


public class Controller {

	private StageProject[] stages;
	private Project[] projects;
	private Capsule[] capsules;
	private static final int SIZE = 10;
	private static final int STAGES = 50;

	public Controller() {

		projects = new Project[SIZE];
		stages = new StageProject[STAGES];
		capsules = new Capsule[SIZE];
	
	}
	/**
	 * registerProject: add a new project in the array projects
	 * @param name to add the project name
	 * @param clientName to add the customer name
	 * @param initialDate to add the planned project start date
	 * @param finalDate to add the planned project end dat
	 * @param budget to add the project budget
	 * */
	
	public void registerProject(String name, String clientName, Calendar initialDate, Calendar finalDate, double budget) {

		Project project = new Project(name,clientName, initialDate,finalDate, budget);
        int pos = getFirstValidPosition();
        if(pos !=-1){
           projects[pos] = project;
        }
		
	}
/**
 * addManage: add new manager to project 0
 * @param name to add the manager name
 * @param phone to add the manager phone
 * @return is a message saying that the project is not registered
 * */
	public String addManager(String name, String phone){
		String msg = "No project registered";
		
		if(projects[0] != null){
			Manager manager = new Manager(name, phone);
			msg = projects[0].addManager(manager);
		}
		return msg;
	}
/**
 * getFirstValidPosition search in array if exisy one valid position
 * @return pos -1 when the position does not exist, a number between [0,9] if exist a valid position
 * */
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

/**
 * addStage: add new stage to project 0
 * @param initialDate to add the initial date 
 * @param finalDateto add the final date 
 * @return if the project is registered, the stage is created
 * */
	public String addStage(Calendar initialDate, Calendar finalDate){
		String msg = "No project registered";
		
		if(projects[0] != null){
			StageProject stageProject = new StageProject(initialDate, finalDate);
			msg = projects[0].addStage(stageProject);
		}
		return msg;
	}

	/**
	 * 
	 * @param nameSatge to add the stage name
	 * @returnis a message that saving the stage is not registered
	 * */
	public String culminateStage(String nameSatge){
		String msg = "No Stage registered";

		if(projects[0] != null){
			msg = projects[0].culminateStage(nameSatge);
		}
		return msg;


	}
/**
 * addCapsule: add new capsule to stage 0
 * @param id to add a unique identifier
 * @param description to add the description of a situation
 * @param typeCapusule to add a type of capsule
 * @param approval condition of the capsule
 * @return is a message where it says if the stage is not registered
 * */
	public String addCapsule(String id, String description, String typeCapusule, boolean approval){
		String msg = "No stage registered";
		
		if(projects[0] != null){
			Capsule capsule = new Capsule(id, description, typeCapusule, approval);
			msg = stages[0].addCapsule(capsule);
		}
		return msg;
	}
/**
 * 
 * @param name to add the employee name
 * @param position to add the employee position
 * @return is a message saying that the project is not registered
 * */
	public String addEmployee(String name, String position){
		String msg = "No project registered";
		
		if(projects[0] != null){
			Employee employee = new Employee(name, position);
			msg = capsules[0].addEmployee(employee);
		}
		return msg;
	}

	/**
	 * approvalCapsule: with the id approve the capsule 
	 * @param id to add the capsule identifier and to know if it is approved
	 * @return is a message saying that the capsule is not registered
	 * */
	public String approvalCapsule(String id){
		String msg = "No capsule registered";
		
		if(projects[0] != null){
			msg = stages[0].approvalCapsule(id);
		}
		return msg;
	}

	/**
	 * publicationCapsule: publishes a capsule if approved
	 * @param id to add an identifier to the capsule and know if it is approved for publication
	 * @return 
	 * */
	public String publicationCapsule(String id){
		String msg = "No stage registered";
		
		if(projects[0] != null){
			msg = stages[0].publicationCapsule(id);
		}
		return msg;
	}
}
