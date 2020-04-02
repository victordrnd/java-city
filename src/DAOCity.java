import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOCity implements DAOCityInterface {

	private Connection cnx;
	public DAOCity(Connection cnx) {
		this.cnx = cnx;
	}
	
	
	public City find(int id) throws SQLException {
		PreparedStatement st = cnx.prepareStatement("SELECT * FROM city WHERE City_Id=?");
		st.setInt(1,id);
		ResultSet res = st.executeQuery();
		res.next();
		City city = hydrate(res);
		return city;
		
	}
	
	public void remove(City city) throws SQLException {
		PreparedStatement st = cnx.prepareStatement("DELETE FROM city WHERE City_Id=?");
		st.setInt(1,city.getCity_Id());
		st.executeQuery();
	}
	
	public void save(City city) throws SQLException {
		PreparedStatement st = cnx.prepareStatement("INSERT INTO city VALUES (?,?,?,?)");
		st.setString(1,city.getName());
		st.setString(2,city.getCountryCode());
		st.setString(3,city.getDistrict());
		st.setInt(4,city.getPopulation());
		st.executeQuery();
	}
	
	public void update(City city) throws SQLException {
		PreparedStatement st = cnx.prepareStatement("UPDATE city SET Name = ?, CountryCode = ?, District = ?, Population = ? WHERE City_Id = ?");
		st.setString(1,city.getName());
		st.setString(2,city.getCountryCode());
		st.setString(3,city.getDistrict());
		st.setInt(4,city.getPopulation());
		st.setInt(5, city.getCity_Id());
		st.executeQuery();
	}
	
	public List<City> findAll() throws SQLException{
		List<City> cities = new ArrayList<>();
		PreparedStatement st = cnx.prepareStatement("SELECT * FROM city");
		ResultSet res = st.executeQuery();
		while(res.next()) {
			cities.add(hydrate(res));
		}
		return cities;
	}
	
	public int count() throws SQLException {
		PreparedStatement st = cnx.prepareStatement("SELECT COUNT(*) as cpt FROM city");
		ResultSet res = st.executeQuery();
		res.next();
		int counter = res.getInt("cpt");
		return counter;
	}
	
	public List<City> findFromCountry(String ccode) throws SQLException{
		List<City> cities = new ArrayList<>();
		PreparedStatement st = cnx.prepareStatement("SELECT city.* FROM city, country WHERE country.Name=? AND Code =CountryCode");
		st.setString(1, ccode);
		ResultSet res = st.executeQuery();
		while(res.next()) {
			cities.add(hydrate(res));
		}
		return cities;
	}
	
	public City hydrate(ResultSet rs) throws SQLException {
		City city = new City(rs.getInt("City_Id"), rs.getString("Name"), rs.getString("CountryCode"), rs.getString("District"), rs.getInt("Population"));
		return city;
	}


}
