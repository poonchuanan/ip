# Duke User Guide
Duke is an application that keeps track of your completion of daily tasks such as things to do, deadlines and events. 

- [Quick start](#quick-start) 
- [Features](#features)
    - [Adding a Todo task : ``` todo ```](#adding-a-todo-task-todo)
    - [Adding a Deadline task : ``` deadline ```](#adding-a-deadline-task-deadline)
    - [Adding an Event task : ``` event ```](#adding-an-event-task-event)
    - [Listing of all tasks: ``` list ```](#listing-of-all-tasks-list)
    - [Marking task as done ``` done ```](#marking-task-as-done-done)
    - [Deleting a task: ``` delete ```](#deleting-a-task-delete)
    - [Finding a task: ``` find ```](#finding-a-task-find)
    - [Saving task list data](#saving-tasklist-data)
    - [Exiting the application: ``` bye ```](#exiting-the-application-bye)
- [Command Summary](#command-summary)

### Quick Start
1. Download Java 11 on your computer.
2. Download the latest version of Duke.jar from github.
3. Save the file into a folder to run the program from.
4. Use the command line navigate to the directory of where Duke.jar is in.
5. Run the command java -jar Duke.jar.
6. The application will then start running.

## Features 

### Adding a Todo task: ``` todo ``` 
This command adds a todo task to the tasklist.

Format: ```todo DESCRIPTION_OF_TASK```

Example of usage: ```todo read book```

Example outcome:
```
Got it. I've added this task: 
	[T][✘]  read book
Now you have 1 task(s) in the list.
```
## Adding a Deadline task: ``` deadline ```
This command adds a deadline task to the tasklist.

Format: ```deadline DESCRIPTION_OF_TASK /by DEADLINE```

Example of usage: ```deadline submit homework /by 5pm```

Example outcome:
```
Got it. I've added this task: 
	[D][✘]  submit homework (by: 5pm)
Now you have 2 task(s) in the list.
```
## Adding an Event task: ``` event ```
This command adds an event to the tasklist.

Format: ```event DESCRIPTION_OF_TASK /at EVENT_DATE```

Example of usage: ```event play basketball /at wed night```

Example outcome:
```
Got it. I've added this task: 
	[E][✘]  play basketball (at: wed night)
Now you have 3 tasks in the list.
```
## Listing of all tasks: ``` list ```
This command lists all the tasks that are currently in the task list.

Format: ```list```

Example of usage: ```list```

Example outcome: 
```
Here are the tasks in your list:
1. [T][✘]  read book
2. [D][✘]  submit homework (by: 5pm)
3. [E][✘]  play basketball (at: wed night)
```
## Marking task as done ``` done ```
This command marks a task in the task list as done by specifying the task number.

Format: ```done TASK_NUMBER```

Example of usage: ```done 2```

Example outcome:
```
Nice! I've marked this task as done: 
[D][✓]  submit homework (by: 5pm)
```

## Deleting a task: ``` delete ```
This command deletes a task from the task list by specifying the task number.

Format:```delete TASK_NUMBER```

Example of usage: ```delete 1```

Example outcome:
```
Noted. I've removed this task: 
	[T][✘]  read book
Now you have 2 task(s) in the list.
```

## Finding a task: ``` find ```
This command finds all tasks which contains the specific keyword.

Format: ```find KEYWORD```

Example of usage: ```find homework```

Example outcome:
```
Here are the matching tasks in your list: 
2. [D][✘]  submit homework (by: 5pm)
```
## Saving data 

Duke saves the data entered into a text file every time the tasklist is updated. It will also load the saved data every time the application is launched.

The application stores the data in the following format:
```
[T][✘]  read book
[D][✘]  submit homework (by: 5pm)
[E][✘]  play basketball (at: wed night)
```
## Exiting the application: ``` bye ```
This command stops the application.

Format: ```bye```

Example of usage: ```bye```

Example outcome:
```
Bye. Hope to see you again soon!
```
### Tasks legend
- T: Represents a Todo task
- D: Represents a Deadline task 
- E: Represents an Event task

### Task completion legend
- ✓: Task is done
- ✘: Task is not completed

## Command Summary
|Command  |Syntax and Examples       |
|---------|--------------------------|
|todo| `todo DESCRIPTION_OF_TASK` <br> Example: `todo read book`|
|deadline|`deadline DESCRIPTION_OF_TASK /by TASK_DATE` <br> Example: `deadline submit homework /by tmr`|
|event|`event DESCRIPTION_OF_TASK /at TASK_DATE` <br> Example: `event play basketball /at wed night`|
|list|`list`|
|done|`done TASK_NUMBER` <br> Example: `done 1`|
|delete|`delete TASK_NUMBER` <br> Example: `delete 1`|
|find|`find KEYWORD` <br> Example: `find read`|
|bye|`bye`|
