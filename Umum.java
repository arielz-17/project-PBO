public class Umum extends AnggotaPerpustakaan {
    public Umum(String idAnggota, String nama, String email) {
        super(idAnggota, nama, email, "Umum");
    }

    @Override
    public void getInfo() {
        System.out.println("Nama: " + nama + ", Nomor Anggota: " + idAnggota + ", Email: " + email + ", Tipe Keanggotaan: " + tipeKeanggotaan);
    }
}
