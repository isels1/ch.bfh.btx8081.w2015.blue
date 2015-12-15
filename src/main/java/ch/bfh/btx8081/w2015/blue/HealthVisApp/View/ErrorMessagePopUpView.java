package ch.bfh.btx8081.w2015.blue.HealthVisApp.View;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.HealthVisAppUI;

import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * shows a pop-up from an error while running
 * 
 * <ul>
 * 	if an error occurs while user input
 * </ul>
 * <ul>
 * create a new message pop up with given message
 * 	<li>
 * 		<b>
 * 		message	
 * 		</b>
 * 		: shown message in the pop-up view
 * 	</li>
 * @author zwahf1
 *
 */
public class ErrorMessagePopUpView {

	//================================================================================
    // ErrorMessagePopUpView  Data
    //================================================================================
	final static String HEIGHT = "150";					// 568 is fullsize
	final static String WIDTH = "300";					//320 is fullsize
	
	VerticalLayout layout = null;
	
//	TextArea message;
	Label message;
	
	Window window;
	
	//================================================================================
    // Constructor Section
    //================================================================================
	
	/**
	 * This constructor initialize the pop-up view for a new error message
	 */
	public ErrorMessagePopUpView(String message) {
//		this.message = new TextArea();
		this.message = new Label();
		this.message.setValue(message);
		
		this.createWindow();
		
		layout = new VerticalLayout();
		layout.addComponent(this.message);
		
	    window.setContent(layout);
	    
	    HealthVisAppUI.getCurrent().addWindow(window);
	}
	
	//================================================================================
    // Getter  Section
    //================================================================================
	
	/**
	 * get layout from pop-up view
	 * @return layout: VerticalLayout
	 */
	public VerticalLayout getPopUpLayout() {
		return layout;
	}
	
	/**
	 * get message value from pop-up view
	 * @return message: String
	 */
	public String getTextFieldLocation() {
		return message.getValue();
	}
	
	//================================================================================
    // Other  Section
    //================================================================================
	
	/**
	 * close the pop-up view (current window)
	 */
	public void close() {
		HealthVisAppUI.getCurrent().removeWindow(window);
	}
	
	//================================================================================
    // private methods  Section
    //================================================================================
	
	/**
	 * create window for pop-up layout
	 */
	private void createWindow() {
		window = new Window("Error message");
//		window.setModal(true);
		window.setWidth(WIDTH);
		window.setHeight(HEIGHT);
//		window.center();
	}
}
