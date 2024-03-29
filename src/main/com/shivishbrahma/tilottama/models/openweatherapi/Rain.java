package com.shivishbrahma.tilottama.models.openweatherapi;

/**
 *
 * @author Purbayan Chowdhury (<a>shivishbrahma.github.io</a>)
 */
public class Rain {
	private float _1h, _3h;

	/**
	 * @param _1h
	 * @param _3h
	 */
	public Rain(float _1h, float _3h) {
		this._1h = _1h;
		this._3h = _3h;
	}

	/**
	 * @return the _1h
	 */
	public float get_1h() {
		return _1h;
	}

	/**
	 * @param _1h the _1h to set
	 */
	public void set_1h(float _1h) {
		this._1h = _1h;
	}

	/**
	 * @return the _3h
	 */
	public float get_3h() {
		return _3h;
	}

	/**
	 * @param _3h the _3h to set
	 */
	public void set_3h(float _3h) {
		this._3h = _3h;
	}

	/**
	 * 
	 */
	public void details() {
		System.out.println("Rain: ");
		if (this._1h != 0.0)
			System.out.println("1h: " + this._1h + " mm");
		if (this._3h != 0.0)
			System.out.println("3h: " + this._3h + " mm");
	}
}
