package model;

import java.math.BigDecimal;

public class Vehicle extends BaseModel {
    private String plateNumber, brand, model;
    private Integer year;
    private BigDecimal dailyRate;
    private String status; // AVAILABLE, RENTED, MAINTENANCE

    public Vehicle() {
    }

    public Vehicle(int id, String plateNumber, String brand, String model, Integer year, BigDecimal dailyRate,
            String status) {
        this.id = id;
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.dailyRate = dailyRate;
        this.status = status;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public BigDecimal getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(BigDecimal dailyRate) {
        this.dailyRate = dailyRate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getInfo() {
        return "Vehicle: " + brand + " " + model + " (" + plateNumber + ")";
    }
}