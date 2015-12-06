package ch.bfh.btx8081.w2015.blue.HealthVisApp.Util;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller.UIController;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.CalendarView;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

public class CalendarButtonClickHandler implements Button.ClickListener {

	//================================================================================
    // Handler Data
    //================================================================================
	
	private UIController uiController = UIController.getInstance();
	
	//================================================================================
    // Handler Action
    //================================================================================
	
	@Override
	public void buttonClick(ClickEvent event) {
		//IMPLEMENT ADD APPOINTMENT POPUP
		CalendarView calView = CalendarView.getInstance();
		
		if(calView.getB_DailyView() == event.getSource()){
			calView.changeToDaily();
		}
		if(calView.getB_MonthlyView() == event.getSource()){
			calView.changeToMonthly();
		}
		if(calView.getB_WeeklyView() == event.getSource()){
			calView.changeToWeekly();
		}
		if(calView.getB_addApp() == event.getSource()){
			
		}
	}
}
