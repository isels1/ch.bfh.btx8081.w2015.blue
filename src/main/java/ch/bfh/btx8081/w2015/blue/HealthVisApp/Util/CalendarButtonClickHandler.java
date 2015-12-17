package ch.bfh.btx8081.w2015.blue.HealthVisApp.Util;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Controller.UIController;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.CalendarView;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

/**
 * Class
 * <span class="courier">
 * <font face="courier new">
 * 		CalendarButtonClickHandler
 * </font>
 * </span>
 * <span class="courier">
 * <font face="courier new">
 * 		 <b>implements</b> Button.ClickListener
 * </font>
 * </span>
 * <br>
 * <span style="margin-left:60px;">
 * 		...listens to the button event, to get the daily, weekly or monthly view of the calendar
 * </span>
 * <br>
 * <br>
 * The CalendarButtonClickHandler contains following information:
 * 	<ul>
 * 		<li>
 * 			<font face="courier new">
 * 				uiController:
 * 			</font> 
 * 			<i>UIController</i>
 * 			- The instance of the ui controller to change the view
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
		CalendarView calView = CalendarView.getInstance();
		
		if(calView.getB_DailyView() == event.getSource() ||
				calView.getB_MonthlyView() == event.getSource() ||
				calView.getB_WeeklyView() == event.getSource()){
			
			uiController.changeCalendarViewController(event);
		}
		
		if(calView.getB_addApp() == event.getSource()){
			uiController.createAppointmentPopUp();
		}
	}
}
