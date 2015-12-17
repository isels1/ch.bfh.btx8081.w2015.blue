package ch.bfh.btx8081.w2015.blue.HealthVisApp.Util;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller.UIController;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.PatientListPopUpView;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

/**
 * Class
 * <span class="courier">
 * <font face="courier new">
 * 		PatientButtonClickHandler
 * </font>
 * </span>
 * <span class="courier">
 * <font face="courier new">
 * 		 <b>implements</b> Button.ClickListener
 * </font>
 * </span>
 * <br>
 * <span style="margin-left:60px;">
 * 		...listens to the button event, to open the patient popp view
 * </span>
 * <br>
 * <br>
 * The PatientButtonClickHandler contains following information:
 * 	<ul>
 * 		<li>
 * 			<font face="courier new">
 * 				uiController:
 * 			</font> 
 * 			<i>UIController</i>
 * 			- The instance of the ui controller to open the popup
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
public class PatientButtonClickHandler implements Button.ClickListener {

	//================================================================================
    // Handler Data
    //================================================================================
	
	private UIController uiController = UIController.getInstance();
	
	//================================================================================
    // Handler Action
    //================================================================================
	
	@Override
	public void buttonClick(ClickEvent event) {
		PatientListPopUpView patView = uiController.getPatPopUpController().getPatView();
		
		if(patView.getButtonSave() == event.getSource()) {
			uiController.savePatient();
			uiController.closePatientPopUp();
		}
		
		if(patView.getButtonCancel() == event.getSource()) {
			uiController.closePatientPopUp();
		}
	}
}
