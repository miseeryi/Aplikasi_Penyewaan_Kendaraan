class MobilListrik extends Mobil {
    private double biayaChargerPerHari;

    public MobilListrik(String id, String merek, String model, int tahun, double tarifHarian,
                        boolean otomatis, double biayaChargerPerHari) {
        super(id, merek, model, tahun, tarifHarian, otomatis);
        this.biayaChargerPerHari = biayaChargerPerHari;
    }

    @Override
    public double hitungBiayaSewa(int hari) {
        return super.hitungBiayaSewa(hari) + biayaChargerPerHari * hari;
    }
}
