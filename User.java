public class User {
    // User attributes, restricted for encapsulation (Least Privilege principle)
    private String username;
    private String password;
    private String fitnessGoal;
    private String fitnessLevel;
    private String medicalHistory;
    private String role;

    /**
     * Constructor to initialize all user attributes.
     * Sets the role to "Member" by default.
     */
    public User(String username, String password, String fitnessGoal, String fitnessLevel, String medicalHistory) {
        this.username = username;
        this.password = password;
        this.fitnessGoal = fitnessGoal;
        this.fitnessLevel = fitnessLevel;
        this.medicalHistory = medicalHistory;
        this.role = "Member"; // Default role
    }

    /**
     * Constructor to initialize user attributes with a specified role.
     */
    public User(String username, String password, String fitnessGoal, String fitnessLevel, String medicalHistory, String role) {
        this.username = username;
        this.password = password;
        this.fitnessGoal = fitnessGoal;
        this.fitnessLevel = fitnessLevel;
        this.medicalHistory = medicalHistory;
        this.role = role;
    }

    // Getters for essential user data (Least Privilege)
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFitnessGoal() {
        return fitnessGoal;
    }

    public String getFitnessLevel() {
        return fitnessLevel;
    }

    public String getRole() {
        return role;
    }
}
