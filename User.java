public class User {
    // خصائص المستخدم المحدودة لضمان مبدأ الأقل امتيازًا (Least Privilege)
    private String username;
    private String password;
    private String fitnessGoal;
    private String fitnessLevel;
    private String medicalHistory;
    private String role;

    // المُنشئ الرئيسي لإعداد جميع الخصائص وضمان دور 'Member' فقط
    public User(String username, String password, String fitnessGoal, String fitnessLevel, String medicalHistory) {
        this.username = username;
        this.password = password;
        this.fitnessGoal = fitnessGoal;
        this.fitnessLevel = fitnessLevel;
        this.medicalHistory = medicalHistory;
        this.role = "Member"; // تعيين دور 'Member' مباشرةً
    }

    // دوال Getter للبيانات الأساسية فقط (Least Privilege)
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getFitnessGoal() { return fitnessGoal; }
    public String getFitnessLevel() { return fitnessLevel; }
    public String getRole() { return role; }
}
