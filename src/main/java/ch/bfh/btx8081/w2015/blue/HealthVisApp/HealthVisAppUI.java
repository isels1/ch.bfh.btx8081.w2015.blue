package ch.bfh.btx8081.w2015.blue.HealthVisApp;

import java.util.List;
import java.util.Vector;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.servlet.annotation.WebServlet;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.View.MainView;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.HealthVisitor;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Persistence.Connector;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Persistence.DataProvider;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * Class
 * <span class="courier">
 * <font face="courier new">
 * 		HealthVisAppUI
 * </font>
 * </span>
 * <span class="courier">
 * <font face="courier new">
 * 		<b>extends</b> UI
 * </font>
 * </span>
 * <br>
 * <span style="margin-left:60px;">
 * 		...main class of the health vis app project.
 * </span>
 * <br>
 * <br>
 * The HealthVisApp contains following information:
 * 	<ul>
 * 		<li>
 * 			<font face="courier new">
 * 				final WITDH:
 * 			</font> 
 * 			<i>String</i>
 * 			- The width of the gui
 * 		</li>
 * 		<li>
 * 			<font face="courier new">
 * 				final HEIGHT:
 * 			</font> 
 * 			<i>String</i>
 * 			- The height of the gui
 * 		</li>
 *	 </ul>
 * <br>
 * <b>
 * 		Creation date:
 * </b>
 * <br>
 * <span style="margin-left:60px;">
 * 		xx.xx.2015
 * </span>
 * <br><br>
 * @author zwahf1, dornt1, isels1
 * @version 1.0
 */
@SuppressWarnings("serial")
@Theme("HealthVisAppTheme")
@Widgetset("ch.bfh.btx8081.w2015.blue.HealthVisApp.HealthVisAppWidgetset")
public class HealthVisAppUI extends UI {

	//================================================================================
    // HealthVisAppUI Data
    //================================================================================
	final String HEIGHT = "568";
	final String WIDTH = "320";
	Connector c = null;
	
	//================================================================================
    // Initialisation Section
    //================================================================================
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {        
    	final VerticalLayout layout = new VerticalLayout();
        layout.setHeight(HEIGHT);
        layout.setWidth(WIDTH);
        layout.setMargin(false);
        layout.setSpacing(false);
        setContent(layout);
        
        //For testing LoginView
        MainView mainView = MainView.getInstance();
        layout.addComponent(mainView.getHorizontalLayout());
    }

    @WebServlet(urlPatterns = "/*", name = "HealthVisAppUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = HealthVisAppUI.class, productionMode = false)
    public static class HealthVisAppUIServlet extends VaadinServlet {
    }

}
