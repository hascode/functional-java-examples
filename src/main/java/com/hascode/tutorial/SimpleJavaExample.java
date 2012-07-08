package com.hascode.tutorial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SimpleJavaExample {
	public static void main(final String[] args) {
		new Thread(new Runnable() {
			public void run() {
				System.out.println("i am enclosed ;)");
			}
		}).start();

		List<String> names = new ArrayList<String>();
		names.add("Tim");
		names.add("Bart");
		names.add("Zaphod");
		Collections.sort(names, new Comparator<String>() {
			public int compare(final String s1, final String s2) {
				return s2.compareTo(s1);
			}
		});
		// output: [Zaphod, Tim, Bart]
		System.out.println(names.toString());
	}
}
