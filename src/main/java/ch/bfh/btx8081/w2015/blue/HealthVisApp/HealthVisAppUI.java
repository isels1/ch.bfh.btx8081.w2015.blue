package ch.bfh.btx8081.w2015.blue.HealthVisApp;

import javax.servlet.annotation.WebServlet;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.TabView;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.ClassResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Image;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 *
 */
@Theme("HealthVisAppTheme")
@Widgetset("ch.bfh.btx8081.w2015.blue.HealthVisApp.HealthVisAppWidgetset")
public class HealthVisAppUI extends UI {

	//================================================================================
    // HealthVisAppUI Data
    //================================================================================
	final String HEIGHT = "568";
	final String WIDTH = "320";
	
	//================================================================================
    // Initialisation Section
    //================================================================================
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setHeight(HEIGHT);
        layout.setWidth(WIDTH);
        layout.setMargin(true);
        setContent(layout);

        TabView tabView = TabView.getInstance();
        layout.addComponent(tabView.getTabSheet());
    }

    @WebServlet(urlPatterns = "/*", name = "HealthVisAppUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = HealthVisAppUI.class, productionMode = false)
    public static class HealthVisAppUIServlet extends VaadinServlet {
    }
}
