package com.shivishbrahma.tilottama.util;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Scanner;

import com.shivishbrahma.tilottama.handlers.StringHandler;

/**
 * @author Purbayan Chowdhury<a href=
 *         "mailto:pur.cho.99@gmail.com">pur.cho.99@gmail.com</a>
 *
 */
public class OSSystem {
    /**
     * 
     */
    public static void details() {
        System.out.println("\n" + StringHandler.centerAligned("MEMORY INFO", 64, "="));
        /* Total number of processors or cores available to the JVM */
        System.out.println("Available processors (cores): " + Runtime.getRuntime().availableProcessors());

        /* Total amount of free memory available to the JVM */
        System.out.println("Free memory (bytes): " + Runtime.getRuntime().freeMemory());

        /* This will return Long.MAX_VALUE if there is no preset limit */
        long maxMemory = Runtime.getRuntime().maxMemory();
        /* Maximum amount of memory the JVM will attempt to use */
        System.out.println("Maximum memory (bytes): " + (maxMemory == Long.MAX_VALUE ? "no limit" : maxMemory));

        /* Total memory currently available to the JVM */
        System.out.println("Total memory available to JVM (bytes): " + Runtime.getRuntime().totalMemory());

        /* Get a list of all filesystem roots on this system */
        File[] roots = File.listRoots();

        System.out.println("\n" + StringHandler.centerAligned("FILE SYSTEM", 64, "="));
        /* For each filesystem root, print some info */
        for (File root : roots) {
            System.out.println(StringHandler.leftAligned("File system root", 32) + ": "
                    + StringHandler.rightAligned(root.getAbsolutePath().toString(), 32));
            System.out.println(StringHandler.leftAligned("Total space (bytes)", 32) + ": "
                    + StringHandler.rightAligned(Long.toString(root.getTotalSpace()), 32));
            System.out.println(StringHandler.leftAligned("Free space (bytes)", 32) + ": "
                    + StringHandler.rightAligned(Long.toString(root.getFreeSpace()), 32));
            System.out.println(StringHandler.leftAligned("Usable space (bytes)", 32) + ": "
                    + StringHandler.rightAligned(Long.toString(root.getUsableSpace()), 32));
        }

        System.out.println("\n" + StringHandler.centerAligned("SYSTEM ARCHITECTURE", 64, "="));
        osInfo();
        userInfo();
        // System.out.println(System.getProperty("java.version"));
        // System.out.println(System.getProperty("path.separator"));

        // System.getProperties().list(System.out);
        // System.out.println(System.getenv("PROCESSOR_IDENTIFIER"));
        // System.out.println(System.getenv("PROCESSOR_ARCHITECTURE"));
        // System.out.println(System.getenv("PROCESSOR_ARCHITEW6432"));
        // System.out.println(System.getenv("NUMBER_OF_PROCESSORS"));
    }

    public static void osInfo() {
        System.out.println("\n" + StringHandler.centerAligned("OS INFO", 64, "="));
        System.out.println(StringHandler.leftAligned("OS Name", 32) + ": "
                + StringHandler.rightAligned(System.getProperty("os.name"), 32));
        System.out.println(StringHandler.leftAligned("OS Architecture: ", 32) + ": "
                + StringHandler.rightAligned(System.getProperty("os.arch"), 32));
        System.out.println(StringHandler.leftAligned("OS Version: ", 32) + ": "
                + StringHandler.rightAligned(System.getProperty("os.version"), 32));
        System.out.println(StringHandler.leftAligned("OS Distro: ", 32) + ": "
                + StringHandler.rightAligned(System.getProperty("java.vendor"), 32));
        System.out.println(StringHandler.leftAligned("OS Data Model: ", 32) + ": "
                + StringHandler.rightAligned(System.getProperty("sun.arch.data.model") + "bit", 32));
    }

    public static void javaDetails() {
        System.out.println("\n" + StringHandler.centerAligned("JAVA INFO", 64, "="));

    }

    public static void userInfo() {
        System.out.println("\n" + StringHandler.centerAligned("USER INFO", 64, "="));
        System.out.println(StringHandler.leftAligned("User Name: ", 32) + ": "
                + StringHandler.rightAligned(System.getProperty("user.name"), 32));
        System.out.println(StringHandler.leftAligned("User Directory", 32) + ":"
                + StringHandler.rightAligned(System.getProperty("user.dir"), 32));
        System.out.println(StringHandler.leftAligned("User Home", 32) + ":"
                + StringHandler.rightAligned(System.getProperty("user.home"), 32));
    }

    public static void ipInfo() {
        System.out.println("\n" + StringHandler.centerAligned("IP INFO", 64, "="));
        try {
            System.out.println("Your Host addr: " + InetAddress.getLocalHost().getHostAddress());
            Enumeration<NetworkInterface> n = NetworkInterface.getNetworkInterfaces();
            for (; n.hasMoreElements();) {
                NetworkInterface e = n.nextElement();

                Enumeration<InetAddress> a = e.getInetAddresses();
                for (; a.hasMoreElements();) {
                    InetAddress addr = a.nextElement();
                    System.out.println(addr.getHostAddress());
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }

    public static void systemInfo() throws IOException {
        Process process = Runtime.getRuntime().exec("pyarchey");
        // deal with OutputStream to send inputs
        // process.getOutputStream();

        // deal with InputStream to get ordinary outputs
        Scanner scanner = new Scanner(process.getInputStream());
        scanner.useDelimiter("\r\n");

        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }

        scanner.close();

        // deal with ErrorStream to get error outputs
        process.getErrorStream();
    }
}
