/**
 * 
 */
package tilottama.game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * @author Purbayan Chowdhury<a href=
 *         "mailto:pur.cho.99@gmail.com">pur.cho.99@gmail.com</a>
 *
 */
public class MainGame {
	/**
	 * 
	 */
	public void rollDice() {
		Random dice = new Random(123);
		System.out.println("Roll Dice: " + (dice.nextInt(6) + 1));
	}
	
	/**
	 * 
	 */
	public void flipCoin() {
		Random coin = new Random(123);
		String s[]= {"Heads", "Tails"};
		System.out.println("Flip Coin: "+s[coin.nextInt(2)]);
	}
	
	public void pi(int digits) {
		try {
			BufferedReader br =new BufferedReader(new FileReader(new File("pi.txt")));
			String s=br.readLine();
			System.out.println(tilottama.par.StringHandler.wrapString(s.substring(0, digits+2), 64));			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
