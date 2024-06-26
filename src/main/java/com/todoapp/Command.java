package com.todoapp;

public enum Command {
	ADD("add"),
	DONE("done"),
	DELETE("delete"),
	LIST("list"),
	UNKNOWN("unknown");

	private String command;

	Command(String command) {
			this.command = command;
	}

	public String getCommand() {
			return command;
	}

	public static Command fromString(String command) {
			for (Command c : Command.values()) {
					if (c.command.equalsIgnoreCase(command)) {
							return c;
					}
			}
			return UNKNOWN;
	}
}