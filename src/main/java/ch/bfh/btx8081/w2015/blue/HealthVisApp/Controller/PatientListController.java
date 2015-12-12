package ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.CalendarView;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.PatientListView;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.Button.ClickEvent;

public class PatientListController {

	//================================================================================
    // PatientListController Data
    //================================================================================
	
	private static PatientListController plc = null;
	
	//================================================================================
    // Constructor Section
    //================================================================================
	
	private PatientListController(){
	}
	
	public static PatientListController getInstance() {
		if (plc == null) {
			plc = new PatientListController();
		}
		return plc;
	}
	
	public void FilterPatientListController(ValueChangeEvent event) {

		PatientListView PatListView = PatientListView.getInstance();
		
		System.out.println();
		String status =  ((String) PatListView.getCombobox().getValue()).substring(5);
		System.out.println(status);
		int value = Integer.valueOf(status);
		PatListView.FilterStatus(value);

	}

}