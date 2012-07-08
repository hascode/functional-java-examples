package com.hascode.tutorial;

import static fj.data.Array.array;
import static fj.function.Integers.multiply;
import fj.Effect;
import fj.F;

public class ApplyingFunctionPerListElementExample {
	public static void main(final String[] args) {
		// multiplies each element in the array with 1 and adds the results
		int result = array(1, 2, 3, 5).foldLeft(multiply, 1);
		System.out.println(result); // 30

		// adds 1 to each element and multiplies the result by 2
		// output: 4 6 8 12
		array(1, 2, 3, 5).map(new F<Integer, Integer>() {
			@Override
			public Integer f(final Integer a) {
				return (a + 1) * 2;
			}
		}).foreach(new Effect<Integer>() {
			@Override
			public void e(final Integer a) {
				System.out.print(a + " ");
			}
		});
	}
}
