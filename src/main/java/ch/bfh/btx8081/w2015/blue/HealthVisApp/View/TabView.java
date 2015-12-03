package ch.bfh.btx8081.w2015.blue.HealthVisApp.View;

import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class TabView {

	//================================================================================
    // TabView Data
    //================================================================================
	
	final static float WIDTH= 315.0f;
	final static float HEIGHT= 568.0f;
	private static TabView tabView = null;
	private TabSheet tabSheet;
	
	//================================================================================
    // Initialisation Section
    //================================================================================
	
	private TabView()
	{
        tabSheet = new TabSheet();
        tabSheet.setHeight(HEIGHT, Unit.PERCENTAGE);
        tabSheet.setWidth(WIDTH, Unit.PERCENTAGE);
        tabSheet.addStyleName(ValoTheme.TABSHEET_FRAMED);
        tabSheet.addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);
        
        //First Tab Calendar
        //Tab sheet need a Layout you can't add a calendar directly to the Tabsheet
        CalendarView cal = CalendarView.getInstance(); 
        VerticalLayout tabLayout = cal.getCalendarView();
        
        tabSheet.addTab(tabLayout, "Calendar");
                
        //Second Tab Patient
        tabSheet.addTab(new VerticalLayout(), "Patient");
       
	}
	
	public static TabView getInstance() {
		if (tabView == null) {
			tabView = new TabView();
		}
		return tabView;
	}
	
	public TabSheet getTabSheet (){
		return tabSheet;
	}
}