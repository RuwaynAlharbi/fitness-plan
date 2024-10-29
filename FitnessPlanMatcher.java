// src/FitnessPlanMatcher.java

import java.util.ArrayList;
import java.util.List;

public class FitnessPlanMatcher {
    private List<FitnessPlan> plans;

    public FitnessPlanMatcher() {
        this.plans = new ArrayList<>();
        loadPlans(); // Initialize with predefined plans
    }

    // Predefined fitness plans
    private void loadPlans() {
        plans.add(new FitnessPlan("Cardio", 150, "Beginner", "Weight Loss"));
        plans.add(new FitnessPlan("Strength Training", 120, "Intermediate", "Muscle Building"));
        plans.add(new FitnessPlan("Flexibility", 90, "Beginner", "Improve Flexibility"));
        plans.add(new FitnessPlan("Yoga", 120, "Beginner", "Stress Relief"));
    }

    // Match plans based on user preferences
    public List<FitnessPlan> matchPlans(User user) {
        if (user == null) {
            System.out.println("Access denied: User not authenticated.");
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
