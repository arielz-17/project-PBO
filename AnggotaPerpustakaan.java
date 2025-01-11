public class BukuFiksi extends Buku {
    private String subKategori;

    public BukuFiksi(String judul, String pengarang, String isbn, String kategori, boolean tersedia, String subKategori) {
        super(judul, pengarang, isbn, kategori, tersedia);
        this.subKategori = subKategori;
    }

    public String getSubKategori() {
        return subKategori;
    }

    public void setSubKategori(String subKategori) {
        this.subKategori = subKategori;
    }

    @Override
    public void deskripsiBuku() {
        super.deskripsiBuku();
        System.out.println("Sub Kategori: " + subKategori);
    }
}
