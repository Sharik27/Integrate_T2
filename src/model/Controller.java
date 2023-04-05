package model;

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

	public String addStage(Calendar initialDate, Calendar finalDate){
		String msg = "No project registered";
		
		if(projects[0] != null){
			StageProject stageProject = new StageProject(initialDate, finalDate);
			msg = projects[0].addStage(stageProject);
		}
		return msg;
	}

	public String culminateStage(String nameSatge){
		String msg = "No Stage registered";

		if(projects[0] != null){
			msg = projects[0].culminateStage(nameSatge);
		}
		return msg;


	}

	public String addCapsule(String id, String description, String typeCapusule, boolean approval){
		String msg = "No stage registered";
		
		if(projects[0] != null){
			Capsule capsule = new Capsule(id, description, typeCapusule, approval);
			msg = stages[0].addCapsule(capsule);
		}
		return msg;
	}

	public String addEmployee(String name, String position){
		String msg = "No project registered";
		
		if(projects[0] != null){
			Employee employee = new Employee(name, position);
			msg = capsules[0].addEmployee(employee);
		}
		return msg;
	}

	public String approvalCapsule(String id){
		String msg = "No capsule registered";
		
		if(projects[0] != null){
			msg = stages[0].approvalCapsule(id);
		}
		return msg;
	}

	public String publicationCapsule(String id){
		String msg = "No stage registered";
		
		if(projects[0] != null){
			msg = stages[0].publicationCapsule(id);
		}
		return msg;
	}
}
