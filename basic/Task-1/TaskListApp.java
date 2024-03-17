import java.util.ArrayList;
import java.util.Scanner;

public class TaskListApp {
    private static ArrayList<String> taskList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("Task List Application");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. List Tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    removeTask();
                    break;
                case 3:
                    listTasks();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }

        scanner.close();
    }

    private static void addTask() {
        System.out.print("Enter task: ");
        String task = scanner.nextLine();
        taskList.add(task);
        System.out.println("Task added successfully.");
    }

    private static void removeTask() {
        if (taskList.isEmpty()) {
            System.out.println("Task list is empty.");
            return;
        }

        System.out.print("Enter task index to remove (1-" + taskList.size() + "): ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (index >= 1 && index <= taskList.size()) {
            String removedTask = taskList.remove(index - 1);
            System.out.println("Task \"" + removedTask + "\" removed successfully.");
        } else {
            System.out.println("Invalid index. Please enter a number between 1 and " + taskList.size() + ".");
        }
    }

    private static void listTasks() {
        if (taskList.isEmpty()) {
            System.out.println("Task list is empty.");
            return;
        }

        System.out.println("Tasks:");
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println((i + 1) + ". " + taskList.get(i));
        }
    }
}
