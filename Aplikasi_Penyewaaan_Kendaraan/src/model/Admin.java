package model;

public class Admin extends BaseModel {
    private String username, passwordHash;

    public Admin() {
    }

    public Admin(int id, String username, String passwordHash) {
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Override
    public String getInfo() {
        return "Admin: " + username + " (ID: " + id + ")";
    }
}