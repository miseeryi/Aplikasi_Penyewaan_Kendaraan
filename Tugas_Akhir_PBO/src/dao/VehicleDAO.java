package dao;

import db.DatabaseConnection;
import model.Vehicle;

import java.sql.*;
import java.util.*;
import java.math.BigDecimal;

public class VehicleDAO {
    public void insert(Vehicle v) throws SQLException {
        String sql = "INSERT INTO vehicle(plate_number, brand, model, year, daily_rate, status) VALUES (?,?,?,?,?,?)";
        try (Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, v.getPlateNumber());
            ps.setString(2, v.getBrand());
            ps.setString(3, v.getModel());
            if (v.getYear() == null)
                ps.setNull(4, Types.INTEGER);
            else
                ps.setInt(4, v.getYear());
            ps.setBigDecimal(5, v.getDailyRate());
            ps.setString(6, v.getStatus());
            ps.executeUpdate();
        }
    }

    public List<Vehicle> getAvailable() throws SQLException {
        String sql = "SELECT * FROM vehicle WHERE status='AVAILABLE'";
        try (Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            List<Vehicle> list = new ArrayList<>();
            while (rs.next()) {
                Vehicle v = new Vehicle();
                v.setId(rs.getInt("id"));
                v.setPlateNumber(rs.getString("plate_number"));
                v.setBrand(rs.getString("brand"));
                v.setModel(rs.getString("model"));
                v.setYear((Integer) rs.getObject("year"));
                v.setDailyRate(rs.getBigDecimal("daily_rate"));
                v.setStatus(rs.getString("status"));
                list.add(v);
            }
            return list;
        }
    }

    public List<Vehicle> getAll() throws SQLException {
        String sql = "SELECT * FROM vehicle";
        try (Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            List<Vehicle> list = new ArrayList<>();
            while (rs.next()) {
                Vehicle v = new Vehicle();
                v.setId(rs.getInt("id"));
                v.setPlateNumber(rs.getString("plate_number"));
                v.setBrand(rs.getString("brand"));
                v.setModel(rs.getString("model"));
                v.setYear((Integer) rs.getObject("year"));
                v.setDailyRate(rs.getBigDecimal("daily_rate"));
                v.setStatus(rs.getString("status"));
                list.add(v);
            }
            return list;
        }
    }

    public void updateStatus(int vehicleId, String status) throws SQLException {
        String sql = "UPDATE vehicle SET status=? WHERE id=?";
        try (Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, vehicleId);
            ps.executeUpdate();
        }
    }
}