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
public class Cloud {
	private int all;

	public Cloud(int all) {
		this.all = all;
	}

	public void setAll(int all) {
		this.all = all;
	}

	public int getAll() {
		return all;
	}

	public void details() {
		System.out.println("Clouds: ");
		System.out.println("All: " + this.getAll() + "%");
	}

}
