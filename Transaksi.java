import java.time.LocalDate;

public class Transaksi {
    private Anggota anggota;
    private Buku buku;
    private LocalDate tanggalPinjam;
    private LocalDate tanggalKembali;

    public Transaksi(Anggota anggota, Buku buku, LocalDate tanggalPinjam) {
        this.anggota = anggota;
        this.buku = buku;
        this.tanggalPinjam = tanggalPinjam;
    }

    public Anggota getAnggota() {
        return anggota;
    }

    public void setAnggota(Anggota anggota) {
        this.anggota = anggota;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public LocalDate getTanggalPinjam() {
        return tanggalPinjam;
    }

    public void setTanggalPinjam(LocalDate tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    public LocalDate getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(LocalDate tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

    public void prosesPengembalian(LocalDate tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
        buku.setTersedia(true);
    }
}
