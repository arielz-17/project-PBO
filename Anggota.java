public class Anggota {
    private String nama;
    private String nomorAnggota;
    private String email;
    private String tipeKeanggotaan;

    public Anggota(String nama, String nomorAnggota, String email, String tipeKeanggotaan) {
        this.nama = nama;
        this.nomorAnggota = nomorAnggota;
        this.email = email;
        this.tipeKeanggotaan = tipeKeanggotaan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomorAnggota() {
        return nomorAnggota;
    }

    public void setNomorAnggota(String nomorAnggota) {
        this.nomorAnggota = nomorAnggota;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipeKeanggotaan() {
        return tipeKeanggotaan;
    }

    public void setTipeKeanggotaan(String tipeKeanggotaan) {
        this.tipeKeanggotaan = tipeKeanggotaan;
    }
}
