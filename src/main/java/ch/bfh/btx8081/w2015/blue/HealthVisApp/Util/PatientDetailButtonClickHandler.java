package ch.bfh.btx8081.w2015.blue.HealthVisApp.Util;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller.UIController;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.PatientDetailView;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.PatientListPopUpView;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

/**TODO
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
public class PatientDetailButtonClickHandler implements Button.ClickListener {

	@Override
	public void buttonClick(ClickEvent event) {
		PatientDetailView patView = UIController.getInstance().getPatDetailController().getPatDetailView();
		
		if(patView.getB_edit() == event.getSource()) {
			UIController.getInstance().createPatientEditPopUp(patView.getPatient().getId());
		}
		
		if(patView.getB_quit() == event.getSource()) {
			UIController.getInstance().closePatientDetailView();
		}
	}
}
