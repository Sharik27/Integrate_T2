package model;

// This class represents a stage project
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class StageProject {
    
	private String stageName;
	private String stageStatus;
    private Calendar initialDate;
    private Calendar finalDate;
    private DateFormat formatter;
    private Capsule [] capsules;

    private static final int CAPSULE_SIZE = 50;
/**
 * 
 * @param initialDate to add the initial date 
 * @param finalDate to add the final date
 * */
    public StageProject(String stageName, String stageStatus, Calendar initialDate, Calendar finalDate){

        this.formatter = new SimpleDateFormat("dd-MM-yyyy");

		this.stageName = stageName;
		this.stageStatus = stageStatus;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
        capsules = new Capsule [CAPSULE_SIZE];

    }

	public String getStageName() {
		return stageName;
	}

	public String getStageStatus() {
		return stageStatus;
	}	

    public String getInitialDateFormated(){
		return formatter.format(this.initialDate.getTime());
	}

	public String getFinalDateFormated(){
		return formatter.format(this.finalDate.getTime());
	}	

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	public void setStageStatus(String stageStatus) {
		this.stageStatus = stageStatus;
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
		for(int i = 0; i < CAPSULE_SIZE && !isFound; i++){
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
		for(int i = 0; i<CAPSULE_SIZE && !isFound; i++){
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

	public String addEmployee(String id, Employee employee){
		String msg = "";
		int pos = searhCapsules(id);
		if(pos!= -1){
			if(capsules[pos]!= null){
				msg= capsules[pos].addEmployee(employee);
			} 
		}
		return msg;
	}

	public String listCapsules(){
		String msg = "";

		for(int i= 0; i<CAPSULE_SIZE; i++){
			if(capsules[i]!= null){
				msg += capsules[i].toString();
			}
		}
		return msg;
	}

}
