import java.util.HashMap;
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
