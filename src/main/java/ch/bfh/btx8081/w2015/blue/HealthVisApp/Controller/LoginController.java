package ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.HealthVisitor;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Persistence.DataProvider;
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
		
		//this.loadAPP();
		LoginView loginView = LoginView.getInstance();
		
		String password = loginView.getptf_Pw().getValue();
		String username = loginView.gettf_Username().getValue();
		
		DataProvider dp = DataProvider.getInstance();
		
		HealthVisitor hv = dp.login(username, password);
		
		 if(hv != null && hv.getUserName().equals(username)
				 && hv.getPassword().equals(password)) {
			    dp.setHealthVisitor(hv);

			    dp.initCalendar();
			    dp.fillCalendar();
			    this.loadAPP();
		    }
		else {
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
