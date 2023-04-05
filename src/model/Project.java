package model;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;




public class Project{
	
	private static final int SIZE = 10;
	private String name;
	private String clientName;
	private Calendar initialDate;
	private Calendar finalDate;
	private double budget;

	private Manager[] managers;
	private DateFormat formatter;


	public Project(String name, String clientName, Calendar initialDate, Calendar finalDate, double budget){
		
		this.formatter = new SimpleDateFormat("dd-MM-yyyy");

		this.name = name;	
		this.clientName = clientName;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.budget = budget;

		managers = new Manager [SIZE];
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

	public String addManager(Manager manager){
		String msg = "Manager could not be added ";
		int pos = getFirstValidPositionManager(); 
		if(pos != -1){
			managers[pos] = manager; 
			msg = "Manager added"; 
		}

		return msg;
	}

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
}


