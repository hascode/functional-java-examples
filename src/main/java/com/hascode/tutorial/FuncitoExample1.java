package com.hascode.tutorial;

import static com.google.common.collect.Lists.newArrayList;
import static org.funcito.FuncitoGuava.callsTo;
import static org.funcito.FuncitoGuava.predicateFor;

import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class FuncitoExample1 {
	public static void main(final String[] args) {
		List<User> users = newArrayList(new User("Bob", false), new User("Tim",
				true), new User("Suz", true), new User("Charlize", false),
				new User("Allan", false), new User("Steve", true));

		Predicate<User> activeUsers = predicateFor(callsTo(User.class)
				.isActive());

		System.out.println("active users are:");
		System.out.println(Iterables.filter(users, activeUsers).toString());
	}

	private static class User {
		private final String name;
		private final boolean active;

		public User(final String name, final boolean active) {
			this.name = name;
			this.active = active;
		}

		public String getName() {
			return name;
		}

		public boolean isActive() {
			return active;
		}

		@Override
		public String toString() {
			return "User [name=" + name + ", active=" + active + "]";
		}
	}
}
