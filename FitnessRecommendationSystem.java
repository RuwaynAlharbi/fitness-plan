import java.util.List;
import java.util.Scanner;

public class FitnessRecommendationSystem {
    public static void main(String[] args) {
        AuthenticationService authService = new AuthenticationService();
        FitnessPlanMatcher planMatcher = new FitnessPlanMatcher();
        Scanner scanner = new Scanner(System.in);
        User user = null;

        // Prompt for Sign-Up or Login
        System.out.println("Welcome! Please choose an option:\n1. Sign Up\n2. Login");
        String option = scanner.nextLine();

        // Handle Sign-Up
        if ("1".equals(option)) {
            boolean signupSuccess = false;
            while (!signupSuccess) {
                String username = getInput(scanner, "new username");
                String password = getInput(scanner, "new password");
                String role = getInput(scanner, "your role (Member)");

                if (!"Member".equalsIgnoreCase(role)) {
                    System.out.println("Invalid role. Only 'Member' role is allowed.");
                    continue;
                }

                System.out.println("Enter additional details to complete the sign-up process:");
                int age = Integer.parseInt(getInput(scanner, "Age"));

                signupSuccess = authService.signup(username, password, role, age, null, null);
            }
        }

        // Handle Login
        String username = getInput(scanner, "username");
        String password = getInput(scanner, "password");
        user = authService.login(username, password);

        // Exit if authentication fails
        if (user == null) {
            System.out.println("Authentication failed. Exiting application.");
            return;
        }

        // Collect fitness preferences
        System.out.println("Please provide additional details for personalized fitness recommendations:");
        System.out.print("Enter your primary fitness goal (e.g., Weight Loss, Muscle Building, Improve Flexibility, Stress Relief): ");
        String fitnessGoal = scanner.nextLine();
        System.out.print("Enter your fitness level (Beginner, Intermediate, Advanced): ");
        String fitnessLevel = scanner.nextLine();
        System.out.print("Do you have any illnesses (e.g., High blood pressure, Joint issues, None)? ");
        String illnesses = scanner.nextLine();
        System.out.print("Do you have any surgeries (e.g., Minor surgeries, Surgeries in the past year, None)? ");
        String surgeries = scanner.nextLine();

        // Set user preferences
        user.setFitnessGoal(fitnessGoal);
        user.setFitnessLevel(fitnessLevel);
        user.setIllnesses(illnesses);
        user.setSurgeries(surgeries);

        // Retrieve matching fitness plans
        List<FitnessPlan> matchedPlans = planMatcher.matchPlans(user);
        System.out.println("\nRecommended Fitness Plans:");
        if (matchedPlans.isEmpty()) {
            System.out.println("No matching fitness plans found for your preferences.");
        } else {
            for (FitnessPlan plan : matchedPlans) {
                System.out.println(plan);
            }
        }

        scanner.close();
    }

    // Helper method to get input from the user
    private static String getInput(Scanner scanner, String inputName) {
        System.out.print("Enter " + inputName + ": ");
        return scanner.nextLine().trim();
    }
}
