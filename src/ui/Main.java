package ui;

import java.util.Calendar;
import java.util.Scanner;
import model.Controller;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class Main{

	private Scanner reader;
	private Controller controller;
    private DateFormat formatter;

	public Main() {
 
		reader = new Scanner(System.in);
		controller = new Controller();
        formatter = new SimpleDateFormat("dd-MM-yyyy");
	}

	public static void main(String[] args) {

		Main view = new Main();

		int option = 0;
		do{
		view.menu();
		option = view.validateIntegerInput();
		view. executeoption(option);
		}while(option !=0);

		view.reader.close();		

	}

	// menu displayed to the user
	public void menu(){

	    System.out.println("1. Register project");
        System.out.println("2. Culminate stage");
        System.out.println("3. Register capsule");
        System.out.println("4. Approval capsule ");
        System.out.println("5. Publication capsule");
        System.out.println("0. Exit");
	}
// cases with their methods
	public void executeoption(int option){
		switch(option){
			case 1:
			registerProject();
            addManager();
            addStage();
			break;

			case 2:
			culminateStage();
			break;

			case 3:
            addCapsule();
            addEmployee();			
			break;

            case 4:
            approvalCapsule();
            break;

            case 5:
            publicationCapsule();
            break;

			case 0:
			System.out.println("exit");
			break;

			case -1:
			System.out.println("invalit option!!");
        	break;


		}
	}

	public int validateIntegerInput(){
       int option = 0;
        if (reader.hasNextInt()){
            option = reader.nextInt();
        }
        else{
            reader.nextLine();
            option = -1;
            System.out.println("Ingrese el valor entero:");
        }
        return option;
    }
// message displayed to the user on the screen  
	public void registerProject() {
        String name;
        String clientName;
        Calendar initialDate;
        Calendar finalDate;
        int monthInitial;
        int monthFinal;
        int monthFinal2 = 0;
        double budget;
        
    
        System.out.println("Type the name of the project:");
        name = reader.next();
    
        System.out.println("Type customer name:");
        clientName = reader.next();
    
        System.out.println("After a few months, the project begins:");
        monthInitial = reader.nextInt();
        initialDate = Calendar.getInstance();
        initialDate.add(Calendar.MONTH, monthInitial);
        String timeStamp = formatter.format(initialDate.getTime());
        System.out.println("The start date is: "+timeStamp);
    
        System.out.println("Enter in months how long the project will last:");
        monthFinal = reader.nextInt();
        monthFinal2 = monthFinal+monthInitial;
        finalDate = Calendar.getInstance();
        finalDate.add(Calendar.MONTH, monthFinal2);
        String timeStamp2 = formatter.format(finalDate.getTime());
        System.out.println("The end date is: "+timeStamp2);
    
        System.out.println("Enter the budget for the project:");
        budget= reader.nextDouble();
    
       
    
        controller.registerProject(name, clientName, initialDate, finalDate, budget);
    }
    
    public void addManager(){
        String name;
        String phone;
    
        System.out.println("Type the name project manager:");
        name = reader.next();
        
        System.out.println("Type the phone project manager:");
        phone =reader.next(); 
        
        String msg = controller.addManager(name, phone);
        System.out.println(msg);
    }

    public void addStage(){
        Calendar initialDate;
        Calendar finalDate;
        int monthInitial;
        int monthFinal;
        int monthFinal2 = 0;
    
        System.out.println("After a few months, the stage begins:");
        monthInitial = reader.nextInt();
        initialDate = Calendar.getInstance();
        initialDate.add(Calendar.MONTH, monthInitial);
        String timeStamp = formatter.format(initialDate.getTime());
        System.out.println("The start date is: "+timeStamp);
    
        System.out.println("Enter in months how long the stage will last:");
        monthFinal = reader.nextInt();
        monthFinal2 = monthFinal+monthInitial;
        finalDate = Calendar.getInstance();
        finalDate.add(Calendar.MONTH, monthFinal2);
        String timeStamp2 = formatter.format(finalDate.getTime());
        System.out.println("The end date is: "+timeStamp2);
    
        controller.addStage(initialDate, finalDate);
    
    }

    public void culminateStage(){
        String nameStage;
        Calendar finishStage;
        Calendar initialDate;
        Calendar finalDate;
        int monthInitial;
        int monthFinal;
        int monthFinal2 = 0;

        System.out.println("Type name stage:");
        nameStage = reader.next();

        finishStage = Calendar.getInstance();
	    String timeStamp = formatter.format(finishStage.getTime());
        System.out.println("The end date is: "+timeStamp);

        controller.culminateStage(nameStage);

        System.out.println("After a few months, the project begins:");
        monthInitial = reader.nextInt();
        initialDate = Calendar.getInstance();
        initialDate.add(Calendar.MONTH, monthInitial);
        String timeStamp2 = formatter.format(initialDate.getTime());
        System.out.println("The start date is: "+timeStamp2);

        System.out.println("Enter in months how long the project will last:");
        monthFinal = reader.nextInt();
        monthFinal2 = monthFinal+monthInitial;
        finalDate = Calendar.getInstance();
        finalDate.add(Calendar.MONTH, monthFinal2);
        String timeStamp3 = formatter.format(finalDate.getTime());
        System.out.println("The end date is: "+timeStamp3);

        controller.addStage(initialDate, finalDate);
        
    }

    public void addCapsule(){
        String id;
        String description;
        String typeCapsule = "";
        boolean approval = false;
        int option = 0;

        System.out.println("Type id:");
        id = reader.next();

        System.out.println("Type description:");
        description = reader.next();

        System.out.println("Type capsule:");
        System.out.println("1. Technial");
        System.out.println("2. Management");
        System.out.println("3. Control");
        System.out.println("4. Experience");
        option = reader.nextInt();

        if(option == 1){
            typeCapsule = "Technial";
        }else if(option == 2 ){
            typeCapsule = "Management";
        }
        else if(option == 3 ){
            typeCapsule = "Control";
        }
        else if(option == 4 ){
            typeCapsule = "Experience";
        }

        controller.addCapsule(id, description, typeCapsule, approval);

    }
    
    public void addEmployee(){
        String name;
        String position;

        System.out.println("Type the name employee:");
        name = reader.next();
    
        System.out.println("Type the position employee:");
        position =reader.next(); 
    
        String msg = controller.addEmployee(name, position);
        System.out.println(msg);

    }

    public void approvalCapsule(){
        String id;

        System.out.println("Type ID the capsule:");
        id = reader.next();

        controller.approvalCapsule(id);
    }
    
    public void publicationCapsule(){
        String id;

        System.out.println("Type ID the capsule:");
        id = reader.next();

        controller.publicationCapsule(id);
    }
}
