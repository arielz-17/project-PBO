public class KategoriLayanan implements Layanan {
    private String layanan;

    public KategoriLayanan(String layanan) {
        this.layanan = layanan;
    }

    @Override
    public void informasiLayanan() {
        System.out.println("Layanan: " + layanan);
    }
}
