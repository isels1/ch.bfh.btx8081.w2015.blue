package ch.bfh.btx8081.w2015.blue.HealthVisApp;

import javax.servlet.annotation.WebServlet;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.CalendarView;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.TabView;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Calendar;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.components.calendar.event.BasicEventProvider;
import com.vaadin.ui.components.calendar.event.CalendarEventProvider;
import com.vaadin.ui.themes.ValoTheme;

/**
 *
 */
@Theme("HealthVisAppTheme")
@Widgetset("ch.bfh.btx8081.w2015.blue.HealthVisApp.HealthVisAppWidgetset")
public class HealthVisAppUI extends UI {

	final String HEIGHT = "568";
	final String WIDTH = "320";
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setHeight(HEIGHT);
        layout.setWidth(WIDTH);
        layout.setMargin(true);
        setContent(layout);

        layout.addComponent(TabView.initTabView());
    }

    @WebServlet(urlPatterns = "/*", name = "HealthVisAppUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = HealthVisAppUI.class, productionMode = false)
    public static class HealthVisAppUIServlet extends VaadinServlet {
    }
}
