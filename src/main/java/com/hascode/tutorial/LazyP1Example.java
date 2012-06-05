package com.hascode.tutorial;

import fj.P1;
import fj.data.Either;

public class LazyP1Example {
	public static void main(final String[] args) {
		P1<Either<Exception, Integer>> result1 = parseInteger("123456h4");
		System.out.println(result1._1().isLeft()); // true
		System.out.println(result1._1().left().value().getClass()); // "class java.lang.NumberFormatException"

		P1<Either<Exception, Integer>> result2 = parseInteger("123456");
		System.out.println(result2._1().isLeft()); // false
		System.out.println(result2._1().right().value()); // 123456
	}

	private static P1<Either<Exception, Integer>> parseInteger(
			final String string) {
		return new P1<Either<Exception, Integer>>() {
			@Override
			public Either<Exception, Integer> _1() {
				try {
					return Either.right(Integer.valueOf(string));
				} catch (Exception e) {
					return Either.left(e);
				}
			}
		};
	}
}
