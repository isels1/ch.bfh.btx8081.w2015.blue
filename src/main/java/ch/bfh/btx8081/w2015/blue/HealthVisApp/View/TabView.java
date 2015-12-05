package ch.bfh.btx8081.w2015.blue.HealthVisApp.View;

import com.vaadin.server.FontAwesome;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class TabView {

	//================================================================================
    // TabView Data
    //================================================================================
	
	final static String WIDTH= "310";
	final static String HEIGHT= "555";
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
        VerticalLayout tabLayout = cal.getCalendarView();
        
        tabSheet.addTab(tabLayout, " My Calendar ");
                
        
        //Second Tab Patient
        tabSheet.addTab(new VerticalLayout(), " Patient List ");
        tabSheet.getTab(0).setIcon(FontAwesome.CALENDAR);
        tabSheet.getTab(1).setIcon(FontAwesome.USER);
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