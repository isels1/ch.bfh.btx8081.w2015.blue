package ch.bfh.btx8081.w2015.blue.HealthVisApp.Util;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller.UIController;

import com.vaadin.event.ItemClickEvent;

/**
 * Class
 * <span class="courier">
 * <font face="courier new">
 * 		PatientListItemClickListener
 * </font>
 * </span>
 * <span class="courier">
 * <font face="courier new">
 * 		<b>implements</b> ItemClickEvent.ItemClickListener
 * </font>
 * </span>
 * <br>
 * <span style="margin-left:60px;">
 * 		...control click events from the patient list to open edit patient view
 * </span>
 * <br>
 * <br>
 * <b>
 * 		Creation date:
 * </b>
 * <br>
 * <span style="margin-left:60px;">
 * 		09.12.2015
 * </span>
 * <br><br>
 * @author isels1
 * @version 1.0
 */
@SuppressWarnings("serial")
public class PatientListItemClickListener implements ItemClickEvent.ItemClickListener {

	@Override
	public void itemClick(ItemClickEvent event) {		
		int id = (int) event.getItemId();
		UIController.getInstance().createPatientDetailView(id);
	}
}
