package ch.bfh.btx8081.w2015.blue.HealthVisApp.View;

import com.vaadin.server.FontAwesome;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class TabView {

	//================================================================================
    // TabView Data
    //================================================================================
	
	final static String WIDTH= "320";
	final static String HEIGHT= "568";
	private static TabView tabView = null;
	private TabSheet tabSheet;
	
	//================================================================================
    // Initialisation Section
    //================================================================================
	
	private TabView()
	{
        tabSheet = new TabSheet();
        tabSheet.setHeight(HEIGHT);;
        tabSheet.setWidth(WIDTH);;
        tabSheet.addStyleName(ValoTheme.TABSHEET_FRAMED);
        tabSheet.addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);
        
        //First Tab Calendar
        //Tab sheet need a Layout you can't add a calendar directly to the Tabsheet
        CalendarView cal = CalendarView.getInstance(); 
        VerticalLayout tabLayoutCal = cal.getCalendarView();
        
        tabSheet.addTab(tabLayoutCal, " My Calendar ");
        //Second Tab Patient
        
       PatientListView PatListView = PatientListView.getInstance();
       VerticalLayout tabLayoutPat = PatListView.getPatientList();
       tabSheet.addTab(tabLayoutPat, "My Patient List ");
       tabSheet.getTab(0).setIcon(FontAwesome.CALENDAR);
       tabSheet.getTab(1).setIcon(FontAwesome.USERS);
	}
	/**
	 * this Methode creates a Instance of the Tabview class if it not already exist
	 * @return a Instance of the TabView class
	 */
	public static TabView getInstance() {
		if (tabView == null) {
			tabView = new TabView();
		}
		return tabView;
	}
	/**¨
	 * 
	 * @return the tabSheet of the tabView Class
	 */
	public TabSheet getTabSheet (){
		return tabSheet;
	}
}