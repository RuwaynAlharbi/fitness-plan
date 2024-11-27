import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class AuthenticationService {
    private Map<String, User> users;

    public AuthenticationService() {
        users = new HashMap<>();
        seedDefaultUsers(); // Initialize with default users for testing
    }

    // Seed default users for testing
    private void seedDefaultUsers() {
        users.put("member1", new User("member1", hashPassword("Password@123"), "Weight Loss", "Beginner", "Member", 25, "None", "None"));
    }

    // Helper method to hash passwords
    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace(); // Handle the exception appropriately
            return null;
        }
    }

    // User sign-up with hashed password and additional attributes
    public boolean signup(String username, String password, String role, int age, String illnesses, String surgeries) {
        if (users.containsKey(username)) {
            System.out.println("Username already exists.");
            return false;
        }

        // Validate password strength
        if (!isValidPassword(password)) {
            System.out.println("Password must be at least 8 characters, include uppercase, lowercase, and a special character.");
            return false;
        }
        // Hash the password and create a new user
        String hashedPassword = hashPassword(password);
        if (hashedPassword != null) {
            User newUser = new User(username, hashedPassword, null, null, role, age, illnesses, surgeries);
            users.put(username, newUser);
            System.out.println("Signup successful.");
            return true;
        }
        return false;
    }

    // User login with password verification
    public User login(String username, String password) {
        String hashedPassword = hashPassword(password);
        if (hashedPassword != null && users.containsKey(username) && users.get(username).getPassword().equals(hashedPassword)) {
            System.out.println("Login successful.");
            return users.get(username);
        } else {
            System.out.println("Invalid credentials.");
            return null;
        }
    }

    // Validate password strength
    private boolean isValidPassword(String password) {
        return password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&  // At least one uppercase letter
                password.matches(".*[a-z].*") &&  // At least one lowercase letter
                password.matches(".*[!@#$%^&*()].*"); // At least one special character
    }

    // Helper method to get integer input from the user
    private int getIntInput(String prompt) {
        try {
            System.out.print(prompt);
            return Integer.parseInt(System.console().readLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            return getIntInput(prompt);
        }
    }

    // Helper method to get string input from the user
    private String getStringInput(String prompt) {
        System.out.print(prompt);
        return System.console().readLine().trim();
    }
}
