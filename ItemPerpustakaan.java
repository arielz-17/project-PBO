public abstract class BukuReferensi extends Buku {
    public BukuReferensi(String judul, String pengarang, String isbn, String kategori, boolean tersedia) {
        super(judul, pengarang, isbn, kategori, tersedia);
    }

    public abstract void informasiReferensi();
}
