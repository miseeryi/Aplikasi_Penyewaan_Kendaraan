// Main.java
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Buat customer
        Customer c1 = new Customer(1, "Budi", "Jl. Malioboro", "08123456789", "budi@gmail.com");

        // Buat vehicle
        Vehicle v1 = new Vehicle(101, "Mobil", "Toyota", "Avanza", 2020, 300000, "Tersedia");

        // Buat rental
        Rental r1 = new Rental(1001, c1, v1, LocalDate.of(2025, 11, 28), LocalDate.of(2025, 11, 30), 600000);

        // Output
        System.out.println("Rental ID: " + r1.getRentalId());
        System.out.println("Customer: " + r1.getCustomer().getNama());
        System.out.println("Vehicle: " + r1.getVehicle().getMerk() + " " + r1.getVehicle().getModel());
        System.out.println("Tanggal: " + r1.getTanggalMulai() + " s/d " + r1.getTanggalSelesai());
        System.out.println("Total Harga: Rp" + r1.getTotalHarga());
    }
}
