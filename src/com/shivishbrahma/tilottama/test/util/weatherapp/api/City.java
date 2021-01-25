/**
 * 
 */
package com.shivishbrahma.tilottama.test.util.weatherapp.api;

/**
 * @author Purbayan Chowdhury
 *         (<a href="shivishbrahma.github.io">shivishbrahma.github.io</a>)
 *
 */
public class City {
	public Coordinate coord;
	public String country, name;
	private int id;

	public City() {
	}

	/**
	 * @param coord
	 * @param country
	 * @param name
	 * @param id
	 */
	public City(Coordinate coord, String country, String name, int id) {
		this.coord = coord;
		this.country = country;
		this.name = name;
		this.id = id;
	}

	/**
	 * @return the coord
	 */
	public Coordinate getCoord() {
		return coord;
	}

	/**
	 * @param coord the coord to set
	 */
	public void setCoord(Coordinate coord) {
		this.coord = coord;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * 
	 */
	public void details() {
		System.out.println("City: ");
//		System.out.println("Id: " + this.id);
		System.out.println("Name: " + this.name);
		coord.details();
		System.out.println("Country: " + this.country);
	}

}
