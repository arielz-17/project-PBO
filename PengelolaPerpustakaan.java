import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PengelolaPerpustakaan {
    private List<Buku> daftarBuku;
    private List<AnggotaPerpustakaan> daftarAnggota;
    private List<TransaksiPeminjaman> daftarTransaksi;

    public PengelolaPerpustakaan() {
        daftarBuku = new ArrayList<>();
        daftarAnggota = new ArrayList<>();
        daftarTransaksi = new ArrayList<>();
    }

    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
        System.out.println("Buku berhasil ditambahkan.");
    }

    public void tambahBuku(String id, String judul, String pengarang, String ISBN, String kategori) {
        Buku buku = new Buku(id, judul, pengarang, ISBN, kategori);
        daftarBuku.add(buku);
        System.out.println("Buku berhasil ditambahkan.");
    }

    public void hapusBuku(String id) {
        Buku bukuUntukDihapus = null;
        for (Buku buku : daftarBuku) {
            if (buku.id.equals(id)) {
                bukuUntukDihapus = buku;
                break;
            }
        }
        if (bukuUntukDihapus != null) {
            daftarBuku.remove(bukuUntukDihapus);
            System.out.println("Buku berhasil dihapus.");
        } else {
            System.out.println("Buku tidak ditemukan.");
        }
    }

    public List<Buku> getDaftarBuku() {
        return daftarBuku;
    }

    public void tampilkanDaftarBuku() {
        for (Buku buku : daftarBuku) {
            buku.getInfo();
        }
    }

    public void tambahAnggota(AnggotaPerpustakaan anggota) {
        daftarAnggota.add(anggota);
        System.out.println("Anggota berhasil ditambahkan.");
    }

    public void tambahAnggota(String idAnggota, String nama, String email, String tipeKeanggotaan) {
        AnggotaPerpustakaan anggota;
        if (tipeKeanggotaan.equalsIgnoreCase("Siswa")) {
            anggota = new Siswa(idAnggota, nama, email);
        } else if (tipeKeanggotaan.equalsIgnoreCase("Mahasiswa")) {
            anggota = new Mahasiswa(idAnggota, nama, email);
        } else {
            anggota = new Umum(idAnggota, nama, email);
        }
        daftarAnggota.add(anggota);
        System.out.println("Anggota berhasil ditambahkan.");
    }

    public void hapusAnggota(String idAnggota) {
        AnggotaPerpustakaan anggotaUntukDihapus = null;
        for (AnggotaPerpustakaan anggota : daftarAnggota) {
            if (anggota.idAnggota.equals(idAnggota)) {
                anggotaUntukDihapus = anggota;
                break;
            }
        }
        if (anggotaUntukDihapus != null) {
            daftarAnggota.remove(anggotaUntukDihapus);
            System.out.println("Anggota berhasil dihapus.");
        } else {
            System.out.println("Anggota tidak ditemukan.");
        }
    }

    public List<AnggotaPerpustakaan> getDaftarAnggota() {
        return daftarAnggota;
    }

    public void tampilkanDaftarAnggota() {
        for (AnggotaPerpustakaan anggota : daftarAnggota) {
            anggota.getInfo();
        }
    }

    public void pinjamBuku(String idAnggota, String idBuku, Date tanggalPinjam) {
        AnggotaPerpustakaan anggota = null;
        for (AnggotaPerpustakaan a : daftarAnggota) {
            if (a.idAnggota.equals(idAnggota)) {
                anggota = a;
                break;
            }
        }

        Buku buku = null;
        for (Buku b : daftarBuku) {
            if (b.id.equals(idBuku) && b.getStatus().equals("tersedia")) {
                buku = b;
                break;
            }
        }

        if (anggota != null && buku != null) {
            TransaksiPeminjaman transaksi = new TransaksiPeminjaman("T" + (daftarTransaksi.size() + 1), buku, anggota, tanggalPinjam);
            daftarTransaksi.add(transaksi);
            buku.setStatus("dipinjam");
            System.out.println("Buku berhasil dipinjam.");
        } else {
            System.out.println("Peminjaman gagal. Buku atau anggota tidak ditemukan.");
        }
    }

    public void kembalikanBuku(String idTransaksi, Date tanggalKembali) {
        boolean ditemukan = false;
        for (TransaksiPeminjaman transaksi : daftarTransaksi) {
            if (transaksi.getIdTransaksi().equals(idTransaksi)) {
                transaksi.prosesPengembalian(tanggalKembali);
                System.out.println("Buku berhasil dikembalikan.");
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Transaksi tidak ditemukan.");
        }
    }

    public void tampilkanDaftarTransaksi() {
        for (TransaksiPeminjaman transaksi : daftarTransaksi) {
            transaksi.getInfoTransaksi();
        }
    }
}
