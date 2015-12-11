package ch.bfh.btx8081.w2015.blue.HealthVisApp.Util;

import com.vaadin.data.Item;
import com.vaadin.ui.Table;

public class PatientListCellStyleGenerator implements Table.CellStyleGenerator {
	
	@Override
	public String getStyle(Table source, Object itemId, Object propertyId) {
		if (propertyId == null) {
			Item item = source.getItem(itemId);
			String s = (String) item.getItemProperty("State").getValue();
			return s;
		} else {
			return null;
		}
		
	}

	
}
