// src/User.java

public class User {
    private String username;
    private String password;
    private String fitnessGoal;
    private String fitnessLevel;
    private String medicalHistory;
    private String role;

    // Constructor with role validation
    public User(String username, String password, String fitnessGoal, String fitnessLevel, String medicalHistory, String role) {
        this.username = username;
        this.password = password;
        this.fitnessGoal = fitnessGoal;
        this.fitnessLevel = fitnessLevel;
        this.medicalHistory = medicalHistory;
        setRole(role); // Validate role
    }

    // Method to enforce valid role assignment (only Member)
    private void setRole(String role) {
        if (!"Member".equalsIgnoreCase(role)) {
            throw new IllegalArgumentException("Invalid role: Only 'Member' role is allowed");
        }
        this.role = role;
    }

    // Getters
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getFitnessGoal() { return fitnessGoal; }
    public String getFitnessLevel() { return fitnessLevel; }
    public String getMedicalHistory() { return medicalHistory; }
    public String getRole() { return role; }
}
