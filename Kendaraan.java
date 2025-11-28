abstract class Kendaraan {
    protected String id, merek, model;
    protected int tahun;
    protected double tarifHarian;
    protected String status = "TERSEDIA";

    public Kendaraan(String id, String merek, String model, int tahun, double tarifHarian) {
        this.id = id; this.merek = merek; this.model = model;
        this.tahun = tahun; this.tarifHarian = tarifHarian;
    }

    public void tandaiTersedia() { status = "TERSEDIA"; }
    public void tandaiDisewa()   { status = "DISEWA"; }

    public double hitungBiayaSewa(int hari) {
        return tarifHarian * hari;
    }

    @Override
    public String toString() {
        return merek + " " + model + " (" + tahun + ") - " + status + " - Rp" + tarifHarian + "/hari";
    }
}
