import java.sql.SQLException;
import java.util.List;

public interface DAOCityInterface {

	public City find(int id) throws SQLException;
	
	public void remove(City city) throws SQLException;
	
	public void save(City city) throws SQLException; 
	
	public void update(City city) throws SQLException;
	
	public List<City> findAll() throws SQLException;
	
	public int count() throws SQLException;
	
	public List<City> findFromCountry(String code) throws SQLException;
}
