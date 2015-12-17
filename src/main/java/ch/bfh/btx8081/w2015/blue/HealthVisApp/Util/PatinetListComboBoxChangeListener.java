package ch.bfh.btx8081.w2015.blue.HealthVisApp.Util;

import com.vaadin.ui.ComboBox;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller.PatientListController;

/**
 * Class
 * <span class="courier">
 * <font face="courier new">
 * 		PatinetListComboBoxChangeListener
 * </font>
 * </span>
 * <span class="courier">
 * <font face="courier new">
 * 		<b>implements</b> ComboBox.ValueChangeListener
 * </font>
 * </span>
 * <br>
 * <span style="margin-left:60px;">
 * 		...control the combobox chanche events from the patient list filter combobox to filter the patient view.
 * </span>
 * <br>
 * <br>
 * The PatinetListComboBoxChangeListener contains following information:
 * 	<ul>
 * 		<li>
 * 			<font face="courier new">
 * 				patListController:
 * 			</font> 
 * 			<i>PatientListController</i>
 * 			- PatientListController object for the filter options
 * 		</li>
 *	 </ul>
 * <br>
 * <b>
 * 		Creation date:
 * </b>
 * <br>
 * <span style="margin-left:60px;">
 * 		xx.xx.2015
 * </span>
 * <br><br>
 * @author zwahf1, dornt1, isels1
 * @version 1.0
 */
@SuppressWarnings("serial")
public class PatinetListComboBoxChangeListener implements ComboBox.ValueChangeListener{

	//================================================================================
    // Handler Data
    //================================================================================
	
	private PatientListController patListController = PatientListController.getInstance();
	
	//================================================================================
    // Handler Action
    //================================================================================
	
	@Override
	public void valueChange(com.vaadin.data.Property.ValueChangeEvent event) {
		patListController.FilterPatientListController(event);
	}
}
