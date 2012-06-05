package com.hascode.tutorial;

import fj.data.Option;

public class OptionExample {
	public static void main(final String[] args) {
		Option<Integer> result1 = parseInteger("1234G46");
		System.out.println(String.format("isNone: %s / isSome: %s",
				result1.isNone(), result1.isSome())); // "isNone: true / isSome: false"

		Option<Integer> result2 = parseInteger("1234");
		System.out.println(String.format("isNone: %s / isSome: %s",
				result2.isNone(), result2.isSome())); // "isNone: false / isSome: true"
		System.out.println(result2.some()); // 1234
	}

	private static Option<Integer> parseInteger(final String string) {
		try {
			return Option.some(Integer.valueOf(string));
		} catch (Exception e) {
			return Option.none();
		}
	}

}
