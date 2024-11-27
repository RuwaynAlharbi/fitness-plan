/*
//define possible fitness levels
public enum FitnessLevel {
    BEGINNER, INTERMEDIATE, ADVANCED
}

//define possible health goals
public enum HealthGoal {
    WEIGHT_LOSS, MUSCLE_BUILDING, IMPROVE_FLEXIBILITY, STRESS_RELIEF
}

public class FitnessPlan {
    private final String category;
    private final int minDuration; // in minutes
    private final FitnessLevel requiredLevel;
    private final HealthGoal healthGoal;

    // Constructor
    public FitnessPlan(String category, int minDuration, FitnessLevel requiredLevel, HealthGoal healthGoal) {
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

    // Getters
    public String getCategory() { return category; }
    public int getMinDuration() { return minDuration; }
    public FitnessLevel getRequiredLevel() { return requiredLevel; }
    public HealthGoal getHealthGoal() { return healthGoal; }

    @Override
    public String toString() {
        return String.format("%s Plan (%s, %s level): %d minutes/week", category, healthGoal, requiredLevel, minDuration);
    }
}
