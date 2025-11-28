import java.time.LocalDate;

public class Rental {
    private int rentalId;
    private Customer customer;
    private Vehicle vehicle;
    private LocalDate tanggalMulai;
    private LocalDate tanggalSelesai;
    private double totalHarga;

    public Rental(int rentalId, Customer customer, Vehicle vehicle, LocalDate tanggalMulai, LocalDate tanggalSelesai, double totalHarga) {
        this.rentalId = rentalId;
        this.customer = customer;
        this.vehicle = vehicle;
        this.tanggalMulai = tanggalMulai;
        this.tanggalSelesai = tanggalSelesai;
        this.totalHarga = totalHarga;
    }

    public int getRentalId() { return rentalId; }
    public Customer getCustomer() { return customer; }
    public Vehicle getVehicle() { return vehicle; }
    public LocalDate getTanggalMulai() { return tanggalMulai; }
    public LocalDate getTanggalSelesai() { return tanggalSelesai; }
    public double getTotalHarga() { return totalHarga; }
}

