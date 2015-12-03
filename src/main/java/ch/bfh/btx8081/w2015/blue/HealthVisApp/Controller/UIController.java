package ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller;

public class UIController {

	//================================================================================
    // UIController Data
    //================================================================================
	
	private static UIController c = null;
	
	//================================================================================
    // Constructor Section
    //================================================================================
	
	private UIController(){
	}
	
	public static UIController getInstance() {
		if (c == null) {
			c = new UIController();
		}
		return c;
	}
	
	
}
