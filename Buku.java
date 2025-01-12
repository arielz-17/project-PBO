public class Buku extends ItemPerpustakaan {
    private String ISBN;
    private String status;

    public Buku(String id, String judul, String pengarang, String ISBN, String kategori) {
        super(id, judul, pengarang, kategori);
        if (KategoriBuku.isValidKategori(kategori)) {
            this.kategori = kategori;
        } else {
            throw new IllegalArgumentException("Kategori tidak valid.");
        }
        this.ISBN = ISBN;
        this.status = "tersedia";
        
    }

    public String getISBN() {
        return ISBN;
        
    }

    public String getStatus() {
        return status;
        
    }

    public void setStatus(String status) {
        this.status = status;
        
    }

    @Override
    public void getInfo() {
        System.out.println("Judul: " + judul + ", Pengarang: " + pengarang + ", ISBN: " + ISBN + ", Kategori: " + kategori + ", Status: " + status);
        
    }
    
}
