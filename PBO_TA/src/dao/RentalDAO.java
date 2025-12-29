package dao;

import db.DatabaseConnection;
import model.Rental;

import java.sql.*;
import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

public class RentalDAO {
    public boolean createRental(int customerId, int vehicleId, LocalDate start, LocalDate end, BigDecimal dailyRate) throws SQLException {
        if (!isVehicleAvailable(vehicleId)) return false;

        BigDecimal days = BigDecimal.valueOf(ChronoUnit.DAYS.between(start, end));
        BigDecimal total = dailyRate.multiply(days);

        String insert = "INSERT INTO rental(customer_id, vehicle_id, start_date, end_date, total_price, status) VALUES (?,?,?,?,?, 'ACTIVE')";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(insert)) {
            ps.setInt(1, customerId);
            ps.setInt(2, vehicleId);
            ps.setDate(3, Date.valueOf(start));
            ps.setDate(4, Date.valueOf(end));
            ps.setBigDecimal(5, total);
            ps.executeUpdate();
        }

        new VehicleDAO().updateStatus(vehicleId, "RENTED");
        return true;
    }

    public void completeRental(int rentalId, int vehicleId) throws SQLException {
        String sql = "UPDATE rental SET status='COMPLETED' WHERE id=?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, rentalId);
            ps.executeUpdate();
        }
        new VehicleDAO().updateStatus(vehicleId, "AVAILABLE");
    }

    public boolean isVehicleAvailable(int vehicleId) throws SQLException {
        String sql = "SELECT status FROM vehicle WHERE id=?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, vehicleId);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() && "AVAILABLE".equals(rs.getString("status"));
            }
        }
    }
}