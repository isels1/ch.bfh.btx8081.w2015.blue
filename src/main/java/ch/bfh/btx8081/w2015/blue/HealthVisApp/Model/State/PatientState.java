package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State;

public abstract class PatientState {
	private String css = "";
	private int id;
	
	public String doEnter(){
		return css;
	}
	
	public void doWhile(){}
	
	public void doExit(){}
	
	public void setColor(String c){
		css = c;
	}
	
	public void setPatientStateId(int id){
		this.id = id;
	}
	
	public int getPatientStateId(){
		return id;
	}
}
