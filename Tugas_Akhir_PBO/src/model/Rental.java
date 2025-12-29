package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Rental extends BaseModel {
    private int customerId, vehicleId;
    private LocalDate startDate, endDate;
    private BigDecimal totalPrice;
    private String status; // ACTIVE, COMPLETED, CANCELLED

    public Rental() {
    }

    public Rental(int id, int customerId, int vehicleId, LocalDate startDate, LocalDate endDate, BigDecimal totalPrice,
            String status) {
        this.id = id;
        this.customerId = customerId;
        this.vehicleId = vehicleId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getInfo() {
        return "Rental: ID " + getId() + ", Customer " + customerId + ", Vehicle " + vehicleId;
    }
}