package com.hascode.tutorial;

import static fj.data.Array.array;
import fj.Effect;
import fj.F;
import fj.data.Array;

public class ArrayFilteringExample {
	public static void main(final String[] args) {
		final Array<String> a = array("This", "is", "an", "example");
		final Array<String> b = a.filter(new F<String, Boolean>() {
			@Override
			public Boolean f(final String a) {
				return a.matches(".*i.*");
			}
		});
		b.foreach(new Effect<String>() {
			@Override
			public void e(final String a) {
				System.out.println(a);
			}
		}); // output: This is
	}
}
