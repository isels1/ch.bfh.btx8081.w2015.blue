package ch.bfh.btx8081.w2015.blue.HealthVisApp.Util;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller.UIController;

import com.vaadin.event.ItemClickEvent;

public class PatientListItemClickListener implements ItemClickEvent.ItemClickListener {

	@Override
	public void itemClick(ItemClickEvent event) {		
		int id = (int) event.getItemId();
		UIController.getInstance().createPatientEditPopUp(id);
	}
}
