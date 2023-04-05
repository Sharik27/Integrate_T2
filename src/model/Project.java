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
	private static final int SIZE = 10;
	private static final int STAGES = 6;
 
 
	private String name;
	private String clientName;
	private Calendar initialDate;
	private Calendar finalDate;
	private double budget;

	private Manager[] managers;
	private StageProject[] stageProjects;
	private String[] stages;
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

		managers = new Manager [SIZE];
		stageProjects = new StageProject[SIZE];
		stages = new String[STAGES];
		
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
			initStages();
			stageProjects[pos] = stage; 
			msg = "Stages added"; 
		}

		return msg;
	}
/**
 * initStages: show the 6 stages of the project
 * */
	public void initStages(){
		stages[0] = "Start"; 
		stages[1] = "Analysis";
		stages[2] = "Design";
		stages[3] = "Execution";
		stages[4] = "ClosureMonitoring";
		stages[5] = "ProjectControl";
	}
/**
 * getFirstValidPosition: search in array if exist one valid position
 * @param nameStages to add the name stage
 * @return pos -1 if the position does not exist, a number in [0, 5] if exist a valid position
 * */
	public  int searhStages(String nameStages){
		boolean isFound= false;
		int pos = -1;
		for(int i = 0; i<SIZE && !isFound; i++){
			if(stages[i].equalsIgnoreCase(nameStages)){
				isFound = true;
				pos = i;
			}
		}
		return pos;
	}
/**
 * culminateStage: the stage is completed
 * @param nameStages to add the name stages
 * @return
 * */
	public String culminateStage(String nameStages){
		String msg = "The stages has culminated";
		int pos = searhStages(nameStages);
		if(pos != -1){
			stages[pos]="";
			msg= "The stages has culminated";
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
		for(int i = 0; i < SIZE && !isFound; i++){
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
		for(int i = 0; i < SIZE && !isFound; i++){
			if(stageProjects[i] == null){
				pos = i; 
				isFound = true;
			}
		}
		return pos; 
	}
}


