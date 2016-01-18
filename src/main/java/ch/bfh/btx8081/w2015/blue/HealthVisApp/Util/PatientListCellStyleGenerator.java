package ch.bfh.btx8081.w2015.blue.HealthVisApp.Util;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Patient;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State.PatientState;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State.PatientStateAmbulant;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State.PatientStateArchived;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State.PatientStateNew;
import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.State.PatientStateStationary;

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
			PatientState state = ((Patient) item.getItemProperty("Patient Name")
					.getValue())
					.getPatientState();
			
			String s = "";
			if (state instanceof PatientStateNew) {
				PatientStateNew n = (PatientStateNew) state;
				s = n.getColorCode();
			}
			if (state instanceof PatientStateAmbulant) {
				PatientStateAmbulant n = (PatientStateAmbulant) state;
				s = n.getColorCode();
			}
			if (state instanceof PatientStateStationary) {
				PatientStateStationary n = (PatientStateStationary) state;
				s = n.getColorCode();
			}
			if (state instanceof PatientStateArchived) {
				PatientStateArchived n = (PatientStateArchived) state;
				s = n.getColorCode();
			}
			
			return s;
		} else {
			return null;
		}
	}
}
 