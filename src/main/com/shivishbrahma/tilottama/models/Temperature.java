package com.shivishbrahma.tilottama.models;

import java.util.Scanner;

import com.shivishbrahma.tilottama.handlers.StringHandler;

/**
 * @author Purbayan Chowdhury<a href=
 *         "mailto:pur.cho.99@gmail.com">pur.cho.99@gmail.com</a>
 *
 */
public class Temperature {
	private double temp, temp_C, temp_F;

	public Temperature(double temp) {
		this(temp, 'K');
	}

	public Temperature(double temp, char c) {
		switch (c) {
		case 'c':
		case 'C':
			this.temp_C = temp;
			this.temp = convC2K(temp);
			this.temp_F = convC2F(temp);
			break;
		case 'F':
		case 'f':
			this.temp_F = temp;
			this.temp = convF2K(temp);
			this.temp_C = convF2C(temp);
			break;
		default:
			this.temp = temp;
			this.temp_C = convK2C(this.temp);
			this.temp_F = convK2F(this.temp);
			break;
		}
	}

	/**
	 * @return the temp
	 */
	public double getTemp() {
		return temp;
	}

	/**
	 * @param temp the temp to set
	 */
	public void setTemp(double temp) {
		this.temp = temp;
	}

	/**
	 * @return the temp_C
	 */
	public double getTemp_C() {
		return temp_C;
	}

	/**
	 * @param temp_C the temp_C to set
	 */
	public void setTemp_C(double temp_C) {
		this.temp_C = temp_C;
	}

	/**
	 * @return the temp_F
	 */
	public double getTemp_F() {
		return temp_F;
	}

	/**
	 * @param temp_F the temp_F to set
	 */
	public void setTemp_F(double temp_F) {
		this.temp_F = temp_F;
	}

	/**
	 * @param temp - Temperature in Celsius
	 * @return Temperature in Kelvin
	 */
	public double convC2K(double temp) {
		return temp + 273.15;
	}

	/**
	 * @param temp - Temperature in Kelvin
	 * @return Temperature in Celsius
	 */
	public double convK2C(double temp) {
		return temp - 273.15;
	}

	/**
	 * @param temp
	 * @return
	 */
	public double convC2F(double temp) {
		return temp * 9 / 5 + 32;
	}

	/**
	 * @param temp
	 * @return
	 */
	public double convF2C(double temp) {
		return (temp - 32) * 9 / 5;
	}

	/**
	 * @param temp
	 * @return
	 */
	public double convK2F(double temp) {
		return convC2F(convK2C(temp));
	}

	/**
	 * @param temp
	 * @return
	 */
	public double convF2K(double temp) {
		return convC2K(convF2C(temp));
	}
	
	public static double temperatureConv(char fromTem, char toTem, double val) {
		Temperature temp = new Temperature(val, fromTem);
		switch (toTem) {
		case 'c':
		case 'C':
			return temp.getTemp_C();
		case 'f':
		case 'F':
			return temp.getTemp_F();
		default:
			return temp.getTemp();
		}
	}
	
	public static String temperatureFormat(char fromTem, double val) {
		String source;
		switch (fromTem) {
		case 'c':
		case 'C':
			source = String.format("%f ℃", val);
			break;
		case 'f':
		case 'F':
			source = String.format("%f ℉", val);
			break;
		default:
			source = String.format("%f K", val);
			break;
		}
		return source;
	}

	public static void temperatureConv(String cmd) {
		String dest = "", source = "";
		Scanner sc = new Scanner(cmd);
		double val = sc.nextDouble();
		char fromTem = sc.next().charAt(0);
		char toTem = sc.next().charAt(0);
		Temperature temp = new Temperature(val, fromTem);
		switch (toTem) {
		case 'c':
		case 'C':
			dest = String.format("%f ℃", temp.getTemp_C());
			break;
		case 'f':
		case 'F':
			dest = String.format("%f ℉", temp.getTemp_F());
			break;
		default:
			dest = String.format("%f K", temp.getTemp());
			break;
		}
		switch (fromTem) {
		case 'c':
		case 'C':
			source = String.format("%f ℃", temp.getTemp_C());
			break;
		case 'f':
		case 'F':
			source = String.format("%f ℉", temp.getTemp_F());
			break;
		default:
			source = String.format("%f K", temp.getTemp());
			break;
		}
		sc.close();
		System.out.println(StringHandler.centerAligned("TEMPERATURE CONVERTOR", 64, "="));
		System.out.println("Given Temperature: " + source);
		System.out.println("Converted Temperature: " + dest);
	}
}
