abstract class AnggotaPerpustakaan implements Keanggotaan {
    protected String idAnggota;
    protected String nama;
    protected String email;
    protected String tipeKeanggotaan;

    public AnggotaPerpustakaan(String idAnggota, String nama, String email, String tipeKeanggotaan) {
        this.idAnggota = idAnggota;
        this.nama = nama;
        this.email = email;
        this.tipeKeanggotaan = tipeKeanggotaan;
    }

    public abstract void getInfo();

    @Override
    public void daftarKeanggotaan() {
        System.out.println("Anggota " + nama + " dengan ID " + idAnggota + " telah terdaftar.");
    }

    @Override
    public void hapusKeanggotaan() {
        System.out.println("Anggota " + nama + " dengan ID " + idAnggota + " telah dihapus.");
    }
}
