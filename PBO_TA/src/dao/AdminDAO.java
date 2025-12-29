package dao;

import db.DatabaseConnection;

import java.sql.*;

public class AdminDAO {
    public boolean login(String username, String password) throws SQLException {
        String sql = "SELECT password_hash FROM admin WHERE username=?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String stored = rs.getString("password_hash");
                    return stored.equals(password); // DEMO: gunakan hashing di produksi
                }
                return false;
            }
        }
    }
}