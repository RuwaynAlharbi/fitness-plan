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
        plans.add(new FitnessPlan("Cardio", 150, FitnessPlan.FitnessLevel.Beginner, FitnessPlan.FitnessGoal.Weight_Loss, 18, 60, "None", "None"));
        plans.add(new FitnessPlan("Yoga", 150, FitnessPlan.FitnessLevel.Beginner, FitnessPlan.FitnessGoal.Stress_Relief, 18, 70, "None", "None"));
        plans.add(new FitnessPlan("Flexibility", 150, FitnessPlan.FitnessLevel.Beginner, FitnessPlan.FitnessGoal.Improve_Flexibility, 18, 65, "None", "None"));
        plans.add(new FitnessPlan("Walking", 150, FitnessPlan.FitnessLevel.Beginner, FitnessPlan.FitnessGoal.Weight_Loss, 18, 80, "None", "None"));

        // Intermediate-level plans
        plans.add(new FitnessPlan("Strength Training", 140, FitnessPlan.FitnessLevel.Intermediate, FitnessPlan.FitnessGoal.Muscle_Building, 18, 50, "None", "None"));
        plans.add(new FitnessPlan("HIIT", 140,FitnessPlan.FitnessLevel.Intermediate, FitnessPlan.FitnessGoal.Weight_Loss, 18, 45, "High blood pressure", "None"));
        plans.add(new FitnessPlan("Cycling", 140, FitnessPlan.FitnessLevel.Intermediate, FitnessPlan.FitnessGoal.Stress_Relief, 18, 70, "None", "None"));

        // Advanced-level plans
        plans.add(new FitnessPlan("CrossFit", 130, FitnessPlan.FitnessLevel.Advanced, FitnessPlan.FitnessGoal.Muscle_Building, 18, 40, "None", "None"));
        plans.add(new FitnessPlan("Marathon Training", 130, FitnessPlan.FitnessLevel.Advanced, FitnessPlan.FitnessGoal.Weight_Loss, 18, 35, "None", "None"));
        plans.add(new FitnessPlan("Power Yoga", 130, FitnessPlan.FitnessLevel.Advanced, FitnessPlan.FitnessGoal.Stress_Relief, 18, 60, "None", "None"));

        // Special plans for older users or those with illnesses/surgeries
        plans.add(new FitnessPlan("Light Yoga", 150, FitnessPlan.FitnessLevel.Beginner, FitnessPlan.FitnessGoal.Stress_Relief, 60, 100, "High blood pressure", "Minor surgeries"));
        plans.add(new FitnessPlan("Rehabilitation Swimming", 150, FitnessPlan.FitnessLevel.Beginner, FitnessPlan.FitnessGoal.Improve_Flexibility, 50, 100, "Joint issues", "Surgeries in past year"));
    }

    // Match plans based on user preferences, including age, illnesses, and surgeries
    public List<FitnessPlan> matchPlans(User user) {
        if (user == null || !"Member".equalsIgnoreCase(user.getRole())) {
            System.out.println("Access denied: User not authenticated or lacks permission.");
            return new ArrayList<>();
        }

        List<FitnessPlan> matchedPlans = new ArrayList<>();
        for (FitnessPlan plan : plans) {
            if ((plan.getHealthGoal()==user.getFitnessGoal()) &&
                    (plan.getRequiredLevel()==user.getFitnessLevel()) &&
                    user.getAge() >= plan.getMinAge() && user.getAge() <= plan.getMaxAge() &&
                    (plan.getIllnesses() == null || plan.getIllnesses().equalsIgnoreCase(user.getIllnesses())) &&
                    (plan.getSurgeries() == null || plan.getSurgeries().equalsIgnoreCase(user.getSurgeries()))) {
                matchedPlans.add(plan);
            }
        }
        return matchedPlans;
    }
}
