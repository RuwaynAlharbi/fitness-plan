public class FitnessPlan {
    private String category;
    private int minDuration; // in minutes
    private String requiredLevel;
    private String healthGoal;

    // Constructor to initialize FitnessPlan attributes
    public FitnessPlan(String category, int minDuration, String requiredLevel, String healthGoal) {
        if (minDuration <= 0) {
            throw new IllegalArgumentException("Minimum duration must be positive.");
        }
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Category cannot be null or empty.");
        }
        if (requiredLevel == null) {
            throw new IllegalArgumentException("Required level cannot be null.");
        }
        if (healthGoal == null) {
            throw new IllegalArgumentException("Health goal cannot be null.");
        }

        this.category = category;
        this.minDuration = minDuration;
        this.requiredLevel = requiredLevel;
        this.healthGoal = healthGoal;
    }

    // Getters for accessing private fields
    public String getCategory() {
        return category;
    }

    public int getMinDuration() {
        return minDuration;
    }

    public String getRequiredLevel() {
        return requiredLevel;
    }

    public String getHealthGoal() {
        return healthGoal;
    }

    // Override toString for formatted display
    @Override
    public String toString() {
        return String.format("%s Plan (%s, %s level): %d minutes/week", category, healthGoal, requiredLevel, minDuration);
    }
}
