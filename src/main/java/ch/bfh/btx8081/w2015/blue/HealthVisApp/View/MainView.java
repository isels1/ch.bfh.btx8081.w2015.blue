package ch.bfh.btx8081.w2015.blue.HealthVisApp.View;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
/**
 * Class
 * <span class="courier">
 * <font face="courier new">
 * 		PatietnListView
 * </font>
 * </span>
 * <br>
 * <span style="margin-left:60px;">
 * 		creates an instance of a PatientListView.
 * </span>
 * <br>
 * <br>
 * the PatietnListView contains following Vaadin Elements:
 * 	<ul>
 * 		<li>
 * 			<font face="courier new">
 * 				<b>a Combobox:</b>
 * 			</font> 
 * 			<i>Combobox</i>
 * 			 - whit a Filter for each Patient State
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				<b>a Table:</b>
 * 			</font> 
 * 			<i>Table</i>
 * 			- List whit all patients
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				<b>a Button:</b>
 * 			</font> 
 * 			<i>Button</i>
 * 			- add a new patient Button
 * 		</li>
 *	 </ul>
 * <b>
 * 		Creation date:
 * </b>
 * <br>
 * <span style="margin-left:60px;">
 * 		01.12.2015
 * </span>
 * <br><br>
 * @author dornt1 isels1
 * @version 0.0
 */
public class MainView {

	//================================================================================
    // TabView Data
    //================================================================================
	
	final static String WIDTH= "320";
	final static String HEIGHT= "568";
	private static MainView mainView = null;
	private HorizontalLayout horizontalLayout;
	
	private TabView tabView;
	//================================================================================
    // Initialisation Section
    //================================================================================
	
	private MainView()
	{
		horizontalLayout = new HorizontalLayout();
		horizontalLayout.setHeight(HEIGHT);;
		horizontalLayout.setWidth(WIDTH);;

        LoginView loginView = LoginView.getInstance();
        horizontalLayout.addComponent(loginView.getLayout());


	}
	/**
	 * this Methode creates a Instance of the Tabview class if it not already exist
	 * @return a Instance of the TabView class
	 */
	public static MainView getInstance() {
		if (mainView == null) {
			mainView = new MainView();
		}
		return mainView;
	}
	/**¨
	 * 
	 * @return the tabSheet of the tabView Class
	 */
	public void initApplication (){
		horizontalLayout.removeAllComponents();
        tabView = TabView.getInstance();
        horizontalLayout.addComponent(tabView.getTabSheet());
	}
	public HorizontalLayout getHorizontalLayout (){
		return horizontalLayout;
	}
}
