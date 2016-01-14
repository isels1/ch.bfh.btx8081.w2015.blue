package ch.bfh.btx8081.w2015.blue.HealthVisApp.View;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Util.CalendarButtonClickHandler;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Util.LoginButtonClickHandler;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * Class
 * <span class="courier">
 * <font face="courier new">
 * 		LoginView
 * </font>
 * </span>
 * <br>
 * <span style="margin-left:60px;">
 * 		creates an instance of a Login View.
 * </span>
 * <br>
 * <br>
 * the LoginView contains the following Vaadin Elements:
 * 	<ul>
 * 		<li>
 * 			<font face="courier new">
 * 				<b>a Vertical Layout with 2 textfields and a button:</b>
 * 			</font> 
 * 			<i>VerticalLayout</i>
 * 			- a textfield for the username, one for the password and a button to log in
 * 		</li>
 *	 </ul>
 * <b>
 * 		Creation date:
 * </b>
 * <br>
 * <span style="margin-left:60px;">
 * 		16.12.2015
 * </span>
 * <br><br>
 * @author nosec1
 * @version 1.0
 */

public class LoginView {
	
	//================================================================================
    // TabView Data
    //================================================================================
	
	private static LoginView loginView = null;
	private VerticalLayout headerLayout = null;
	private Button b_Login = new Button("login");
	private TextField tf_Username = new TextField("Username");
	private TextField tf_Pw = new TextField("Password");
	
	//================================================================================
    // Initialisation Section
    //================================================================================
	
	
	private LoginView() {
	headerLayout = new VerticalLayout(tf_Username, tf_Pw, b_Login);
	b_Login.addClickListener(new LoginButtonClickHandler());

		
	}
	
	/**
	 * Creates an instance of the LoginView class if doesn't exist yet
	 * @return an instance of the LoginView class
	 */
	public static LoginView getInstance() {
		if (loginView == null) {
			loginView = new LoginView();
		}
		return loginView;
	}
	
	/**¨
	 * 
	 * @return the Layout of the tabView Class
	 */
	public VerticalLayout getLayout (){
		return headerLayout;
	}
	
	
	
}
