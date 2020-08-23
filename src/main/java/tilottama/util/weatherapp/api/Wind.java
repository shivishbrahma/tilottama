package tilottama.util.weatherapp.api;

/**
 *
 * @author Purbayan Chowdhury (<a>shivishbrahma.github.io</a>)
 */
public class Wind {
	private float speed, deg;
	public static String wUnit[] = { "m/s(meter/sec)", "m/s(meter/sec)", "mi/hr(miles/hour)" };
	public int unit;

	public Wind(float speed, float deg) {
		this.speed = speed;
		this.deg = deg;
		this.unit = 0;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getDeg() {
		return deg;
	}

	public void setDeg(float deg) {
		this.deg = deg;
	}

	public void details() {
		System.out.println("Wind: ");
		System.out.println("Speed: " + this.getSpeed() + " " + wUnit[this.unit]);
		System.out.println("Degree: " + this.getDeg() + " degrees");
	}
}