/**
 * 
 */
package com.shivishbrahma.tilottama.main.game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;

/**
 * @author Purbayan Chowdhury<a href=
 *         "mailto:pur.cho.99@gmail.com">pur.cho.99@gmail.com</a>
 *
 */
public class MainGame {
	/**
	 * Rolls dice
	 */
	public void rollDice() {
		System.out.println("Roll Dice: " + rollDice(123));
	}

	/**
	 * Rolls dice with seed
	 */
	public int rollDice(int seed) {
		Random dice = new Random(seed);
		return (dice.nextInt(6) + 1);
	}

	/**
	 * Flips coin
	 */
	public void flipCoin() {
		System.out.println("Flip Coin: " + flipCoin(123));
	}

	/**
	 * Flips coin
	 */
	public String flipCoin(int seed) {
		Random coin = new Random(123);
		String s[] = { "Heads", "Tails" };
		return s[coin.nextInt(2)];
	}

	/**
	 * Print no of digits after decimal
	 * 
	 * @param digits - No of digits after decimal
	 */
	public void pi(int digits) {
		System.out.println(com.shivishbrahma.tilottama.main.par.StringHandler.wrapString(getPIDigits(digits), 64));
	}

	@SuppressWarnings("resource")
	public String getPIDigits(int digits) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("pi.txt")));
			String s = br.readLine();
			return s.substring(0, digits + 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
