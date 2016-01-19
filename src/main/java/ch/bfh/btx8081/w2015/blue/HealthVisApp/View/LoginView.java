package ch.bfh.btx8081.w2015.blue.HealthVisApp.View;

import java.io.File;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Util.LoginButtonClickHandler;

import com.vaadin.server.FileResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Image;
import com.vaadin.ui.PasswordField;
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

	private VerticalLayout vlUsername = null;
	private VerticalLayout vlPassword = null;
	private VerticalLayout vlLoginButton = null;
	
	private VerticalLayout vlLoginpicture = null;
	
	final static String LOGINWIDTH = "320";
	final static String LOGINHEIGHT= "568";
	
	final static String BUTTONWIDTH = "200";
	final static String  FIELDHEIGHT = "94";
	final static String BUTTONHEIGHT = "40";
	
	private Button b_Login = new Button("login");
	private TextField tf_Username = new TextField("Username");
	
	private PasswordField pf_Pw = new PasswordField("Password");
	
	//================================================================================
    // Initialisation Section
    //================================================================================
	
	private LoginView() {
	headerLayout = new VerticalLayout();

	tf_Username.setWidth(BUTTONWIDTH);
	tf_Username.setHeight(BUTTONHEIGHT);
	vlUsername = new VerticalLayout();
	vlUsername.setWidth(LOGINWIDTH);
	vlUsername.setHeight(FIELDHEIGHT);
	vlUsername.addComponent(tf_Username);
	vlUsername.setMargin(true);
	
	pf_Pw.setWidth(BUTTONWIDTH);
	pf_Pw.setHeight(BUTTONHEIGHT);
	vlPassword = new VerticalLayout();
	vlPassword.setWidth(LOGINWIDTH);
	vlPassword.setHeight(FIELDHEIGHT);
	vlPassword.addComponent(pf_Pw);
	vlPassword.setMargin(true);
	
	b_Login.setWidth(BUTTONWIDTH);
	b_Login.setHeight(BUTTONHEIGHT);
	vlLoginButton = new VerticalLayout();
	vlLoginButton.setWidth(LOGINWIDTH);
	vlLoginButton.setHeight(FIELDHEIGHT);
	vlLoginButton.addComponent(b_Login);
	vlLoginButton.setMargin(true);

	vlLoginpicture = new VerticalLayout();
	vlLoginpicture.setHeight("287");
	vlLoginpicture.setMargin(true);
	
	// Image as a file resource
	FileResource resource = new FileResource(new File("src/main/webapp/VAADIN/themes/HealthVisAppTheme/loginpicture.png"));

	// Show the image in the application
	Image image = new Image("", resource);
	vlLoginpicture.addComponent(image);
	
	headerLayout.addComponent(vlUsername);
	headerLayout.addComponent(vlPassword);
	headerLayout.addComponent(vlLoginButton);
	headerLayout.addComponent(vlLoginpicture);

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
	/**
	 * 
	 * @return the Layout of the tabView Class
	 */
	public VerticalLayout getLayout (){
		return headerLayout;
	}
	public TextField gettf_Username(){
		return tf_Username;
	}
	public PasswordField getptf_Pw(){
		return pf_Pw;
	}
	
	
}
