import java.util.Scanner;

public class OnlineExamSystem {
    private static final int EXAM_DURATION = 60; 
    
    private static String username;
    private static String password;
    private static boolean isLoggedIn;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        displayWelcomeMessage();
        
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    updateProfile(scanner);
                    break;
                case 3:
                    if (isLoggedIn) {
                        takeExam(scanner);
                    } else {
                        System.out.println("You must be logged in to take the exam.");
                    }
                    break;
                case 4:
                    if (isLoggedIn) {
                        displayRemainingTime();
                    } else {
                        System.out.println("You must be logged in to view the remaining time.");
                    }
                    break;
                case 5:
                    logout();
                    break;
                case 6:
                    System.out.println("Thank you for using the Online Examination System. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
    
    private static void displayWelcomeMessage() {
        System.out.println("Welcome to the Online Examination System!");
    }
    
    private static void displayMenu() {
        System.out.println("\nPlease select an option:");
        System.out.println("1. Login");
        System.out.println("2. Update Profile and Password");
        System.out.println("3. Take Exam");
        System.out.println("4. View Remaining Time");
        System.out.println("5. Logout");
        System.out.println("6. Exit");
    }
    
    private static void login(Scanner scanner) {
        System.out.println("\n=== Login ===");
        
        System.out.print("Username: ");
        String inputUsername = scanner.next();
        System.out.print("Password: ");
        String inputPassword = scanner.next();
        
        if (inputUsername.equals("admin") && inputPassword.equals("password")) {
            isLoggedIn = true;
            username = inputUsername;
            System.out.println("Login successful. Welcome, " + username + "!");
        } else {
            System.out.println("Invalid username or password. Login failed.");
        }
    }
    
    private static void updateProfile(Scanner scanner) {
        if (isLoggedIn) {
            System.out.println("\n=== Update Profile and Password ===");
            
            System.out.print("New Profile: ");
            String newProfile = scanner.next();
            System.out.print("New Password: ");
            String newPassword = scanner.next();
            
         
            username = newProfile;
            password = newPassword;
            
            System.out.println("Profile and password updated successfully.");
        } else {
            System.out.println("You must be logged in to update the profile and password.");
        }
    }
    
    private static void takeExam(Scanner scanner) {
        System.out.println("\n=== Exam ===");
        
        
        
        int totalQuestions = 5;
        int score = 0;
        
        for (int questionNumber = 1; questionNumber <= totalQuestions; questionNumber++) {
            System.out.println("\nQuestion " + questionNumber + ":");
            System.out.println("Question text goes here...");
            System.out.println("a) Option A");
            System.out.println("b) Option B");
            System.out.println("c) Option C");
            System.out.println("d) Option D");
            System.out.println();
            
            System.out.print("Your answer (a, b, c, or d): ");
            String answer = scanner.next();
            
            
            if (answer.equals("c")) {
                score++;
            }
        }
        
        System.out.println("\nExam complete. Your score: " + score + "/" + totalQuestions);
    }
    
    private static void displayRemainingTime() {
        System.out.println("\n=== Remaining Time ===");
        int remainingTime = EXAM_DURATION; 
        
        System.out.println("Remaining time: " + remainingTime + " minutes");
    }
    
    private static void logout() {
        if (isLoggedIn) {
            System.out.println("\nLogout successful. Goodbye, " + username + "!");
            isLoggedIn = false;
            username = null;
            password = null;
        } else {
            System.out.println("You are not currently logged in.");
        }
    }
}
