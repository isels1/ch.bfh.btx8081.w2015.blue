package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State;

/**
 * 
 * @author Stefan Iseli
 *
 */
public abstract class PatientState {
	private String css = "";
	private int id;
	private String name = "";
	
	/**
	 * 
	 * @return
	 */
	public String doEnter(){
		return css;
	}
	
	/**
	 * 
	 */
	public void doWhile(){}
	
	/**
	 * 
	 */
	public void doExit(){}
	
	/**
	 * 
	 * @param c
	 */
	public void setColor(String c){
		css = c;
	}
	
	/**
	 * 
	 * @param id
	 */
	public void setPatientStateId(int id){
		this.id = id;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getPatientStateId(){
		return id;
	}
	
	/**
	 * 
	 * @param n
	 */
	public void setPatientStateName(String n){
		name = n;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getPatientStateName(){
		return name;
	}
	
	@Override
	public String toString(){
		return name;
		
	}
}
