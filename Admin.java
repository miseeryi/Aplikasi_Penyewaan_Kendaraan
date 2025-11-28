public class Admin {
    private int adminId;
    private String username;
    private String password;
    private String nama;
    private String email;
    private String role;

    public Admin(int adminId, String username, String password, String nama, String email, String role) {
        this.adminId = adminId;
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.email = email;
        this.role = role;
    }

    // Getter & Setter
    public int getAdminId() { return adminId; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getNama() { return nama; }
    public String getEmail() { return email; }
    public String getRole() { return role; }

    public void setPassword(String password) { this.password = password; }
    public void setRole(String role) { this.role = role; }

    // Method tambahan
    public void tampilkanInfo() {
        System.out.println("Admin ID: " + adminId);
        System.out.println("Nama: " + nama);
        System.out.println("Email: " + email);
        System.out.println("Role: " + role);
    }
}
