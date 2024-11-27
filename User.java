public class User {
    // User attributes, restricted for encapsulation (Least Privilege principle)
    private String username;
    private String password;
    private FitnessPlan.FitnessGoal fitnessGoal;
    private FitnessPlan.FitnessLevel fitnessLevel;
    private String role;
    private int age=0; // New attribute
    private String illnesses; // New attribute
    private String surgeries; // New attribute

    /**
     * Constructor to initialize all user attributes.
     * Sets the role to "Member" by default.
     */
    public User(String username, String password, FitnessPlan.FitnessGoal fitnessGoal, FitnessPlan.FitnessLevel fitnessLevel, int age, String illnesses, String surgeries) {
        this.username = username;
        this.password = password;
        this.fitnessGoal = fitnessGoal;
        this.fitnessLevel = fitnessLevel;
        this.role = "Member"; // Default role
        this.age = age;
        this.illnesses = illnesses;
        this.surgeries = surgeries;
    }

    /**
     * Constructor to initialize user attributes with a specified role.
     */
    public User(String username, String password, FitnessPlan.FitnessGoal fitnessGoal, FitnessPlan.FitnessLevel fitnessLevel, String role, int age, String illnesses, String surgeries) {
        this.username = username;
        this.password = password;
        this.fitnessGoal = fitnessGoal;
        this.fitnessLevel = fitnessLevel;
        this.role = role;
        this.age = age;
        this.illnesses = illnesses;
        this.surgeries = surgeries;
    }

    // Getters for essential user data (Least Privilege)
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public FitnessPlan.FitnessGoal getFitnessGoal() {
        return fitnessGoal;
    }

    public FitnessPlan.FitnessLevel getFitnessLevel() {
        return fitnessLevel;
    }

    public String getRole() {
        return role;
    }

    public int getAge() {
        return age;
    }

    public String getIllnesses() {
        return illnesses;
    }

    public String getSurgeries() {
        return surgeries;
    }

    public void setFitnessGoal(FitnessPlan.FitnessGoal fitnessGoal) {
        this.fitnessGoal = fitnessGoal;
    }

    public void setFitnessLevel(FitnessPlan.FitnessLevel fitnessLevel) {
        this.fitnessLevel = fitnessLevel;
    }

    public void setIllnesses(String illnesses) {
        this.illnesses = illnesses;
    }

    public void setSurgeries(String surgeries) {
        this.surgeries = surgeries;
    }
}
