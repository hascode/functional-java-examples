package com.hascode.tutorial;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;
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

		Closure closure = new Closure() {
			public void execute(final Object obj) {
				Book book = (Book) obj;
				System.out.println("the book's title is: " + book.getTitle());
			}
		};
		CollectionUtils.forAllDo(books, closure);
		// the book's title is: Some book
		// the book's title is: Another book
		// the book's title is: I luv codin

		Transformer transformer = new Transformer() {
			public Object transform(final Object obj) {
				Book book = (Book) obj;
				return new Book("X " + book.getTitle(), book.getPublished());
			}
		};
		Collection<Book> transformedBooks = CollectionUtils.collect(books,
				transformer);
		CollectionUtils.forAllDo(transformedBooks, closure);
		// the book's title is: X Some book
		// the book's title is: X Another book
		// the book's title is: X I luv codin
	}
}
