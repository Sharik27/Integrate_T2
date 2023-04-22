package model;

/**
 * Controller is a system controller class
 * */

import java.util.Calendar;


public class Controller {

	
	private Project[] projects;
	
	private static final int PROJECT_SIZE = 10;
	

	public Controller() {

		projects = new Project[PROJECT_SIZE];
		
	
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
	public String addManager(String projectName, String name, String phone){
		int pos = searchProyect(projectName);
		String msg = "No project registered";
		if(pos !=-1){
			if(projects[pos] != null){
				Manager manager = new Manager(name, phone);
				msg = projects[pos].addManager(manager);
			}
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
        for(int i = 0; i< PROJECT_SIZE && !isFound; i++){
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
	public String addStage(String projectName, Calendar initialDate, Calendar finalDate){
		int pos = searchProyect(projectName);
		String msg = "No project registered";
		
		if(pos !=-1){
			if(projects[0] != null){
			StageProject start = new StageProject("Start", "Active", initialDate, finalDate);
			StageProject analysis = new StageProject("Analysis", "Desactivate", initialDate, finalDate);
			StageProject design = new StageProject("Design", "Desactivate", initialDate, finalDate);
			StageProject execution= new StageProject("Execution", "Desactivate", initialDate, finalDate);
			StageProject closureMonitoring= new StageProject("Closure and Monitoring", "Desactivate", initialDate, finalDate);
			StageProject control = new StageProject("Control", "Desactivate", initialDate, finalDate);
			projects[pos].addStage(start);
			projects[pos].addStage(analysis);
			projects[pos].addStage(design);
			projects[pos].addStage(execution);
			projects[pos].addStage(closureMonitoring);
			projects[pos].addStage(control);

			}
		}
		
		return msg;
	}

	/**
	 * 
	 * @param stageName to add the stage name
	 * @returnis a message that saving the stage is not registered
	 * */
	public String culminateStage(String projectName, String stageName){
		int pos = searchProyect(projectName);
		String msg = "No Stage registered";

		if(pos !=-1){
			if(projects[pos] != null){
				msg = projects[pos].culminateStage(stageName);
			}
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
	public String addCapsule(String projectName, String stageName, String id, String description, int option, boolean approval){
		int pos = searchProyect(projectName);
		String msg = "";
		
		if( pos!= -1){
			TypeCapsule typeCapusule;
			if(option == 1){
				typeCapusule = TypeCapsule.TECHNICAL;
			}else if(option == 2){
				typeCapusule = TypeCapsule.MANAGEMENT;
			}else if(option == 3){
				typeCapusule = TypeCapsule.DOMAIN;
			}else{
				typeCapusule = TypeCapsule.EXPERIENCES;
			}
			if(projects[pos] != null){
				Capsule capsule = new Capsule(id, description, typeCapusule, approval);
				msg = projects[pos].addCapsule(stageName,capsule);
			}
		}

		return msg;
			
	}		
	
/**
 * 
 * @param name to add the employee name
 * @param position to add the employee position
 * @return is a message saying that the project is not registered
 * */
	public String addEmployee(String projectName, String id,String name, String position){
		int pos = searchProyect(projectName);
		String msg = "No project registered";

		if(pos!= -1){
			if(projects[pos] != null){
				Employee employee = new Employee(name, position);
				msg = projects[pos].addEmployee(id,employee);
			}
		}
		
		return msg;
	}

	/**
	 * approvalCapsule: with the id approve the capsule 
	 * @param id to add the capsule identifier and to know if it is approved
	 * @return is a message saying that the capsule is not registered
	 * */
	public String approvalCapsule(String projectName, String stageName, String id){
		int pos = searchProyect(projectName);
		String msg = "No capsule registered";

		if(pos!= -1){
			if(projects[pos] != null){
				msg = projects[pos].approvalCapsule(stageName, id);
			}
		}	
		
		return msg;
	}

	/**
	 * publicationCapsule: publishes a capsule if approved
	 * @param id to add an identifier to the capsule and know if it is approved for publication
	 * @return 
	 * */
	public String publicationCapsule(String projectName, String stageName, String id){
		int pos = searchProyect(projectName);
		String msg = "No stage registered";

		if(pos != -1){
			if(projects[pos] != null){
				msg = projects[pos].publicationCapsule(stageName,id);
			}
		}
				
		return msg;
	}

	public int searchProyect(String projectName){
		boolean isFound = false;
		int pos = -1;
		for(int i = 0; i<PROJECT_SIZE && !isFound; i++){
			if(projects[i].getName().equalsIgnoreCase(projectName)){
				isFound = true;
				pos = i;
			}
		}
		return pos;

	}
}
