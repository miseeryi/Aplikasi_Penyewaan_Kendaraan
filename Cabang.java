import java.util.*;

class Cabang {
    private String nama;
    private List<Kendaraan> daftarKendaraan = new ArrayList<>();

    public Cabang(String nama) { this.nama = nama; }
    public void tambah(Kendaraan k) { daftarKendaraan.add(k); }

    // Overloading (compile-time polymorphism)
    public List<Kendaraan> cari(String merek) {
        return filter(merek, Integer.MIN_VALUE, Double.MAX_VALUE);
    }
    public List<Kendaraan> cari(String merek, int minTahun) {
        return filter(merek, minTahun, Double.MAX_VALUE);
    }
    public List<Kendaraan> cari(String merek, int minTahun, double maxTarif) {
        return filter(merek, minTahun, maxTarif);
    }

    private List<Kendaraan> filter(String merek, int minTahun, double maxTarif) {
        List<Kendaraan> out = new ArrayList<>();
        for (Kendaraan k : daftarKendaraan) {
            if (k.merek.equalsIgnoreCase(merek) && k.tahun >= minTahun && k.tarifHarian <= maxTarif) {
                out.add(k);
            }
        }
        return out;
    }

    // ======== MAIN PROGRAM (dinamis) ========
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cabang cb = new Cabang("Jakarta Pusat");

        // Tambahkan kendaraan contoh
        Kendaraan m1 = new Mobil("C1", "Toyota", "Avanza", 2022, 250000, true);
        Kendaraan m2 = new Mobil("C2", "Toyota", "Agya", 2021, 200000, false);
        Kendaraan e1 = new MobilListrik("E1", "Hyundai", "Ioniq5", 2023, 400000, true, 50000);
        cb.tambah(m1); cb.tambah(m2); cb.tambah(e1);

        System.out.println("=== SISTEM PENYEWAAN MOBIL DINAMIS ===");
        System.out.print("Masukkan merek mobil yang ingin disewa: ");
        String merek = sc.nextLine();

        List<Kendaraan> hasil = cb.cari(merek);
        if (hasil.isEmpty()) {
            System.out.println("Mobil dengan merek tersebut tidak tersedia.");
            return;
        }

        System.out.println("\nDaftar mobil merek " + merek + ":");
        for (int i = 0; i < hasil.size(); i++) {
            System.out.println((i + 1) + ". " + hasil.get(i));
        }

        System.out.print("\nPilih nomor mobil yang ingin disewa: ");
        int pilih = sc.nextInt();
        Kendaraan dipilih = hasil.get(pilih - 1);

        System.out.print("Berapa hari disewa: ");
        int hari = sc.nextInt();

        double total = dipilih.hitungBiayaSewa(hari);
        System.out.println("\nMobil disewa: " + dipilih);
        System.out.println("Total biaya sewa " + hari + " hari = Rp" + total);
    }
}
