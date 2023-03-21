package org.todo;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TodoList todoList = new TodoList("src/main/resources/todos.json");

        while (true) {
            System.out.println("Todo List");
            System.out.println("1. Add task");
            System.out.println("2. Remove task");
            System.out.println("3. Mark task as complete");
            System.out.println("4. Mark task as incomplete");
            System.out.println("5. Display tasks");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine(); // consume newline character
                    System.out.print("Enter task: ");
                    String task = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    todoList.addTask(new Task(task, description));
                    System.out.println("Task added");
                    break;
                case 2:
                    System.out.print("Enter index of task to remove: ");
                    int index = scanner.nextInt() - 1;
                    todoList.removeTask(index);
                    System.out.println("Task removed");
                    break;
                case 3:
                    System.out.print("Enter index of task to mark as complete: ");
                    index = scanner.nextInt() - 1;
                    todoList.markTaskCompleted(index);
                    System.out.println("Task marked as complete");
                    break;
                case 4:
                    System.out.print("Enter index of task to mark as incomplete: ");
                    index = scanner.nextInt() - 1;
                    todoList.markTaskIncomplete(index);
                    System.out.println("Task marked as incomplete");
                    break;
                case 5:
                    System.out.println("Todo List:");
                    todoList.displayAllTasks();
                    break;
                case 6:
                    System.exit(0);
                    scanner.close();
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
