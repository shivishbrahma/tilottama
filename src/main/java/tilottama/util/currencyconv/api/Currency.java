package tilottama.util.currencyconv.api;

public class Currency {
	private String currencyCode, name, symbol, countryCode, countryName;

	public Currency(String currencyCode, String name, String symbol, String countryCode, String countryName) {
		super();
		this.currencyCode = currencyCode;
		this.name = name;
		this.symbol = symbol;
		this.countryCode = countryCode;
		this.countryName = countryName;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	public String toString() {
		return String.format("%s(%s)", name, currencyCode);
	}

	public void details() {
		System.out.println("Currency Code: " + currencyCode);
		System.out.println("Currency Name: " + name);
		System.out.println("Currency Symbol: " + symbol);
		System.out.println("Country Code: " + countryCode);
		System.out.println("Country Name: " + countryName);
	}
}
