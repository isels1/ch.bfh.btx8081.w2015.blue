package ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.HealthVisitor;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Test.DummyDataCreator;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.LoginView;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.MainView;

public class LoginController {

	private static LoginController loginController;
	
	private LoginController(){
	}
	
	public static LoginController getInstance() {
		if (loginController == null) {
			loginController = new LoginController();
		}
		return loginController;
	}
	public void checkPW (){
			
		DummyDataCreator ddc;
		HealthVisitor hv;
		LoginView loginView = LoginView.getInstance();
		
		String password = loginView.getptf_Pw().getValue();
		String username = loginView.gettf_Username().getValue();
		
		ddc = DummyDataCreator.getInstance();
		hv = ddc.getHealthVisitor();
		
		//get list of Health Visitors
	
		if(username.equals(hv.getUserName())){
			if(password.equals(hv.getPassword())){
				this.loadAPP();
			}
			else{
			this.wrongPW();
			}
		}
		else{
		this.wrongPW();
		}
	}
	private void loadAPP(){
		MainView mainView = MainView.getInstance();
		mainView.initApplication();
	}
	private void wrongPW(){
		System.out.println("wrong username or password");
	}
}
