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
public class Snow {
	private float _1h, _3h;

	public Snow(float _1h, float _3h) {
		this._1h = _1h;
		this._3h = _3h;
	}

	public float get1h() {
		return _1h;
	}

	public void set1h(float _1h) {
		this._1h = _1h;
	}

	public float get3h() {
		return _3h;
	}

	public void set3h(float _3h) {
		this._3h = _3h;
	}

}
