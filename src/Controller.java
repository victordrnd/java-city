import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Controller implements ActionListener{
	
	private Fenetre fenetre;
	private JTable table;
	private CityDefaultTableModel tableModel;
	private DAOCityInterface DaoCity;
	List<City> cities;
	
	public Controller(Fenetre f, DAOCity daoCity) {
		fenetre = f;
		DaoCity = daoCity;
		
		try {
			cities = DaoCity.findAll();
		} catch (SQLException e) {
			// TODO Display alert modal
			e.printStackTrace();
		}
				
		table = f.getTableCity();
		tableModel = new CityDefaultTableModel(cities);
		table.setModel(tableModel);
		
		
		
		f.setVisible(true);
		
		f.getBtnSearch().addActionListener(this);
		f.getBtnUpdate().addActionListener(this);
		f.getBtnDelete().addActionListener(this);
		f.getBtnDetails().addActionListener(this);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			JButton btn = (JButton) e.getSource();
			switch(btn.getName()) {
			case "search" : {
				String ccode = fenetre.getTXTCountry().getText();
			
				cities = DaoCity.findFromCountry(ccode);
				tableModel.updateCities(cities);
				break;
			}
			case "update":{
				List<City> editedCities = tableModel.getEditedCities();
				for(City city : editedCities) {
				 DaoCity.update(city);
				}
				tableModel.removeEditedCities();
				break;
			}
			case "delete":{
				int row = table.getSelectedRow();
				if(row == -1) {
					JOptionPane.showMessageDialog(fenetre, "Merci de sélectionner une ligne");
					break;
				}
				System.out.println(row);
				City city = tableModel.getCityAt(row);
				tableModel.setRowCount(tableModel.getRowCount()-1);
				cities.remove(row);
				tableModel.fireTableDataChanged();
				DaoCity.remove(city);
				break;
			}
			case "details":{
				int row = table.getSelectedRow();
				City city = tableModel.getCityAt(row);
				DetailsFenetre details = new DetailsFenetre();
				details.getTXBCountry().setText(city.getCountryCode());
				details.getTXBPopulation().setText(String.valueOf(city.getPopulation()));
				details.getTXBRegion().setText(city.getDistrict());
				details.setVisible(true);
				break;
			}
		}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}	
		
	}
	
	
}
