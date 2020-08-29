/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilottama.util;

import java.io.File;

import tilottama.par.StringHandler;

/**
 *
 * @author anitesh
 */
public class OSSystem {
	/**
	 * 
	 */
	public static void details() {

		System.out.println("\n" + StringHandler.centerAligned("MEMORY INFO", 62, "="));
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

		System.out.println("\n" + StringHandler.centerAligned("FILE SYSTEM", 52, "="));
		/* For each filesystem root, print some info */
		for (File root : roots) {
			System.out.println(StringHandler.leftAligned("File system root", 25) + ": "
					+ StringHandler.rightAligned(root.getAbsolutePath().toString(), 25));
			System.out.println(StringHandler.leftAligned("Total space (bytes)", 25) + ": "
					+ StringHandler.rightAligned(Long.toString(root.getTotalSpace()), 25));
			System.out.println(StringHandler.leftAligned("Free space (bytes)", 25) + ": "
					+ StringHandler.rightAligned(Long.toString(root.getFreeSpace()), 25));
			System.out.println(StringHandler.leftAligned("Usable space (bytes)", 25) + ": "
					+ StringHandler.rightAligned(Long.toString(root.getUsableSpace()), 25));
		}

		System.out.println("\n" + StringHandler.centerAligned("SYSTEM ARCHITECTURE", 52, "="));
		System.out.println(StringHandler.leftAligned("OS Name", 25) + ": "
				+ StringHandler.rightAligned(System.getProperty("os.name"), 25));
		System.out.println(StringHandler.leftAligned("OS Architecture: ", 25) + ": "
				+ StringHandler.rightAligned(System.getProperty("os.arch"), 25));
		System.out.println(StringHandler.leftAligned("OS Version: ", 25) + ": "
				+ StringHandler.rightAligned(System.getProperty("os.version"), 25));
//        System.out.println(System.getProperty("java.version"));
//        System.out.println(System.getProperty("user.dir"));
//        System.out.println(System.getProperty("user.home"));        
		System.out.println(StringHandler.leftAligned("User Name: ", 25) + ": "
				+ StringHandler.rightAligned(System.getProperty("user.name"), 25));
//        System.out.println(System.getProperty("path.separator"));

//		System.getProperties().list(System.out);
//        System.out.println(System.getenv("PROCESSOR_IDENTIFIER"));
//        System.out.println(System.getenv("PROCESSOR_ARCHITECTURE"));
//        System.out.println(System.getenv("PROCESSOR_ARCHITEW6432"));
//        System.out.println(System.getenv("NUMBER_OF_PROCESSORS"));

	}
}
