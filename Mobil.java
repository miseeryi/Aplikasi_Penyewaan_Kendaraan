class Mobil extends Kendaraan {
    private boolean otomatis;

    public Mobil(String id, String merek, String model, int tahun, double tarifHarian, boolean otomatis) {
        super(id, merek, model, tahun, tarifHarian);
        this.otomatis = otomatis;
    }

    @Override
    public double hitungBiayaSewa(int hari) {
        double surchargeOtomatis = otomatis ? 30000.0 : 0.0;
        return (tarifHarian + surchargeOtomatis) * hari;
    }
}
