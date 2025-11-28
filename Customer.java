// Customer.java
public class Customer {
    private int customerId;
    private String nama;
    private String alamat;
    private String noHp;
    private String email;

    // Constructor
    public Customer(int customerId, String nama, String alamat, String noHp, String email) {
        this.customerId = customerId;
        this.nama = nama;
        this.alamat = alamat;
        this.noHp = noHp;
        this.email = email;
    }

    // Getter & Setter
    public int getCustomerId() { return customerId; }
    public String getNama() { return nama; }
    public String getAlamat() { return alamat; }
    public String getNoHp() { return noHp; }
    public String getEmail() { return email; }
}