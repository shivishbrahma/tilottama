/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shivishbrahma.tilottama.test.util.weatherapp.api;

import com.shivishbrahma.tilottama.main.par.DateTime;

/**
 *
 * @author Purbayan Chowdhury (<a>shivishbrahma.github.io</a>)
 */
public class Sys {
	private int type, id;
	private long sunrise, sunset;
	private String message, country, pod;

	/**
	 * @param type
	 * @param id
	 * @param sunrise
	 * @param sunset
	 * @param message
	 * @param country
	 * @param pod
	 */
	public Sys(int type, int id, long sunrise, long sunset, String message, String country, String pod) {
		this.type = type;
		this.id = id;
		this.sunrise = sunrise;
		this.sunset = sunset;
		this.setMessage(message);
		this.country = country;
		this.pod = pod;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the sunrise
	 */
	public long getSunrise() {
		return sunrise;
	}

	/**
	 * @param sunrise the sunrise to set
	 */
	public void setSunrise(long sunrise) {
		this.sunrise = sunrise;
	}

	/**
	 * @return the sunset
	 */
	public long getSunset() {
		return sunset;
	}

	/**
	 * @param sunset the sunset to set
	 */
	public void setSunset(long sunset) {
		this.sunset = sunset;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the pod
	 */
	public String getPod() {
		return pod;
	}

	/**
	 * @param pod the pod to set
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	public void details() {
		System.out.println("System: ");
//		if (this.type != 0)
//			System.out.println("Type: " + this.type);
//		if (this.id != 0)
//			System.out.println("Id: " + this.id);
//		if (this.message != null)
//			System.out.println("Message: " + this.message);
		if (this.pod != null)
			System.out.println("POD: " + this.pod);
		if (this.country != null)
			System.out.println("Country: " + this.country);
		if (this.sunrise != 0)
			System.out.println("Sunrise: " + DateTime.unixToZFormat((long) this.sunrise));
		if (this.sunset != 0)
			System.out.println("Sunset: " + DateTime.unixToZFormat((long) this.sunset));
	}
}
