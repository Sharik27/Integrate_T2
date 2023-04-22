package model;

// This classs represents project
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Project{
/**
 * SIZE the total number of project
 * SAGES the total number of stages 
 * */
	private static final int MANAGER_SIZE = 10;
	private static final int STAGES_SIZE = 6;
 
 
	private String name;
	private String clientName;
	private Calendar initialDate;
	private Calendar finalDate;
	private double budget;
	private int countAmountCapsule;

	private Manager[] managers;
	private StageProject[] stageProjects;
	private DateFormat formatter;

/**
 * Project: create a new project
 * @param name to add the project name
 * @param clientNameto add the customer name
 * @param initialDate to add the planned project start date
 * @param finalDate to add the planned project end date
 * @param budget to add the project budget
 * */
	public Project(String name, String clientName, Calendar initialDate, Calendar finalDate, double budget){
		
		this.formatter = new SimpleDateFormat("dd-MM-yyyy");

		this.name = name;	
		this.clientName = clientName;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.budget = budget;

		managers = new Manager [MANAGER_SIZE];
		stageProjects = new StageProject[STAGES_SIZE];
		
	}

	public String getName(){
		return name;
	}
	
	public String getClientName(){
		return clientName;
	}

	public Calendar getInitialDate(){
		return initialDate;
	}
	
	public String getInitialDateFormated(){
		return formatter.format(this.initialDate.getTime());
	}

	public Calendar getFinalDate(){
		return finalDate;
	}

	public String getFinalDateFormated() {
		return formatter.format(this.finalDate.getTime());
	}		

	public double getBudget(){
		return budget;
	}

	public String getProjectInfo() {
		return "\nName: " + name + "\nClient: " + clientName + "\nInitial Date: " + getInitialDateFormated() + 
		"\nFinal Date: " + getFinalDateFormated() + "\nTotalBudget: " + budget + ".\n";
	}

	public int getCountAmountCapsule() {
		return countAmountCapsule;
	}
/**
 * 
 * @param manager to add a manager
 * @return is a message that saving if add the manager or not
 * */
	public String addManager(Manager manager){
		String msg = "Manager could not be added ";
		int pos = getFirstValidPositionManager(); 
		if(pos != -1){
			managers[pos] = manager; 
			msg = "Manager added"; 
		}

		return msg;
	}
/**
 * 
 * @param stage to add a stage
 * @return is a message that saving if stages added
 * */
	public String addStage(StageProject stage){
		String msg = "Stages have not been created";
		int pos = getFirstValidPositionStage(); 
		if(pos != -1){
			stageProjects[pos] = stage; 
			msg = "Stages added"; 
		}

		return msg;
	}

/**
 * getFirstValidPosition: search in array if exist one valid position
 * @param nameStages to add the name stage
 * @return pos -1 if the position does not exist, a number in [0, 5] if exist a valid position
 * */
	public  int searhStages(String stageName){
		boolean isFound= false;
		int pos = -1;
		for(int i = 0; i<STAGES_SIZE && !isFound; i++){
			if(stageProjects[i].getStageName().equalsIgnoreCase(stageName)){
				isFound = true;
				pos = i;
			}
		}
		return pos;
	}

	public  int searhCapsule(String id){
		int pos = -1;
		for(int i = 0; i<MANAGER_SIZE; i++){
			pos = stageProjects[i].searhCapsules(id);	
		}
		return pos;
	}

/**
 * culminateStage: the stage is completed by changing from active to inactive status 
 * @param nameStages to add the name stages
 * @return
 * */
	public String culminateStage(String nameStages){
		String msg = "The stages has culminated";
		int pos = searhStages(nameStages);
		if(pos != -1){
			if(stageProjects[pos]!= null){
				if(stageProjects[pos].getStageStatus()!= "Desactivate"){
					stageProjects[pos].setStageStatus("Desactivate");
					stageProjects[pos+1].setStageStatus("Äctivate"); 
					msg= "The stages has culminated";
				}

			}
			
		}

		return msg;
	}

/**
 * getFirstValidPosition: search in array if exist one valid position
 * @return pos -1 if the position does not exist, a number in [0, 9] if exist a valid position
 * */
	public int getFirstValidPositionManager(){
		int pos = -1; 
		boolean isFound = false; 
		for(int i = 0; i < MANAGER_SIZE && !isFound; i++){
			if(managers[i] == null){
				pos = i; 
				isFound = true;
			}
		}
		return pos; 
	}
/**
 * getFirstValidPosition: search in array if exist one valid position
 * @return pos -1 if the position does not exist, a number in [0, 9] if exist a valid position
 * */
	public int getFirstValidPositionStage(){
		int pos = -1; 
		boolean isFound = false; 
		for(int i = 0; i < STAGES_SIZE && !isFound; i++){
			if(stageProjects[i] == null){
				pos = i; 
				isFound = true;
			}
		}
		return pos; 
	}

	/**
	 * addCapsule: add a capsule to the project
	 * @param stageName to add the stage name
	 * @param capsule is a object of type Capsule
	 * @return return a positive or negative message 
	 */

	public String addCapsule(String stageName, Capsule capsule){
		int pos = searhStages(stageName);
		String msg = "Capsule has not been added";

		if(pos != -1){
			if(stageProjects[pos] != null){
				stageProjects[pos].addCapsule(capsule);
				msg = "Capsule has been added";
				countAmountCapsule++;
			}

		}
		return msg;

	}

	/**
	 * addEmployee: add a employee
	 * @param id to add the employee id
	 * @param employee is a object of type Employee
	 * @return return a positive or negative message 
	 */
	public String addEmployee(String id, Employee employee){
		String msg = "";
		int pos =searhCapsule(id);
		if(pos!= -1){
			if(stageProjects[pos]!= null){
				msg= stageProjects[pos].addEmployee(id, employee);
			} 
		}
		return msg;
	}

	/**
	 * publicationCapsule: to publication a capsule 
	 * @param stageName to add the stage name
	 * @param id to add the capsule id
	 * @return return a positive or negative message 
	 */

	public String publicationCapsule(String stageName, String id){
		int pos = searhCapsule(id);
		String msg = "The capsule could not be published";
		if(pos!= -1){
			if(stageProjects[pos]!= null){
				msg= stageProjects[pos].publicationCapsule(id);
			}

		}
		return msg;
	}

	/**
	 * approvalCapsule: approval of a capsule by means of stage name and identifier 
	 * @param stageName to add the stage name
	 * @param id to add the stage id
	 * @return return a positive or negative message 
	 */

	public String approvalCapsule(String stageName, String id){
		String msg = "The capsule has not been approved";
		int pos = searhCapsule(id);

		if(pos!= -1){
			if(stageProjects[pos]!= null){
				msg=stageProjects[pos].approvalCapsule(id);
			}
		}
		return msg;
	}

	/**
	 * listAllCapsule: to show all capsules 
	 * @param  to add the stage name 
	 * @return the information of all the capsules in the stage
	 */

	public String listAllCapsule(String stageName){
		int pos = searhStages(stageName);
		String msg = stageProjects[pos].listAllCapsules()+"\n";
		return msg;
	}

	
}


