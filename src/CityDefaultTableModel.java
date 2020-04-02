import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class CityDefaultTableModel extends DefaultTableModel {

	private String[] columnNames = { "Id", "Nom", "Code", "Région", "Population" };
	private List<City> cities;
	private List<City> editedCities = new ArrayList<>();

	public CityDefaultTableModel(List<City> cities) {
		// TODO Auto-generated constructor stub
		this.cities = cities;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columnNames[column];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub

		return cities == null ? 0 : cities.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		switch (column) {
		case 0: {
			return (Object) cities.get(row).getCity_Id();
		}
		case 1: {
			return (Object) cities.get(row).getName();
		}
		case 2: {
			return (Object) cities.get(row).getCountryCode();
		}
		case 3: {
			return (Object) cities.get(row).getDistrict();
		}
		case 4: {
			return (Object) cities.get(row).getPopulation();
		}
		}
		return null;
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void setValueAt(Object field, int row, int column) {
		// TODO Auto-generated method stub
		City city = cities.get(row);
		City newcity = city;
		switch (column) {
		case 0: {
			newcity.setCity_Id((Integer) field);
			break;
		}
		case 1: {
			newcity.setName((String) field);
			break;
		}
		case 2: {
			newcity.setCountryCode((String) field);
			break;
		}
		case 3: {
			newcity.setDistrict((String) field);
			break;
		}
		case 4: {
			newcity.setPopulation((Integer) field);
			break;
		}
		}

		if (editedCities.contains(city)) {
			editedCities.remove(city);
			editedCities.add(newcity);
		} else {
			editedCities.add(newcity);
		}
		// super.setValueAt(aValue, row, column);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex) {
		case 0: {
			return Integer.class;
		}
		case 1: {
			return String.class;
		}
		case 2: {
			return String.class;
		}
		case 3: {
			return String.class;
		}
		case 4: {
			return Integer.class;
		}
		}
		return String.class;
	}

	public void updateCities(List<City> cities) {
		this.cities = cities;
		this.fireTableDataChanged();
	}

	public List<City> getEditedCities() {
		return this.editedCities;
	}

	public void removeEditedCities() {
		this.editedCities.removeAll(editedCities);
	}

	public City getCityAt(int index) {
		return this.cities.get(index);
	}

}
