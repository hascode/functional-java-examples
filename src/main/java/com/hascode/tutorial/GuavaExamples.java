package com.hascode.tutorial;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class GuavaExamples {

	public static void main(final String[] args) {
		List<Book> books = newArrayList(new Book("Some book", "Arnold Author",
				1998), new Book("Programmers are weird", "Some author", 2011),
				new Book("Another book", "Another author", 2012), new Book(
						"Ye ole book", "Ye authorr", 1711), new Book(
						"Some book - second edition", "Arnold Author", 2010));

		Predicate<Book> newerThanYear2000 = new Predicate<Book>() {
			public boolean apply(final Book book) {
				return book.getYearPublished() >= 2000;
			}
		};

		Predicate<Book> byAuthorArnold = new Predicate<Book>() {
			public boolean apply(final Book book) {
				return book.getAuthor().equals("Arnold Author");
			}
		};

		System.out.println("books published in year 2000 and later");
		System.out.println(Iterables.filter(books, newerThanYear2000)
				.toString());

		System.out.println("books by author=Arnold Author");
		System.out.println(Iterables.filter(books, byAuthorArnold).toString());

		Function<Book, String> titleTransformer = new Function<GuavaExamples.Book, String>() {
			public String apply(final Book book) {
				return "X " + book.getTitle();
			}
		};
		// outputs:
		// "[X Some book, X Programmers are weird, X Another book, X Ye ole book, X Some book - second edition]"
		System.out.println(Iterables.transform(books, titleTransformer));

		Optional<Integer> computed1 = computeIntegerFrom("1234zzx");
		System.out.println(computed1.isPresent()); // false
		Optional<Integer> computed2 = computeIntegerFrom("12345");
		System.out.println(computed2.isPresent()); // true
		System.out.println(computed2.get()); // 12345
	}

	private static Optional<Integer> computeIntegerFrom(
			final String numberAsString) {
		try {
			Integer i = Integer.valueOf(numberAsString);
			return Optional.of(i);
		} catch (Exception e) {
		}
		return Optional.absent();
	};

	static class Book {
		final String title;
		final String author;
		final int yearPublished;

		public Book(final String title, final String author,
				final int yearPublished) {
			this.title = title;
			this.author = author;
			this.yearPublished = yearPublished;
		}

		public String getTitle() {
			return title;
		}

		public String getAuthor() {
			return author;
		}

		public int getYearPublished() {
			return yearPublished;
		}

		@Override
		public String toString() {
			return "Book [title=" + title + ", author=" + author
					+ ", yearPublished=" + yearPublished + "]";
		}

	}
}
