package ch.bfh.btx8081.w2015.blue.HealthVisApp.View;

import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Calendar;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class TabView {

	final static float WIDTH= 315.0f;
	final static float HEIGHT= 568.0f;
	
	public static TabSheet initTabView()
	{
        TabSheet tabSheet = new TabSheet();
        tabSheet.setHeight(HEIGHT, Unit.PERCENTAGE);
        tabSheet.setWidth(WIDTH, Unit.PERCENTAGE);
        tabSheet.addStyleName(ValoTheme.TABSHEET_FRAMED);
        tabSheet.addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);
        
        Calendar cal = CalendarView.initCalendarView();
        
        //Tab sheet need a Layout you can't add a calendar directly to the Tabsheet
        final VerticalLayout calLayout= new VerticalLayout(cal);
        calLayout.setWidth(WIDTH, Unit.PERCENTAGE);
        calLayout.setHeight(HEIGHT, Unit.PERCENTAGE);
        tabSheet.addTab(calLayout, "Calendar");
        
      //Tab sheet need a Layout you can't add a calendar directly to the Tabsheet
        final VerticalLayout patLayout= new VerticalLayout();
        patLayout.setWidth(WIDTH, Unit.PERCENTAGE);
        patLayout.setHeight(HEIGHT, Unit.PERCENTAGE);
        tabSheet.addTab(patLayout, "Patient");
        
        return tabSheet;
	}
}
