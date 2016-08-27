package theateam.com.tourmanager.Weather.Autocomplete;

public class SuggestGetSet {

	String city,countryCode;

	public SuggestGetSet(String city, String countryCode) {
		this.city = city;
		this.countryCode = countryCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
}
