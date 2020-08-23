/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilottama.util.weatherapp.api;

import tilottama.par.DateTime;

/**
 *
 * @author Purbayan Chowdhury (<a>shivishbrahma.github.io</a>)
 */
public class Sys {
	private int type, id;
	private long sunrise, sunset;
	private String message;
	private String country;

	public Sys(int type, int id, String message, String country, long sunrise, long sunset) {
		this.type = type;
		this.id = id;
		this.sunrise = sunrise;
		this.sunset = sunset;
		this.message = message;
		this.country = country;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getSunrise() {
		return sunrise;
	}

	public void setSunrise(long sunrise) {
		this.sunrise = sunrise;
	}

	public long getSunset() {
		return sunset;
	}

	public void setSunset(long sunset) {
		this.sunset = sunset;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void details() {
		DateTime dt = new DateTime();
		System.out.println("System: ");
//        System.out.println("Type: "+this.getType());
//        System.out.println("Id: "+this.getId());  
//        System.out.println("Message: "+this.getMessage());
		System.out.println("Country: " + this.getCountry());
		System.out.println("Sunrise: " + dt.unixToZFormat((long) this.getSunrise()));
		System.out.println("Sunset: " + dt.unixToZFormat((long) this.getSunset()));
	}
}
