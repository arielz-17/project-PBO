import java.util.Date;

public class TransaksiPeminjaman {
    private String idTransaksi;
    private Buku buku;
    private AnggotaPerpustakaan anggota;
    private Date tanggalPinjam;
    private Date tanggalKembali;
    private final int batasHariPinjam = 14;
    private final double dendaPerHari = 1000;

    public TransaksiPeminjaman(String idTransaksi, Buku buku, AnggotaPerpustakaan anggota, Date tanggalPinjam) {
        this.idTransaksi = idTransaksi;
        this.buku = buku;
        this.anggota = anggota;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = null; 
    }

    public void prosesPengembalian(Date tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
        long selisihHari = (tanggalKembali.getTime() - tanggalPinjam.getTime()) / (1000 * 60 * 60 * 24);
        if (selisihHari > batasHariPinjam) {
            double denda = (selisihHari - batasHariPinjam) * dendaPerHari;
            System.out.println("Denda keterlambatan: Rp " + denda);
        } else {
            System.out.println("Buku dikembalikan tepat waktu. Tidak ada denda.");
        }
        buku.setStatus("tersedia");
    }

    public void getInfoTransaksi() {
        System.out.println("ID Transaksi: " + idTransaksi + ", Buku: " + buku.judul + ", Anggota: " + anggota.nama + ", Tanggal Pinjam: " + tanggalPinjam);
        if (tanggalKembali != null) {
            System.out.println("Tanggal Kembali: " + tanggalKembali);
        }
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }
}

