package ch.bfh.btx8081.w2015.blue.HealthVisApp.Util;


import ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller.LoginController;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

@SuppressWarnings("serial")
public class LoginButtonClickHandler implements Button.ClickListener{

	@Override
	public void buttonClick(ClickEvent event) {
	
		LoginController loginController = LoginController.getInstance();
		loginController.checkPW();
	}	
}
