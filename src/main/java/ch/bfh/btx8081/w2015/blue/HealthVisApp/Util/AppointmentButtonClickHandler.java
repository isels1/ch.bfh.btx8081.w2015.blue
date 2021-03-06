package ch.bfh.btx8081.w2015.blue.HealthVisApp.Util;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller.UIController;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.AppointmentPopUpView;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

/**
 * Class
 * <span class="courier">
 * <font face="courier new">
 * 		AppointmentButtonClickHandler
 * </font>
 * </span>
 * <span class="courier">
 * <font face="courier new">
 * 		 <b>implements</b> Button.ClickListener
 * </font>
 * </span>
 * <br>
 * <span style="margin-left:60px;">
 * 		...listens to the button event, to open the appointment pop up view
 * </span>
 * <br>
 * <br>
 * The AppointmentButtonClickHandler contains following information:
 * 	<ul>
 * 		<li>
 * 			<font face="courier new">
 * 				uiController:
 * 			</font> 
 * 			<i>UIController</i>
 * 			- The instance of the ui controller to open the popup view
 * 		</li>
 *	 </ul>
 * <br>
 * <b>
 * 		Creation date:
 * </b>
 * <br>
 * <span style="margin-left:60px;">
 * 		09.12.2015
 * </span>
 * <br><br>
 * @author zwahf1, dornt1, isels1
 * @version 1.0
 */
@SuppressWarnings("serial")
public class AppointmentButtonClickHandler implements Button.ClickListener{

	//================================================================================
    // Handler Data
    //================================================================================
	
	private UIController uiController = UIController.getInstance();
	
	//================================================================================
    // Handler Action
    //================================================================================
	
	@Override
	public void buttonClick(ClickEvent event) {
		AppointmentPopUpView appView = uiController.getAppPopUpController().getAppView();
		
		if(appView.getButtonSave() == event.getSource()) {
			uiController.saveAppointment();
			uiController.closeAppointmentPopUp();
		}
		
		if(appView.getButtonCancel() == event.getSource()) {
			uiController.closeAppointmentPopUp();
		}
	}
}
