// Vehicle.java
public class Vehicle {
    private int vehicleId;
    private String jenis;
    private String merk;
    private String model;
    private int tahun;
    private double hargaSewaPerHari;
    private String status;

    public Vehicle(int vehicleId, String jenis, String merk, String model, int tahun, double hargaSewaPerHari, String status) {
        this.vehicleId = vehicleId;
        this.jenis = jenis;
        this.merk = merk;
        this.model = model;
        this.tahun = tahun;
        this.hargaSewaPerHari = hargaSewaPerHari;
        this.status = status;
    }

    public int getVehicleId() { return vehicleId; }
    public String getJenis() { return jenis; }
    public String getMerk() { return merk; }
    public String getModel() { return model; }
    public int getTahun() { return tahun; }
    public double getHargaSewaPerHari() { return hargaSewaPerHari; }
    public String getStatus() { return status; }
}
