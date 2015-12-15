package ch.bfh.btx8081.w2015.blue.HealthVisApp.Util;

import ch.bfh.btx8081.w2015.blue.HealthVisApp.Model.Patient;

import com.vaadin.data.Item;
import com.vaadin.ui.Grid.RowReference;
import com.vaadin.ui.Grid.RowStyleGenerator;
import com.vaadin.ui.Table;

public class PatientListCellStyleGenerator implements Table.CellStyleGenerator {
	
	@Override
	public String getStyle(Table source, Object itemId, Object propertyId) {
		if (propertyId == null) {
			Item item = source.getItem(itemId);
			String s = ((Patient) item.getItemProperty("Patient Name")
						.getValue())
						.getPatientState()
						.doEnter();
			return s;
		} else {
			return null;
		}
	}
}
 