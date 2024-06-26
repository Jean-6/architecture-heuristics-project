package org.todolist.adapter.controller.cli;

import org.todolist.ports.input.TaskInputPort;

public class CommandLineInputReceptor {
    private final TaskInputPort taskInputPort;

    public CommandLineInputReceptor(TaskInputPort taskInputPort) {
        this.taskInputPort = taskInputPort;
    }

    public void handleCommand(String[] args) {
        String command = String.join(" ", args);
        taskInputPort.handleInput(command);
    }
}
