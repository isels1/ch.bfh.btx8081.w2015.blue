package ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller;

public class UIController {

	private static UIController c = null;
	
	private UIController(){
	}
	
	public static UIController getInstance() {
		if (c == null) {
			c = new UIController();
		}
		return c;
	}
}
