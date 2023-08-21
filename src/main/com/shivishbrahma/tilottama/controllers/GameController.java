/**
 *
 */
package com.shivishbrahma.tilottama.controllers;

import com.shivishbrahma.tilottama.App;
import com.shivishbrahma.tilottama.annotations.CommandAnnotate;
import com.shivishbrahma.tilottama.handlers.PropertiesHandler;
import com.shivishbrahma.tilottama.handlers.StringHandler;
import com.shivishbrahma.tilottama.annotations.ArgAnnotate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.logging.Logger;

/**
 * @author Purbayan Chowdhury<a href=
 *         "mailto:pur.cho.99@gmail.com">pur.cho.99@gmail.com</a>
 */
public class GameController {
    private static Logger rootLogger = Logger.getLogger(App.class.getName());
    public static int seed = (int) Math.round(Math.random() * 1000);

    /**
     * Rolls dice
     */
    @CommandAnnotate(name = "roll", alias = { "dice" })
    public static void rollDice() {
        System.out.println("Roll Dice: " + rollDice(seed));
    }

    /**
     * Rolls dice with seed
     *
     * @param seed int - Seed for random
     * @return int
     */
    private static int rollDice(int seed) {
        Random dice = new Random(seed);
        return (dice.nextInt(256) % 6 + 1);
    }

    /**
     * Flips coin
     */
    @CommandAnnotate(name = "toss", alias = { "coin" })
    public static void flipCoin() {
        System.out.println("Flip Coin: " + flipCoin(seed));
    }

    /**
     * Flips coin with seed
     *
     * @param seed int - Seed for random
     * @return String
     */
    protected static String flipCoin(int seed) {
        Random coin = new Random(seed);
        String[] s = { "Heads", "Tails" };
        return s[coin.nextInt(256) % 2];
    }

    /**
     * Print no of digits after decimal
     *
     * @param digits int - No of digits after decimal
     */
    @CommandAnnotate(name = "pi", args = {
            @ArgAnnotate(name = "digits", dataType = Integer.class, dataDefault = "8")
    })
    public static void pi(int digits) {
        System.out.println(StringHandler.wrapString(getPIDigits(digits), 64));
    }

    /**
     * Get PI digits
     *
     * @param digits int - No of digits after decimal
     * @return String
     */
    private static String getPIDigits(int digits) {
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(PropertiesHandler.getResourceStream("data/pi.txt")));
            String s = br.readLine();
            return s.substring(0, digits + 2);
        } catch (Exception e) {
            rootLogger.severe(e.toString());
            // e.printStackTrace();
        }
        return "";
    }
}
