package com.hascode.tutorial;

import java.util.Date;

class Book {
	private final String title;
	private final Date published;
	private float price;

	public Book(final String title, final Date published) {
		this.title = title;
		this.published = published;
	}

	public String getTitle() {
		return title;
	}

	public Date getPublished() {
		return published;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(final float price) {
		this.price = price;
	}
}
