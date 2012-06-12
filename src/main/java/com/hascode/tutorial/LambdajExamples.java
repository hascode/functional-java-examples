package com.hascode.tutorial;

import static ch.lambdaj.Lambda.forEach;
import static ch.lambdaj.Lambda.joinFrom;
import static ch.lambdaj.Lambda.max;
import static ch.lambdaj.Lambda.maxFrom;
import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.sort;
import static java.util.Arrays.asList;

import java.util.Date;
import java.util.List;

public class LambdajExamples {
	public static void main(final String... args) {
		List<Book> books = asList(new Book("Some book", new Date(123)),
				new Book("Another book", new Date(456)), new Book(
						"I luv codin", new Date(789)));
		// treating a collection like a single object
		forEach(books).setPrice(10.0f); // sets the price on all objects
		System.out.println(books.get(0).getPrice()); // output: 10.0
		System.out.println(books.get(1).getPrice()); // output: 10.0
		System.out.println(books.get(2).getPrice()); // output: 10.0

		// sorting the books by publication date
		List<Book> booksByDate = sort(books, on(Book.class).getPublished());
		System.out.println(booksByDate.get(0).getTitle()); // "output: Some book"
		System.out.println(booksByDate.get(1).getTitle()); // "output: Another book"
		System.out.println(booksByDate.get(2).getTitle()); // "output: I luv coding"

		// sorting the books by title
		List<Book> booksByTitle = sort(books, on(Book.class).getTitle());
		System.out.println(booksByTitle.get(0).getTitle()); // "output: Another book"
		System.out.println(booksByTitle.get(1).getTitle()); // "output: I luv coding"
		System.out.println(booksByTitle.get(2).getTitle()); // "output: Some book"

		// create a comma separated list of titles from the books collection
		String titles = joinFrom(books).getTitle();
		System.out.println(titles); // "Some book, Another book, I luv codin"

		// select the most expensive book's price
		books.get(1).setPrice(12.50f);
		books.get(2).setPrice(33.20f);

		float maxPrice = maxFrom(books).getPrice();
		System.out.println(maxPrice); // output: "33.2"

		// or another way
		float maxPrice2 = max(books, on(Book.class).getPrice());
		System.out.println(maxPrice2); // output: "33.2"
	}
}
