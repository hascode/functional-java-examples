package com.hascode.tutorial;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.iterators.FilterIterator;

public class CommonsCollectionExample {
	public static void main(final String[] args) {
		List<Book> books = new ArrayList<Book>();
		books.add(new Book("Some book", new Date(123)));
		books.add(new Book("Another book", new Date(456)));
		books.add(new Book("I luv codin", new Date(789)));

		Predicate titlePredicate = new Predicate() {
			public boolean evaluate(final Object obj) {
				return ((Book) obj).getTitle().matches(".*book$");
			}
		};

		@SuppressWarnings("unchecked")
		Iterator<Book> booksIterator = new FilterIterator(books.iterator(),
				titlePredicate);
		while (booksIterator.hasNext()) {
			System.out.println(booksIterator.next().getTitle());
		}
		// output:
		// Some book
		// Another book
	}
}
