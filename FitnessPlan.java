public class FitnessPlan {
    private String category;
    private int minDuration; // in minutes
    private String requiredLevel;
    private String healthGoal;
    private int minAge; // New attribute
    private int maxAge; // New attribute
    private String illnesses; // New attribute (specific illnesses the plan accommodates)
    private String surgeries; // New attribute (specific surgeries the plan accommodates)

    // Constructor to initialize FitnessPlan attributes
    public FitnessPlan(String category, int minDuration, String requiredLevel, String healthGoal, int minAge, int maxAge, String illnesses, String surgeries) {
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
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.illnesses = illnesses;
        this.surgeries = surgeries;
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

    public int getMinAge() {
        return minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public String getIllnesses() {
        return illnesses;
    }

    public String getSurgeries() {
        return surgeries;
    }

    // Override toString for formatted display
    @Override
    public String toString() {
        return String.format("%s Plan (%s, %s level): %d minutes/week, Age: %d-%d, Illnesses: %s, Surgeries: %s",
                category, healthGoal, requiredLevel, minDuration, minAge, maxAge,
                illnesses == null ? "None" : illnesses, surgeries == null ? "None" : surgeries);
    }
}
