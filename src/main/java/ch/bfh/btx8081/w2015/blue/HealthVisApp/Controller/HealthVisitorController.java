package ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Calendar;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.HealthVisitor;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Test.DummyDataCreator;

public class HealthVisitorController {
	private DummyDataCreator ddc;
	private HealthVisitor hv;
	
	public HealthVisitorController(){
		ddc = DummyDataCreator.getInstance();
		hv = ddc.getHealthVisitor();
	}
	
	public Calendar getCalendar(){
		return hv.getCalendar();
	}
}
