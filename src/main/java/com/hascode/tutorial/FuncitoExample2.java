package com.hascode.tutorial;

import static com.google.common.collect.Lists.newArrayList;
import static org.funcito.Funcito.callsTo;
import static org.funcito.FuncitoGuava.functionFor;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

public class FuncitoExample2 {
	public static void main(final String[] args) {
		List<User> users = newArrayList(new User("Bob", false), new User("Tim",
				true), new User("Suz", true), new User("Charlize", false),
				new User("Allan", false), new User("Steve", true));

		System.out.println("user names:");
		Function<User, String> namesFunc = functionFor(callsTo(User.class)
				.getName());
		List<String> userNames = Lists.transform(users, namesFunc);
		System.out.println(userNames);
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
