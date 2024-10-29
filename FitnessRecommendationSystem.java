// src/FitnessRecommendationSystem.java

import java.util.List;
import java.util.Scanner;

public class FitnessRecommendationSystem {
    public static void main(String[] args) {
        AuthenticationService authService = new AuthenticationService();
        FitnessPlanMatcher planMatcher = new FitnessPlanMatcher();
        Scanner scanner = new Scanner(System.in);
        User user = null;

        // Prompt for sign-up or login
        System.out.println("Welcome! Please choose an option:\n1. Sign Up\n2. Login");
        String option = scanner.nextLine();

        // Handle Sign-Up
        if ("1".equals(option)) {
            boolean signupSuccess = false;
            while (!signupSuccess) {
                System.out.print("Enter a new username: ");
                String username = scanner.nextLine();
                System.out.print("Enter a password: ");
                String password = scanner.nextLine();
                System.out.print("Choose your role (Member): ");
                String role = scanner.nextLine();

                if (!"Member".equalsIgnoreCase(role)) {
                    System.out.println("Invalid role. Only 'Member' role is allowed.");
                    continue;
                }

                signupSuccess = authService.signup(username, password, role);
            }
        }

        // Handle Login
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        user = authService.login(username, password);

        // Exit if authentication fails
        if (user == null) {
            System.out.println("Authentication failed. Exiting application.");
            return;
        }

        // Collect fitness preferences for recommendation
        System.out.print("Enter your primary fitness goal (e.g., Weight Loss, Muscle Building): ");
        String fitnessGoal = scanner.nextLine();
        System.out.print("Enter your fitness level (Beginner, Intermediate, Advanced): ");
        String fitnessLevel = scanner.nextLine();
        
        // Set user preferences
        user = new User(user.getUsername(), user.getPassword(), fitnessGoal, fitnessLevel, null, "Member");

        // Retrieve matching fitness plans
        List<FitnessPlan> matchedPlans = planMatcher.matchPlans(user);
        System.out.println("\nRecommended Fitness Plans:");
        
        if (matchedPlans.isEmpty()) {
            System.out.println("No matching fitness plans found for your preferences.");
        } else {
            for (FitnessPlan plan : matchedPlans) {
                System.out.println(plan.toString());
            }
        }
        
        scanner.close();
    }
}
