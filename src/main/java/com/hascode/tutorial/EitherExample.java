package com.hascode.tutorial;

import fj.data.Either;

public class EitherExample {
	public static void main(final String[] args) {
		Either<Exception, Integer> result1 = parseInteger("123456h4");
		System.out.println(result1.isLeft()); // true
		System.out.println(result1.left().value().getClass()); // "class java.lang.NumberFormatException"

		Either<Exception, Integer> result2 = parseInteger("123456");
		System.out.println(result2.isLeft()); // false
		System.out.println(result2.right().value()); // 123456
	}

	private static Either<Exception, Integer> parseInteger(final String string) {
		try {
			return Either.right(Integer.valueOf(string));
		} catch (Exception e) {
			return Either.left(e);
		}
	}
}
