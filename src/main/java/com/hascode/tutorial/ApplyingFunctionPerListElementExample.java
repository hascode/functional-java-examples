package com.hascode.tutorial;

import static fj.data.Array.array;
import static fj.function.Integers.multiply;

public class ApplyingFunctionPerListElementExample {
	public static void main(final String[] args) {
		// multiplies each element in the array with 1 and adds the results
		int result = array(1, 2, 3, 5).foldLeft(multiply, 1);
		System.out.println(result); // 30
	}
}
