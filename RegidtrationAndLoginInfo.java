/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package registrationandlogininfo;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author rakwa
 */
public class RegidtrationAndLoginInfo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    


public class RegistrationAndLogin2 {

    public static void main(String[] args) {
        KanbanBoard.main(args);
    }
    
    static class User {
        String username;
        String password;
        String firstName;
        String lastName;
        
        User(String username, String password, String firstName, String lastName) {
            this.username = username;
            this.password = password;
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }

    static class Task {
        String taskName;
        int taskNumber;
        String taskDescription;
        String developerDetails;
        double taskDuration;
        String taskStatus;
        String taskID;
        
        Task(String taskName, int taskNumber, String taskDescription, String developerDetails, double taskDuration, String taskStatus) {
            this.taskName = taskName;
            this.taskNumber = taskNumber;
            this.taskDescription = taskDescription;
            this.developerDetails = developerDetails;
            this.taskDuration = taskDuration;
            this.taskStatus = taskStatus;
            this.taskID = createTaskID();
        }

        String createTaskID() {
            return taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + developerDetails.substring(developerDetails.length() - 3).toUpperCase();
        }

    }
    
    static class KanbanBoard {
        static ArrayList<User> users = new ArrayList<>();
        static ArrayList<Task> tasks = new ArrayList<>();
        static Scanner scanner = new Scanner(System.in);
        
        public static void main(String[] args) {
            System.out.println("Welcome to EasyKanban");
            int choice;

            OUTER:
            while (true) {
                System.out.println("\nChoose an option:");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Quit");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> register();
                    case 2 -> login();
                    case 3 -> {
                        break OUTER;
                    }
                    default -> System.out.println("Invalid option, please try again.");
                }
            }
        }
        
        static void register() {
            System.out.print("Enter a username (with an underscore and no more than 5 characters): ");
            String username = scanner.next();
            if (checkUserName(username)) {
                System.out.print("Enter a password (at least 8 characters, a capital letter, a number, and special character): ");
                String password = scanner.next();
                if (checkPasswordComplexity(password)) {
                    System.out.print("Enter your first name: ");
                    String firstName = scanner.next();
                    System.out.print("Enter your last name: ");
                    String lastName = scanner.next();
                    users.add(new User(username, password, firstName, lastName));
                    System.out.println("User registered successfully.");
                } else {
                    System.out.println("Invalid password, please try again.");
                }
            } else {
                System.out.println("Invalid username, please try again.");
            }
        }
        
        static boolean checkUserName(String username) {
            return username.contains("_") && username.length() <= 5;
        }

        static void login() {
            System.out.print("Enter your username: ");
            String username = scanner.next();
            System.out.print("Enter your password: ");
            String password = scanner.next();
            
            for (User user : users) {
                if (user.username.equals(username) && user.password.equals(password)) {
                    System.out.println("Login successful. Welcome, " + user.firstName + "!");
                    return;
                }
            }
            System.out.println("Invalid username or password, please try again.");
        }

        static boolean checkPasswordComplexity(String password) {
            if (password.length() < 8) return false;
            boolean hasUpperCase = false, hasLowerCase = false, hasDigit = false, hasSpecialChar = false;
            for (char c : password.toCharArray()) {
                if (Character.isUpperCase(c)) hasUpperCase = true;
                if (Character.isLowerCase(c)) hasLowerCase = true;
                if (Character.isDigit(c)) hasDigit = true;
                if (!Character.isLetterOrDigit(c)) hasSpecialChar = true;
            }
            return hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar;
        }
    }
    }

    
}
