public class CetakBuku {
    public void cetakInfo(Buku buku) {
        System.out.println("Judul: " + buku.getJudul());
    }

    public void cetakInfo(BukuFiksi bukuFiksi) {
        System.out.println("Judul: " + bukuFiksi.getJudul() + ", Sub Kategori: " + bukuFiksi.getSubKategori());
    }
}
