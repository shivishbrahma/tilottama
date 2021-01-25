/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shivishbrahma.tilottama.test.util.weatherapp.api;

/**
 *
 * @author Purbayan Chowdhury (<a>shivishbrahma.github.io</a>)
 */
public class Coordinate {
	private float lon, lat;

	public Coordinate(float lon, float lat) {
		this.lon = lon;
		this.lat = lat;
	}

	public float getLon() {
		return lon;
	}

	public void setLon(float lon) {
		this.lon = lon;
	}

	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	public String longConvert(float lon) {
		String sLon = "%d°%d′%d″ %c";
		int d = (int) Math.abs(lon);
		float t1 = (Math.abs(lon) - d) * 60;
		int m = (int) t1;
		int s = (int) ((t1 - m) * 60);
		char dr = ' ';
		if (lon > 0)
			dr = 'E';
		else
			dr = 'W';
		sLon = String.format(sLon, d, m, s, dr);
		return sLon;
	}

	public String latConvert(float lat) {
		String sLon = "%d°%d′%d″ %c";
		int d = (int) Math.abs(lat);
		float t1 = (Math.abs(lat) - d) * 60;
		int m = (int) t1;
		int s = (int) ((t1 - m) * 60);
		char dr = ' ';
		if (lat > 0)
			dr = 'N';
		else
			dr = 'S';
		sLon = String.format(sLon, d, m, s, dr);
		return sLon;
	}

	public void details() {
		System.out.println("Coordinates: ");
		System.out.println("Longitude: " + longConvert(this.getLon()));
		System.out.println("Latitude: " + latConvert(this.getLat()));
	}
}