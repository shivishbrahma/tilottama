/**
 * 
 */
package com.shivishbrahma.tilottama.main.game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;
import java.util.logging.Logger;

import com.shivishbrahma.tilottama.main.annotations.Command;
import com.shivishbrahma.tilottama.main.App;

/**
 * @author Purbayan Chowdhury<a href=
 *         "mailto:pur.cho.99@gmail.com">pur.cho.99@gmail.com</a>
 *
 */
public class MainGame {
    Logger rootLogger = Logger.getLogger(App.class.getName());
    public static final int seed = (int) Math.round(Math.random() * 1000);

    /**
     * Rolls dice
     */
    @Command(name = "roll", alias = { "dice" })
    public void rollDice() {
        System.out.println("Roll Dice: " + rollDice(seed));
    }

    /**
     * Rolls dice with seed
     */
    private int rollDice(int seed) {
        Random dice = new Random(seed);
        return (dice.nextInt(6) + 1);
    }

    /**
     * Flips coin
     */
    @Command(name = "toss", alias = { "coin" })
    public void flipCoin() {
        System.out.println("Flip Coin: " + flipCoin(seed));
    }

    /**
     * Flips coin with seed
     * 
     * @param seed
     * @return String
     */
    private String flipCoin(int seed) {
        Random coin = new Random(123);
        String s[] = { "Heads", "Tails" };
        return s[coin.nextInt(2)];
    }

    /**
     * Print no of digits after decimal
     * 
     * @param digits - No of digits after decimal
     * @return void
     */
    @Command(name = "pi", args = { "digits" })
    public void pi(int digits) {
        System.out.println(com.shivishbrahma.tilottama.main.par.StringHandler.wrapString(getPIDigits(digits), 64));
    }

    /**
     * Get PI digits
     * 
     * @param digits
     * @return String
     */
    private String getPIDigits(int digits) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("assets/data/pi.txt")));
            String s = br.readLine();
            return s.substring(0, digits + 2);
        } catch (Exception e) {
            rootLogger.severe(e.getMessage());
        }
        return "";
    }
}
