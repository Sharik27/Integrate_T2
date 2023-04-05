package model;

// This class represents a stage project
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class StageProject {
    
    private Calendar initialDate;
    private Calendar finalDate;
    private DateFormat formatter;
    private Capsule [] capsules;

    private static final int SIZE = 50;
/**
 * 
 * @param initialDate to add the initial date 
 * @param finalDate to add the final date
 * */
    public StageProject(Calendar initialDate, Calendar finalDate){

        this.formatter = new SimpleDateFormat("dd-MM-yyyy");
        capsules = new Capsule [SIZE];

    }

    public String getInitialDateFormated(){
		return formatter.format(this.initialDate.getTime());
	}

	public String getFinalDateFormated(){
		return formatter.format(this.finalDate.getTime());
	}	
/**
 * 
 * @param capsule to add a capsule
 * @return is a message that saving capsule added
 * */
    public String addCapsule(Capsule capsule){
		String msg = "Capsule have not been created";
		int pos = getFirstValidPositionCapsules(); 
		if(pos != -1){
			capsules[pos] = capsule; 
			msg = "Capsule added"; 
		}

		return msg;
	}

    public int getFirstValidPositionCapsules(){
		int pos = -1; 
		boolean isFound = false; 
		for(int i = 0; i < SIZE && !isFound; i++){
			if(capsules[i] == null){
				pos = i; 
				isFound = true;
			}
		}
		return pos; 
	}
/**
 * 
 * @param id to add the capsule identifier
 * @return
 * */
    public String approvalCapsule(String id){
		String msg = "Capsule have not been approval";
		int pos = searhCapsules(id);
		if(pos != -1){
			capsules[pos].setApproval(true);
			msg= "The capsule has approval";
		}

		return msg;
	}
/**
 * 
 * @param id to searh Capsule
 * @return
 * */
    public  int searhCapsules(String id){
		boolean isFound= false;
		int pos = -1;
		for(int i = 0; i<SIZE && !isFound; i++){
			if(capsules[i].getId().equalsIgnoreCase(id)){
				isFound = true;
				pos = i;
			}
		}
		return pos;
	}
/**
 * 
 * @param id to publish a capsule if approved
 * @return is a message that saving the capsule has publication
 * */
    public String publicationCapsule(String id){
        String msg = "Capsule have not been publication";
        int pos = searhCapsules(id);
        
        if(pos != -1){
         boolean approval = capsules[pos].getApproval();

         if (approval == true){
            System.out.println("www."+capsules[pos].getId()+".com");
            msg = "The capsule has publication";
         }
        }
       

        return msg;
    }

}
