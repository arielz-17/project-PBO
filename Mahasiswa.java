public class Mahasiswa extends AnggotaPerpustakaan {
    
    public Mahasiswa(String idAnggota, String nama, String email) {
        super(idAnggota, nama, email, "Mahasiswa");
        
    }

    
    @Override
    public void getInfo() {
        System.out.println("Nama: " + nama + ", Nomor Anggota: " + idAnggota + ", Email: " + email + ", Tipe Keanggotaan: " + tipeKeanggotaan);
   
    }
    
}
