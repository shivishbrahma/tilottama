/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilottama.util.weatherapp.api;

/**
 *
 * @author Purbayan Chowdhury (<a>shivishbrahma.github.io</a>)
 */
public class Main {
	private float temp, feels_like, temp_min, temp_max, pressure, humidity, sea_level, grnd_level;
	public static String tUnit[] = { "K(Kelvin)", "°C(Celsius)", "°F(Fahrenheit)" };
	public int unit;

	public Main(float temp, float feels_like, float temp_min, float temp_max, float pressure, float humidity,
			float sea_level, float grnd_level) {
		this.temp = temp;
		this.feels_like = feels_like;
		this.temp_min = temp_min;
		this.temp_max = temp_max;
		this.pressure = pressure;
		this.humidity = humidity;
		this.sea_level = sea_level;
		this.grnd_level = grnd_level;
		this.unit = 0;
	}

	public float getTemp_min() {
		return temp_min;
	}

	public void setTemp_min(float temp_min) {
		this.temp_min = temp_min;
	}

	public float getTemp_max() {
		return temp_max;
	}

	public void setTemp_max(float temp_max) {
		this.temp_max = temp_max;
	}

	public float getSea_level() {
		return sea_level;
	}

	public void setSea_level(float sea_level) {
		this.sea_level = sea_level;
	}

	public float getGrnd_level() {
		return grnd_level;
	}

	public void setGrnd_level(float grnd_level) {
		this.grnd_level = grnd_level;
	}

	public float getTemp() {
		return temp;
	}

	public void setTemp(float temp) {
		this.temp = temp;
	}

	public float getFeels_like() {
		return feels_like;
	}

	public void setFeels_like(float feels_like) {
		this.feels_like = feels_like;
	}

	public float getPressure() {
		return pressure;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public void details() {
		System.out.println("Main: ");
		System.out.println("Temperature: " + this.getTemp() + " " + tUnit[this.unit]);
		System.out.println("Feels like: " + this.getFeels_like() + " " + tUnit[this.unit]);
		System.out.println("Max. Temperature: " + this.getTemp_max() + " " + tUnit[this.unit]);
		System.out.println("Min. Temperature: " + this.getTemp_min() + " " + tUnit[this.unit]);
		System.out.println("Pressure: " + this.getPressure() + " hPa");
		System.out.println("Humidity: " + this.getHumidity() + "%");
		if (this.getSea_level() != 0)
			System.out.println("Sea Level: " + this.getSea_level() + " hPa");
		if (this.getGrnd_level() != 0)
			System.out.println("Ground Level: " + this.getGrnd_level() + " hPa");
	}
}
