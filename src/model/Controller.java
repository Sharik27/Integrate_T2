package model;

/**
 * Controller is a system controller class
 * */

import java.util.Calendar;


public class Controller {

	
	private Project[] projects;
	
	private static final int PROJECT_SIZE = 10;

	int countTechnical = 0;
	int countManagment = 0;
	int countDomain = 0;
	int countExperiences = 0;
	

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
		int pos = searchProject(projectName);
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
 * @param projectName to add the name project
 * @param initialDate to add the initial date 
 * @param finalDateto add the final date 
 * @return if the project is registered, the stage is created
 * */
	public String addStage(String projectName, Calendar initialDate, Calendar finalDate){
		int pos = searchProject(projectName);
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
	 * @param projectName to add the project name
	 * @param stageName to add the stage name
	 * @return a message that saving the stage is not registered
	 * */
	public String culminateStage(String projectName, String stageName){
		int pos = searchProject(projectName);
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
 * @param projectName to add the project name
 * @param stageName to add the stage name
 * @param id to add a unique identifier
 * @param description to add the description of a situation
 * @param typeCapusule to add a type of capsule
 * @param approval condition of the capsule
 * @return is a message where it says if the stage is not registered
 * */
	public String addCapsule(String projectName, String stageName, String id, String description, int option, boolean approval){
		int pos = searchProject(projectName);
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
 * @param projectName to add the project name
 * @param id to add the capsule id
 * @param name to add the employee name
 * @param position to add the employee position
 * @return is a message saying that the project is not registered
 * */
	public String addEmployee(String projectName, String id,String name, String position){
		int pos = searchProject(projectName);
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
	 * @param projectName to add the project name
	 * @param stageName to add the stage name 
	 * @param id to add the capsule identifier and to know if it is approved
	 * @return is a message saying that the capsule is not registered
	 * */
	public String approvalCapsule(String projectName, String stageName, String id){
		int pos = searchProject(projectName);
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
	 * @return return a positive or negative message
	 * */
	public String publicationCapsule(String projectName, String stageName, String id){
		int pos = searchProject(projectName);
		String msg = "No stage registered";

		if(pos != -1){
			if(projects[pos] != null){
				msg = projects[pos].publicationCapsule(stageName,id);
			}
		}
				
		return msg;
	}

	/**
	 * 
	 * @param projectName add the project name  to search for the project
	 * @return the position of the project
	 */

	public int searchProject(String projectName){
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

	/**
	 * 
	 * @param projectName to add the project name
	 * @param stageName to add the stage name 
	 * @return  the amount of capsules for each stage
	 */

	public String consultAmountTypeCapsule(String projectName, String stageName){
		String msgTechnical="";
		String msgManagment = "";
		String msgDomain = "";
		String msgExperiences = "";
		int pos = searchProject(projectName);

		if(pos != -1){
			if (projects[pos] != null){
				msgTechnical = "The amount of technical capsules are: "+countTechnical;
				msgManagment ="The amount of Management capsules are: "+countManagment;
				msgDomain = "The aumount of Domain capsules are: "+countDomain;
				msgExperiences = "The aumount of Experiences capsules are: "+countExperiences;
			}
			

		}

		return msgTechnical + "\n" + msgManagment + "\n" + msgDomain + "\n" + msgExperiences;
	}

	/**
	 * 
	 * @param projectName to add the project name
	 * @param stageName to add the stage name
	 * @return return a positive or negative message
	 */

	public String consultCapsule(String projectName, String stageName){
		int pos = searchProject(projectName);
		String msg = "";

		if(pos!= -1){
			for(int i= 0; i<PROJECT_SIZE; i++){
				if(projects[pos]!= null){
					msg+= projects[i].listAllCapsule(stageName)+"\n";
				}
			}

		}
		return msg;
	} 

	public String consultAmountCapsule(String projectName){
		int pos = searchProject(projectName);
		String msg= "";

		for(int i=0; i<PROJECT_SIZE; i++){
			if(projects[pos].getCountAmountCapsule()<projects[pos+1].getCountAmountCapsule()){
				msg = "the project with the most capsule is: "+"\n"+projects[i].toString();
			}
		}
		return msg;
	}

	/**
	 * seeRegisterCapsule: This is to check if an employee has registered a capsule in a project.
	 * @param projectName to add the name of the project
	 * @param stageName to add the name of the stage
	 * @param id to add the id of the capsule
	 * @param name to add the name of the employee
	 * @return if the employee has created a capsule
	 */
	public String seeRegisterCapsule(String projectName, String stageName, String id, String name){
		int pos = searchProject(projectName);
		String msg = "";

		if(pos != -1){
			if(projects[pos] != null){
				msg = projects[pos].seeRegisterCapsule(stageName, id, name);
			}
		}
		return msg;
	}

	public  int searchCapsulesWithDescription(String description){
		int pos = -1;
		for(int i = 0; i<PROJECT_SIZE; i++){
			pos = projects[i].searchCapsulesWithDescription(description);	
		}
		return pos;
	}

	public String consultCapsulePublished(String description){
		String msg = "The capsule is not found";
		int pos = searchCapsulesWithDescription(description);

		if(pos != -1){
			projects[pos].consultCapsulePublished(description);
			msg = "";
		}

		return msg;
	}


}
