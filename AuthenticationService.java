// src/AuthenticationService.java

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
        users.put("member1", new User("member1", "password123", null, null, null, "Member"));
    }

    // User sign-up with role validation
    public boolean signup(String username, String password, String role) {
        if (users.containsKey(username)) {
            System.out.println("Username already exists.");
            return false;
        }

        try {
            User newUser = new User(username, password, null, null, null, role);
            users.put(username, newUser);
            System.out.println("Signup successful.");
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    // User login
    public User login(String username, String password) {
        if (users.containsKey(username) && users.get(username).getPassword().equals(password)) {
            System.out.println("Login successful.");
            return users.get(username);
        } else {
            System.out.println("Invalid credentials.");
            return null;
        }
    }
}
