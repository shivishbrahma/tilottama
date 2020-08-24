package tilottama.util.weatherapp;

import java.util.ArrayList;

import tilottama.par.DateTime;
import tilottama.util.weatherapp.api.Cloud;
import tilottama.util.weatherapp.api.Coordinate;
import tilottama.util.weatherapp.api.Main;
import tilottama.util.weatherapp.api.Rain;
import tilottama.util.weatherapp.api.Snow;
import tilottama.util.weatherapp.api.Sys;
import tilottama.util.weatherapp.api.Weather;
import tilottama.util.weatherapp.api.Wind;

/**
 * @author Purbayan Chowdhury
 *         (<a href="shivishbrahma.github.io">shivishbrahma.github.io</a>)
 *
 */
public class OpenWeather {
	public Main main;
	public Sys sys;
	public Coordinate coord;
	public ArrayList<Weather> weather;
	public Wind wind;
	public Cloud cloud;
	public Snow snow;
	public Rain rain;
	private String base, name;
	private int visibility, id, cod, dt, timezone;

	public OpenWeather() {
	}

	/**
	 * @param main
	 * @param sys
	 * @param base
	 * @param name
	 * @param visibility
	 * @param id
	 * @param cod
	 * @param dt
	 * @param timezone
	 * @param coord
	 * @param weather
	 * @param wind
	 * @param cloud
	 * @param snow
	 * @param rain
	 */
	public OpenWeather(Main main, Sys sys, String base, String name, int visibility, int id, int cod, int dt,
			int timezone, Coordinate coord, ArrayList<Weather> weather, Wind wind, Cloud cloud, Snow snow, Rain rain) {
		this.main = main;
		this.sys = sys;
		this.base = base;
		this.name = name;
		this.visibility = visibility;
		this.id = id;
		this.cod = cod;
		this.dt = dt;
		this.timezone = timezone;
		this.coord = coord;
		this.weather = weather;
		this.wind = wind;
		this.cloud = cloud;
		this.snow = snow;
		this.rain = rain;
	}

	/**
	 * @return the main
	 */
	public Main getMain() {
		return main;
	}

	/**
	 * @param main the main to set
	 */
	public void setMain(Main main) {
		this.main = main;
	}

	/**
	 * @return the sys
	 */
	public Sys getSys() {
		return sys;
	}

	/**
	 * @param sys the sys to set
	 */
	public void setSys(Sys sys) {
		this.sys = sys;
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
	 * @return the weather
	 */
	public ArrayList<Weather> getWeather() {
		return weather;
	}

	/**
	 * @param weather the weather to set
	 */
	public void setWeather(ArrayList<Weather> weather) {
		this.weather = weather;
	}

	/**
	 * @return the wind
	 */
	public Wind getWind() {
		return wind;
	}

	/**
	 * @param wind the wind to set
	 */
	public void setWind(Wind wind) {
		this.wind = wind;
	}

	/**
	 * @return the cloud
	 */
	public Cloud getCloud() {
		return cloud;
	}

	/**
	 * @param cloud the cloud to set
	 */
	public void setCloud(Cloud cloud) {
		this.cloud = cloud;
	}

	/**
	 * @return the snow
	 */
	public Snow getSnow() {
		return snow;
	}

	/**
	 * @param snow the snow to set
	 */
	public void setSnow(Snow snow) {
		this.snow = snow;
	}

	/**
	 * @return the rain
	 */
	public Rain getRain() {
		return rain;
	}

	/**
	 * @param rain the rain to set
	 */
	public void setRain(Rain rain) {
		this.rain = rain;
	}

	/**
	 * @return the base
	 */
	public String getBase() {
		return base;
	}

	/**
	 * @param base the base to set
	 */
	public void setBase(String base) {
		this.base = base;
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
	 * @return the visibility
	 */
	public int getVisibility() {
		return visibility;
	}

	/**
	 * @param visibility the visibility to set
	 */
	public void setVisibility(int visibility) {
		this.visibility = visibility;
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
	 * @return the dt
	 */
	public int getDt() {
		return dt;
	}

	/**
	 * @param dt the dt to set
	 */
	public void setDt(int dt) {
		this.dt = dt;
	}

	/**
	 * @return the timezone
	 */
	public int getTimezone() {
		return timezone;
	}

	/**
	 * @param timezone the timezone to set
	 */
	public void setTimezone(int timezone) {
		this.timezone = timezone;
	}

	/**
	 * 
	 */
	public void details() {
		System.out.println("\n\nWeather Report");
		DateTime dTime = new DateTime();
		if (coord != null)
			coord.details();
		if (main != null)
			main.details();
		for (Weather i : weather)
			i.details();
		if (wind != null)
			wind.details();
		if (cloud != null)
			cloud.details();
		if (rain != null)
			rain.details();
		if (snow != null)
			snow.details();

		sys.details();
//        System.out.println("Base: "+this.getBase());
		System.out.println("Name: " + this.getName());
//        System.out.println("Id: "+this.getId());
		System.out.println("Time: " + dTime.unixToZFormat((long) dt));
		System.out.print("Timezone: ");
		if (timezone > 0)
			System.out.print("+");
		else
			System.out.print("-");
		System.out.println(dTime.unixtoUTC((long) Math.abs(timezone), "HH:mm"));
//        System.out.println("Code: "+this.getCod());
	}
}
