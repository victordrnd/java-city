
public class City {

	private int City_Id;
	private String Name;
	private String CountryCode;
	private String District;
	private int Population;
	
	public City() {
		
	}
	
	public City(int id, String n, String ccode, String d, int pop) {
		City_Id = id;
		Name = n;
		CountryCode = ccode;
		District = d;
		Population = pop;
	}
	
	public int getCity_Id() {
		return City_Id;
	}
	public City setCity_Id(int city_Id) {
		City_Id = city_Id;
		return this;
	}
	
	public String getName() {
		return Name;
	}
	
	public City setName(String name) {
		Name = name;
		return this;
	}
	
	public String getCountryCode() {
		return CountryCode;
	}
	
	public City setCountryCode(String countryCode) {
		CountryCode = countryCode;
		return this;
	}
	
	public String getDistrict() {
		return District;
	}
	public City setDistrict(String district) {
		District = district;
		return this;
	}
	public int getPopulation() {
		return Population;
	}
	public City setPopulation(int population) {
		Population = population;
		return this;
	}

}
