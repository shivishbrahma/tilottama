/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilottama.util.weatherapp;

import java.util.ArrayList;

import tilottama.util.weatherapp.api.City;
import tilottama.util.weatherapp.api.DayReport;

/**
 * @author Purbayan Chowdhury
 *         (<a href="shivishbrahma.github.io">shivishbrahma.github.io</a>)
 *
 */
public class OpenWeatherForecast {
	public City city;
	private int cod, cnt;
	private ArrayList<DayReport> list;
	private double message;

	/**
	 * 
	 */
	public OpenWeatherForecast() {
	}

	/**
	 * @param city
	 * @param cod
	 * @param cnt
	 * @param list
	 * @param message
	 */
	public OpenWeatherForecast(City city, int cod, int cnt, ArrayList<DayReport> list, double message) {
		this.city = city;
		this.cod = cod;
		this.cnt = cnt;
		this.list = list;
		this.message = message;
	}

	/**
	 * @return the city
	 */
	public City getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(City city) {
		this.city = city;
	}

	/**
	 * @return the cod
	 */
	public int getCod() {
		return cod;
	}

	/**
	 * @param cod the cod to set
	 */
	public void setCod(int cod) {
		this.cod = cod;
	}

	/**
	 * @return the cnt
	 */
	public int getCnt() {
		return cnt;
	}

	/**
	 * @param cnt the cnt to set
	 */
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	/**
	 * @return the list
	 */
	public ArrayList<DayReport> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(ArrayList<DayReport> list) {
		this.list = list;
	}

	/**
	 * @return the message
	 */
	public double getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(double message) {
		this.message = message;
	}

	public void details() {
		System.out.println("\n\nWeather Forecast Report");
//		System.out.println("COD: " + this.cod);
		if (this.city != null)
			this.city.details();
		if (this.list != null) {
			for (DayReport d : list) {
				d.details();
			}
		}
//		System.out.println("Message: " + this.message);
	}
}
