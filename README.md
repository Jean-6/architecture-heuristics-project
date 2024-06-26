# MyApp

## Description

MyApp is a command-line application for managing tasks. You can add tasks, update their status, delete them, and list all tasks. Tasks are stored in a text file.

## Usage

```sh
myapp {command} {arguments}

Commands

    add {description}: Add a new task with the given description.
    done {id}: Mark the task with the given id as done.
    delete {id}: Delete the task with the given id.
    list: List all tasks.

Examples

		myapp add "Buy milk"
		myapp done 1
		myapp delete 1
		myapp list
```