public class Siswa extends AnggotaPerpustakaan {
    public Siswa(String idAnggota, String nama, String email) {
        super(idAnggota, nama, email, "Siswa");
    }

    @Override
    public void getInfo() {
        System.out.println("Nama: " + nama + ", Nomor Anggota: " + idAnggota + ", Email: " + email + ", Tipe Keanggotaan: " + tipeKeanggotaan);
    }
}
