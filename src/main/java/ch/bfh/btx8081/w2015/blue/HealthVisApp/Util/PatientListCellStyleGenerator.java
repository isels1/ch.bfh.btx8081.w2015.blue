package ch.bfh.btx8081.w2015.blue.HealthVisApp.Util;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Patient;

import com.vaadin.data.Item;
import com.vaadin.ui.Table;

/**
 * Abstract Class
 * <span class="courier">
 * <font face="courier new">
 * 		PatientListCellStyleGenerator
 * </font>
 * </span>
 * <span class="courier">
 * <font face="courier new">
 * 		<b>implements</b> Table.CellStyleGenerator
 * </font>
 * </span>
 * <br>
 * <span style="margin-left:60px;">
 * 		... styles the patients acording to their state
 * </span>
 * <br>
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
public class PatientListCellStyleGenerator implements Table.CellStyleGenerator {
	
	@Override
	public String getStyle(Table source, Object itemId, Object propertyId) {
		if (propertyId == null) {
			Item item = source.getItem(itemId);
			String s = ((Patient) item.getItemProperty("Patient Name")
						.getValue())
						.getPatientState()
						.getColorCode();
			return s;
		} else {
			return null;
		}
	}
}
 