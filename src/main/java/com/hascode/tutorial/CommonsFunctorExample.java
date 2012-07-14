package com.hascode.tutorial;

import org.apache.commons.functor.Predicate;
import org.apache.commons.functor.Procedure;
import org.apache.commons.functor.core.algorithm.WhileDo;

public class CommonsFunctorExample {
	public static void main(final String[] args) {
		Predicate predicate = new Predicate() {
			public boolean test() {
				return true;
			}
		};
		Procedure procedure = new Procedure() {
			public void run() {
				System.out.println("test");
			}
		};
		new WhileDo(predicate, procedure).run();
	}
}
