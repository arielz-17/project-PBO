abstract class ItemPerpustakaan {
    protected String id;
    protected String judul;
    protected String pengarang;
    protected String kategori;
    

    public ItemPerpustakaan(String id, String judul, String pengarang, String kategori) {
        this.id = id;
        this.judul = judul;
        this.pengarang = pengarang;
        this.kategori = kategori;
        
    }

    public abstract void getInfo();
    
}
