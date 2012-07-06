package com.hascode.tutorial;

import static fj.data.Array.array;
import fj.Effect;
import fj.F;
import fj.F2;

public class DifferentArityFunctionsExample {
	public static void main(final String[] args) {
		F<String, Boolean> endsWithX = new F<String, Boolean>() {
			@Override
			public Boolean f(final String a) {
				return a.endsWith("x");
			}
		};

		// output: "barx bazx"
		array("foo", "barx", "moo", "bazx").filter(endsWithX).foreach(output);

		F2<String, String, Boolean> stringsEqual = new F2<String, String, Boolean>() {
			@Override
			public Boolean f(final String a, final String b) {
				return a.equals(b);
			}

		};
	}

	static Effect<String> output = new Effect<String>() {
		@Override
		public void e(final String a) {
			System.out.println(a);
		}
	};
}
