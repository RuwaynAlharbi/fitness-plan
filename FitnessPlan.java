public class FitnessPlan {
    private String category;
    private int minDuration= 120; // in minutes
    private FitnessLevel requiredLevel;
    private FitnessGoal fitnessGoal;
    private int minAge; // New attribute
    private int maxAge; // New attribute
    private String illnesses; // New attribute (specific illnesses the plan accommodates)
    private String surgeries; // New attribute (specific surgeries the plan accommodates)


    public enum FitnessLevel{
        Beginner, Intermediate, Advanced
    }

    public enum FitnessGoal{
        Weight_Loss, Muscle_Building, Improve_Flexibility, Stress_Relief
    }

    // Constructor to initialize FitnessPlan attributes
    public FitnessPlan(String category, int minDuration, FitnessLevel requiredLevel, FitnessGoal fitnessGoal, int minAge, int maxAge, String illnesses, String surgeries) {

        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Category cannot be null or empty.");
        }
        if (requiredLevel == null) {
            throw new IllegalArgumentException("Required level cannot be null.");
        }
        if (fitnessGoal == null) {
            throw new IllegalArgumentException("Health goal cannot be null.");
        }

        this.category = category;
        this.minDuration = minDuration;
        this.requiredLevel = requiredLevel;
        this.fitnessGoal = fitnessGoal;
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

    public FitnessLevel getRequiredLevel() {
        return requiredLevel;
    }

    public FitnessGoal getHealthGoal() {
        return fitnessGoal;
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
                category, fitnessGoal, requiredLevel, minDuration, minAge, maxAge,
                illnesses == null ? "None" : illnesses, surgeries == null ? "None" : surgeries);
    }
}
