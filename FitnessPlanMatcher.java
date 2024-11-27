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
        plans.add(new FitnessPlan("Cardio", 150, "Beginner", "Weight Loss", 18, 60, "None", "None"));
        plans.add(new FitnessPlan("Yoga", 120, "Beginner", "Stress Relief", 18, 70, "None", "None"));
        plans.add(new FitnessPlan("Flexibility", 90, "Beginner", "Improve Flexibility", 18, 65, "None", "None"));
        plans.add(new FitnessPlan("Walking", 180, "Beginner", "Weight Loss", 18, 80, "None", "None"));

        // Intermediate-level plans
        plans.add(new FitnessPlan("Strength Training", 120, "Intermediate", "Muscle Building", 18, 50, "None", "None"));
        plans.add(new FitnessPlan("HIIT", 90, "Intermediate", "Weight Loss", 18, 45, "High blood pressure", "None"));
        plans.add(new FitnessPlan("Cycling", 150, "Intermediate", "Stress Relief", 18, 70, "None", "None"));

        // Advanced-level plans
        plans.add(new FitnessPlan("CrossFit", 180, "Advanced", "Muscle Building", 18, 40, "None", "None"));
        plans.add(new FitnessPlan("Marathon Training", 240, "Advanced", "Weight Loss", 18, 35, "None", "None"));
        plans.add(new FitnessPlan("Power Yoga", 150, "Advanced", "Stress Relief", 18, 60, "None", "None"));

        // Special plans for older users or those with illnesses/surgeries
        plans.add(new FitnessPlan("Light Yoga", 90, "Beginner", "Stress Relief", 60, 100, "High blood pressure", "Minor surgeries"));
        plans.add(new FitnessPlan("Rehabilitation Swimming", 120, "Beginner", "Improve Flexibility", 50, 100, "Joint issues", "Surgeries in past year"));
    }

    // Match plans based on user preferences, including age, illnesses, and surgeries
    public List<FitnessPlan> matchPlans(User user) {
        if (user == null || !"Member".equalsIgnoreCase(user.getRole())) {
            System.out.println("Access denied: User not authenticated or lacks permission.");
            return new ArrayList<>();
        }

        List<FitnessPlan> matchedPlans = new ArrayList<>();
        for (FitnessPlan plan : plans) {
            if (plan.getHealthGoal().equalsIgnoreCase(user.getFitnessGoal()) &&
                    plan.getRequiredLevel().equalsIgnoreCase(user.getFitnessLevel()) &&
                    user.getAge() >= plan.getMinAge() && user.getAge() <= plan.getMaxAge() &&
                    (plan.getIllnesses() == null || plan.getIllnesses().equalsIgnoreCase(user.getIllnesses())) &&
                    (plan.getSurgeries() == null || plan.getSurgeries().equalsIgnoreCase(user.getSurgeries()))) {
                matchedPlans.add(plan);
            }
        }
        return matchedPlans;
    }
}
