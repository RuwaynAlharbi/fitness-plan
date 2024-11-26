import java.util.ArrayList;
import java.util.List;

public class FitnessPlanMatcher {
    private List<FitnessPlan> plans;

    public FitnessPlanMatcher() {
        this.plans = new ArrayList<>();
        loadPlans();
    }

    // Load default fitness plans
    private void loadPlans() {
        // Beginner-level plans
        plans.add(new FitnessPlan("Cardio", 150, "Beginner", "Weight Loss"));

        /* to make the matchedPlans.isEmpty() condition work
        plans.add(new FitnessPlan("Yoga", 120, "Beginner", "Stress Relief"));*/

        plans.add(new FitnessPlan("Flexibility", 90, "Beginner", "Improve Flexibility"));
        plans.add(new FitnessPlan("Walking", 180, "Beginner", "Weight Loss"));

        // Intermediate-level plans
        plans.add(new FitnessPlan("Strength Training", 120, "Intermediate", "Muscle Building"));

        /* to make the matchedPlans.isEmpty() condition work
        plans.add(new FitnessPlan("HIIT", 90, "Intermediate", "Weight Loss"));*/

        plans.add(new FitnessPlan("Pilates", 120, "Intermediate", "Improve Flexibility"));
        plans.add(new FitnessPlan("Cycling", 150, "Intermediate", "Stress Relief"));

        // Advanced-level plans
        plans.add(new FitnessPlan("CrossFit", 180, "Advanced", "Muscle Building"));
        plans.add(new FitnessPlan("Marathon Training", 240, "Advanced", "Weight Loss"));
        plans.add(new FitnessPlan("Power Yoga", 150, "Advanced", "Stress Relief"));
        plans.add(new FitnessPlan("Advanced Strength Training", 180, "Advanced", "Muscle Building"));

        // General plans across levels
        plans.add(new FitnessPlan("Swimming", 150, "Beginner", "Stress Relief"));

        /* to make the matchedPlans.isEmpty() condition work
        plans.add(new FitnessPlan("Swimming", 180, "Intermediate", "Weight Loss"));*/

        plans.add(new FitnessPlan("Swimming", 200, "Advanced", "Muscle Building"));
        plans.add(new FitnessPlan("Dancing", 120, "Beginner", "Stress Relief"));
        plans.add(new FitnessPlan("Dancing", 150, "Intermediate", "Weight Loss"));
    }

    // Match plans based on user preferences
    public List<FitnessPlan> matchPlans(User user) {
        if (user == null || !"Member".equalsIgnoreCase(user.getRole())) {
            System.out.println("Access denied: User not authenticated or lacks permission.");
            return new ArrayList<>();
        }

        List<FitnessPlan> matchedPlans = new ArrayList<>();
        for (FitnessPlan plan : plans) {
            if (plan.getHealthGoal().equalsIgnoreCase(user.getFitnessGoal()) &&
                    plan.getRequiredLevel().equalsIgnoreCase(user.getFitnessLevel())) {
                matchedPlans.add(plan);
            }
        }
        return matchedPlans;
    }
}
