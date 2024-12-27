public class Buku {
    private String judul;
    private String pengarang;
    private String isbn;
    private String kategori;
    private boolean tersedia;

    public Buku(String judul, String pengarang, String isbn, String kategori, boolean tersedia) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.isbn = isbn;
        this.kategori = kategori;
        this.tersedia = tersedia;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }

    public void deskripsiBuku() {
        System.out.println("Buku: " + judul + ", Pengarang: " + pengarang);
    }
}