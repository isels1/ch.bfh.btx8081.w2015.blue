package ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State;

public abstract class PatientState {
	private String color = "";
	
	public String doEnter(){
		return color;
	}
	
	public void doWhile(){}
	
	public void doExit(){}
	
	public void setColor(String c){
		color = c;
	}
	
}
