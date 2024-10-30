import java.util.List;
import java.util.Scanner;

public class FitnessRecommendationSystem {
    public static void main(String[] args) {
        AuthenticationService authService = new AuthenticationService();
        FitnessPlanMatcher planMatcher = new FitnessPlanMatcher();
        Scanner scanner = new Scanner(System.in);
        User user = null;

        // خيارات تسجيل الدخول أو التسجيل
        while (user == null) {
            System.out.println("Welcome! Please choose an option:\n1. Sign Up\n2. Login");
            String option = scanner.nextLine();

            if ("1".equals(option)) {
                System.out.print("Enter a new username: ");
                String username = scanner.nextLine();
                System.out.print("Enter a password (at least 8 characters, including uppercase, lowercase, and a special character): ");
                String password = scanner.nextLine();
                authService.signup(username, password);
            } else if ("2".equals(option)) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                user = authService.login(username, password);
            } else {
                System.out.println("Invalid option, please choose 1 or 2.");
            }
        }

        // جمع تفضيلات اللياقة من المستخدم
        System.out.print("Enter your primary fitness goal (e.g., Weight Loss, Muscle Building): ");
        String fitnessGoal = scanner.nextLine();
        System.out.print("Enter your fitness level (Beginner, Intermediate, Advanced): ");
        String fitnessLevel = scanner.nextLine();

        // إعداد مستخدم مخصص وفق التفضيلات
        user = new User(user.getUsername(), user.getPassword(), fitnessGoal, fitnessLevel, null);

        // عرض الخطط المناسبة
        List<FitnessPlan> matchedPlans = planMatcher.matchPlans(user);
        System.out.println("\nRecommended Fitness Plans:");
        if (matchedPlans.isEmpty()) {
            System.out.println("No matching fitness plans found for your preferences.");
        } else {
            System.out.printf("%-20s %-15s %-10s %-15s\n", "Category", "Health Goal", "Level", "Duration");
            for (FitnessPlan plan : matchedPlans) {
                System.out.printf("%-20s %-15s %-10s %-15d\n", plan.getCategory(), plan.getHealthGoal(), plan.getRequiredLevel(), plan.getMinDuration());
            }
        }

        scanner.close();
    }
}
