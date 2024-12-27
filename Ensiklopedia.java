public class Ensiklopedia extends BukuReferensi {
    public Ensiklopedia(String judul, String pengarang, String isbn, String kategori, boolean tersedia) {
        super(judul, pengarang, isbn, kategori, tersedia);
    }

    @Override
    public void informasiReferensi() {
        System.out.println("Informasi ensiklopedia...");
    }
}
