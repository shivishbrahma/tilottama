/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilottama.util;

import java.io.File;

/**
 *
 * @author anitesh
 */
public class OSSystem {
	public static void details() {
		System.out.println("Memory Info: ");
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

		System.out.println("\nFile System: ");
		/* For each filesystem root, print some info */
		for (File root : roots) {
			System.out.println("File system root: " + root.getAbsolutePath());
			System.out.println("Total space (bytes): " + root.getTotalSpace());
			System.out.println("Free space (bytes): " + root.getFreeSpace());
			System.out.println("Usable space (bytes): " + root.getUsableSpace());
		}

		System.out.println("System Architechure");
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("os.arch"));
		System.out.println(System.getProperty("os.version"));
//        System.out.println(System.getProperty("java.version"));
//        System.out.println(System.getProperty("user.dir"));
//        System.out.println(System.getProperty("user.home"));        
		System.out.println(System.getProperty("user.name"));
//        System.out.println(System.getProperty("path.separator"));
		System.out.println("");
//		System.getProperties().list(System.out);

//        System.out.println(System.getenv("PROCESSOR_IDENTIFIER"));
//        System.out.println(System.getenv("PROCESSOR_ARCHITECTURE"));
//        System.out.println(System.getenv("PROCESSOR_ARCHITEW6432"));
//        System.out.println(System.getenv("NUMBER_OF_PROCESSORS"));

	}
}
