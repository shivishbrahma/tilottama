package tilottama.util.weatherapp.api;

/**
 *
 * @author Purbayan Chowdhury (<a>shivishbrahma.github.io</a>)
 */
public class Weather {
	private int id;
	private String main, description, icon;

	public Weather(int id, String main, String description, String icon) {
		this.id = id;
		this.main = main;
		this.description = description;
		this.icon = icon;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public String getDecription() {
		return description;
	}

	public void setDecription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public void details() {
		System.out.println("Weather: ");
		System.out.println("Id: " + this.getId());
		System.out.println("Main: " + this.getMain());
		System.out.println("Description: " + this.getDecription());
		System.out.println("Icon: " + this.getIcon());
	}
}
