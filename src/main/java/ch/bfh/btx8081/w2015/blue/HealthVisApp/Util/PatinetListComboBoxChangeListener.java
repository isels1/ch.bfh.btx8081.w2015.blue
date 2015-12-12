package ch.bfh.btx8081.w2015.blue.HealthVisApp.Util;

import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label.ValueChangeEvent;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller.PatientListController;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller.UIController;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.PatientListView;

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
