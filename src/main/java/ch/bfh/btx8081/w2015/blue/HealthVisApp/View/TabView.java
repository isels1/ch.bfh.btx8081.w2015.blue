package ch.bfh.btx8081.w2015.blue.HealthVisApp.View;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Util.CalendarButtonClickHandler;

import com.google.gwt.dom.client.Style.VerticalAlign;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Calendar;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
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
        
        //First Tab Calendar
        //Tab sheet need a Layout you can't add a calendar directly to the Tabsheet
        Calendar cal = CalendarView.initCalendarView();

        final Button b = new Button("Add Apointment");
        
        b.addClickListener(new CalendarButtonClickHandler());
        
        final VerticalLayout tabLayout = new VerticalLayout();
        tabLayout.addComponent(cal);
        tabLayout.addComponent(b);
        
        tabSheet.addTab(tabLayout, "Calendar");
                
        //Second Tab Patient
        tabSheet.addTab(new VerticalLayout(), "Patient");
        
        return tabSheet;
	}
}