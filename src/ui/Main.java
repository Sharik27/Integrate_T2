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
        System.out.println("6. Consult the amount of capsules for each type of capsule");
        System.out.println("7. list of lessons learned");
        System.out.println("8. Consult the name of the project with the most registered capsules");
        System.out.println("9. Consult if a collaborator has registered capsules in any project");
        System.out.println("10. consult published capsule");
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

            case 6:
            consultAmountTypeCapsule();
            break;

            case 7:
            listAllCapsule();
            break;

            case 8:
            consultAmountCapsule();
            break;

            case 9:
            seeRegisterCapsule();
            break;

            case 10:
            consultCapsulePublished();
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
    
        System.out.println("Type the name of the customer :");
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
        String projectName;
        String name;
        String phone;
    
        System.out.println("type the name of the project");
        projectName = reader.next();

        System.out.println("Type the name project manager:");
        name = reader.next();
        
        System.out.println("Type the phone project manager:");
        phone = reader.next(); 
        
        String msg = controller.addManager(projectName, name, phone);
        System.out.println(msg);
    }

    public void addStage(){
        String projectName;
        Calendar initialDate;
        Calendar finalDate;
        int monthInitial;
        int monthFinal;
        int monthFinal2 = 0;

        System.out.println("Type the name of the project: ");
        projectName = reader.next();
    
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
    
        controller.addStage(projectName, initialDate, finalDate);
    
    }

    public void culminateStage(){
        String projectName;
        String nameStage;
        Calendar finishStage;

        System.out.println("Type the name of the project: ");
        projectName= reader.next();
       
        System.out.println("Type the name of the stage: ");
        nameStage = reader.next();

        finishStage = Calendar.getInstance();
	    String timeStamp = formatter.format(finishStage.getTime());
        System.out.println("The end date is: "+timeStamp);

        controller.culminateStage(projectName, nameStage);
        addStage();
        
    }

    public void addCapsule(){
        String projectName;
        String stageName;
        String id;
        String description;
        boolean approval = false;
        int option = 0;

        System.out.println("Type the name of the project");
        projectName= reader.next();

        System.out.println("Type the name of the stage");
        stageName = reader.next();

        System.out.println("Type the id  capsule: ");
        id = reader.next();

        System.out.println("Type description capsule: ");
        description = reader.next();

        System.out.println("Type capsule:");
        System.out.println("1. Technial");
        System.out.println("2. Management");
        System.out.println("3. Control");
        System.out.println("4. Experience");
        option = reader.nextInt();

        controller.addCapsule(projectName, stageName, id, description, option, approval);

    }
    
    public void addEmployee(){
        String projectName;
        String id;
        String name;
        String position;

        System.out.println("Type the name of the project");
        projectName = reader.next();

        System.out.println("Type the id capsule");
        id = reader.next();

        System.out.println("Type the name of the employee:");
        name = reader.next();
    
        System.out.println("Type the position employee:");
        position = reader.next(); 
    
        String msg = controller.addEmployee(projectName, id, name, position);
        System.out.println(msg);

    }

    public void approvalCapsule(){
        String projectName;
        String stageName;
        String id;

        System.out.println("Type the name of the proyect");
        projectName = reader.next();

        System.out.println("Type the name of the stage");
        stageName = reader.next();

        System.out.println("Type Id the capsule:");
        id = reader.next();

        controller.approvalCapsule(projectName, stageName, id);

    }
    
    public void publicationCapsule(){
        String projectName;
        String stageName;
        String id;

        System.out.println("Type the name of the  project");
        projectName = reader.next();

        System.out.println("Type the name of the stage");
        stageName = reader.next();

        System.out.println("Type Id the capsule:");
        id = reader.next();

        controller.publicationCapsule(projectName, stageName, id);
    }

    public void consultAmountTypeCapsule(){

        String projectName;
        String stageName;

        System.out.println("Type the name of the project you want to consult");
        projectName= reader.next();

        System.out.println("Type the name of the stage you want to consult ");
        stageName= reader.next();

        String msg = controller.consultAmountTypeCapsule(projectName, stageName);
        System.out.println(msg);
    }

    public void listAllCapsule(){
        String projectName;
        String stageName;

        System.out.println("Type the name of the project you want to view capsules for");
        projectName = reader.next();

        System.out.println("Type the name of the stage you want to view capsules for");
        stageName= reader.next();

        String msg = controller.consultCapsule(projectName, stageName);
        System.out.println(msg);
    }

    public void consultAmountCapsule(){
        String projectName;

        System.out.println("Type the name of the project you want to consult the amount of capsule: ");
        projectName = reader.next();

        String msg = controller.consultAmountCapsule(projectName);
        System.out.println(msg);
    }

    public void seeRegisterCapsule(){
        String projectName;
        String stageName;
        String id;
        String name;

        System.out.println("Type the name of the project project you want : ");
        projectName = reader.next();

        System.out.println("Type the name stage: ");
        stageName = reader.next();

        System.out.println("Type the id capsule: ");
        id = reader.next();

        System.out.println("Type the name employee: ");
        name = reader.next();

        String msg = controller.seeRegisterCapsule(projectName, stageName, id, name);
        System.out.println(msg);
    }

    public void consultCapsulePublished(){
        String keyword;

        System.out.println("write the key words with a # at the beginning and end of the word  ");
        keyword = reader.next();

        String msg = controller.consultCapsulePublished(keyword);
        System.out.println(msg);
    }

}
