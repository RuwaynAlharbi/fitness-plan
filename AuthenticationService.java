/*import java.util.HashMap;
import java.util.Map;

public class AuthenticationService {
    // تخزين بيانات المستخدمين مع تطبيق (Encapsulation) لمنع التلاعب المباشر
    private Map<String, User> users;

    public AuthenticationService() {
        users = new HashMap<>();
        seedDefaultUsers();
    }

    // إضافة مستخدمين افتراضيين لاختبار النظام
    private void seedDefaultUsers() {
        users.put("member1", new User("member1", "Password@123", "Weight Loss", "Beginner", null));
    }

    // التسجيل مع التحقق من صلاحية كلمة المرور وفق مبدأ Simplicity of Design
    public boolean signup(String username, String password) {
        if (users.containsKey(username)) {
            System.out.println("Username already exists.");
            return false;
        }
        
        // التحقق من قوة كلمة المرور
        if (!isValidPassword(password)) {
            System.out.println("Password must be at least 8 characters, include uppercase, lowercase, and a special character.");
            return false;
        }

        // إنشاء مستخدم جديد مع الصلاحيات المحدودة
        User newUser = new User(username, password, null, null, null);
        users.put(username, newUser);
        System.out.println("Signup successful.");
        return true;
    }

    // التحقق من صحة بيانات المستخدم عند تسجيل الدخول وفق مبدأ Fail-Safe Defaults
    public User login(String username, String password) {
        if (users.containsKey(username) && users.get(username).getPassword().equals(password)) {
            System.out.println("Login successful.");
            return users.get(username);
        } else {
            System.out.println("Invalid credentials. Please try again.");
            return null; // العودة إلى القيمة الافتراضية عند فشل التحقق
        }
    }

    // التحقق من متطلبات كلمة المرور لزيادة الأمان (Defense-in-Depth)
    private boolean isValidPassword(String password) {
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&  // حرف كبير
               password.matches(".*[a-z].*") &&  // حرف صغير
               password.matches(".*[!@#$%^&*()].*"); // رمز خاص
    }
}
*/



//دا بداية الكود الي عدلته بشرى 
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
        users.put("member1", new User("member1", "password123", null, null, null, "Member"));
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

    // User sign-up with hashed password
public boolean signup(String username, String password, String role) {
    if (users.containsKey(username)) {
        System.out.println("Username already exists.");
        return false;
    }

    try {
        String hashedPassword = hashPassword(password);
        if (hashedPassword != null) {
            User newUser = new User(username, hashedPassword, null, null, null, role);
            users.put(username, newUser);
            System.out.println("Signup successful. Hashed Password: " + hashedPassword);
            return true;
        }
    } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
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
}
