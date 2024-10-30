public class FitnessPlan {
    private String category;
    private int minDuration;
    private String requiredLevel;
    private String healthGoal;

    // Constructor to initialize FitnessPlan attributes
    public FitnessPlan(String category, int minDuration, String requiredLevel, String healthGoal) {
        this.category = category;
        this.minDuration = minDuration;
        this.requiredLevel = requiredLevel;
        this.healthGoal = healthGoal;
    }

    // Getters for accessing private fields
    public String getCategory() { return category; }
    public int getMinDuration() { return minDuration; }
    public String getRequiredLevel() { return requiredLevel; }
    public String getHealthGoal() { return healthGoal; }

    // Override toString for formatted display
    @Override
    public String toString() {
        return category + " Plan (" + healthGoal + ", " + requiredLevel + " level): " + minDuration + " minutes/week";
    }
}
