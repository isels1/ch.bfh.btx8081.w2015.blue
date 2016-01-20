package ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.HealthVisitor;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Persistence.DataProvider;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.LoginView;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.MainView;

/**
 * Class
 * <span class="courier">
 * <font face="courier new">
 * 		LoginController
 * </font>
 * </span>
 * <br>
 * <span style="margin-left:60px;">
 * 		...singleton class to handle the login.
 * </span>
 * <br>
 * <br>
 * The LoginController contains following information:
 * 	<ul>
 * 		<li>
 * 			<font face="courier new">
 * 				loginController:
 * 			</font> 
 * 			<i>LoginController</i>
 * 			- The singleton LoginController
 * 		</li>
 *	 </ul>
 * <br>
 * <span style="margin-left:60px;">
 * 		20.01.2016
 * </span>
 * <br><br>
 * @author isels1, dornt1
 * @version 1.0
 */
public class LoginController {
	
	//================================================================================
    // LoginController Data
    //================================================================================
	
	private static LoginController loginController;
	
	//================================================================================
    // Constructor Section
    //================================================================================
	
	/**
	 * Private Constructor for the loggin controller
	 */
	private LoginController(){
	}
	
	//================================================================================
    // Getter Section
    //================================================================================
	
	/**
	 * Getter for the instance of the singleton login controller
	 * @return LoginController, to handle the login
	 */
	public static LoginController getInstance() {
		if (loginController == null) {
			loginController = new LoginController();
		}
		return loginController;
	}
	
	//================================================================================
    // Login
    //================================================================================
	
	/**
	 * The login
	 * Reads the Login data from the gui
	 * Calls the Login from the data provider
	 * Calls LoadApp if login successful
	 * Calls WrongPw if login failed
	 */
	public void checkPW (){
		
		LoginView loginView = LoginView.getInstance();
		
		String password = loginView.getptf_Pw().getValue();
		String username = loginView.gettf_Username().getValue();
		
		DataProvider dp = DataProvider.getInstance();
		//Get The HealthVisitro whit username and password from the Database
		HealthVisitor hv = dp.login(username, password);
		
		//when password or Username wrong hv = null
		 if(hv != null && hv.getUserName().equals(username) //Double check whit username and password
				 && hv.getPassword().equals(password)) {
			    
			 	//set HealthVisitor for Database
			 	dp.setHealthVisitor(hv);
			 	//get Calendar for the HealthVisitor
			    dp.initCalendar();
			    dp.fillCalendar();
			    //Load application whit data from the current HealthVisitor
			    this.loadAPP();
		    }
		else {
			this.wrongPW();
		}
	}
	
	/**
	 * Function getting called when login success
	 * Loads the main view (Tab view)
	 */
	private void loadAPP(){
		MainView mainView = MainView.getInstance();
		mainView.initApplication();
	}
	
	/**
	 * Function getting called on false login
	 * Prints out "wrong user name or password"
	 */
	private void wrongPW(){
		System.out.println("wrong user name or password");
	}
}
