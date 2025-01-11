import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class PerpustakaanGUI extends JFrame {
    private PengelolaPerpustakaan pengelolaPerpustakaan;

    public PerpustakaanGUI() {
        pengelolaPerpustakaan = new PengelolaPerpustakaan();
        setTitle("Sistem Manajemen Perpustakaan Digital");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JMenuBar menuBar = new JMenuBar();
        JMenu menuBuku = new JMenu("Buku");
        JMenuItem tambahBuku = new JMenuItem("Tambah Buku");
        JMenuItem hapusBuku = new JMenuItem("Hapus Buku");
        JMenuItem daftarBuku = new JMenuItem("Daftar Buku");

        menuBuku.add(tambahBuku);
        menuBuku.add(hapusBuku);
        menuBuku.add(daftarBuku);
        menuBar.add(menuBuku);

        JMenu menuAnggota = new JMenu("Anggota");
        JMenuItem tambahAnggota = new JMenuItem("Tambah Anggota");
        JMenuItem hapusAnggota = new JMenuItem("Hapus Anggota");
        JMenuItem daftarAnggota = new JMenuItem("Daftar Anggota");

        menuAnggota.add(tambahAnggota);
        menuAnggota.add(hapusAnggota);
        menuAnggota.add(daftarAnggota);
        menuBar.add(menuAnggota);

        JMenu menuTransaksi = new JMenu("Transaksi");
        JMenuItem pinjamBuku = new JMenuItem("Pinjam Buku");
        JMenuItem kembalikanBuku = new JMenuItem("Kembalikan Buku");

        menuTransaksi.add(pinjamBuku);
        menuTransaksi.add(kembalikanBuku);
        menuBar.add(menuTransaksi);

        setJMenuBar(menuBar);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Serif", Font.PLAIN, 14));
        textArea.setBackground(Color.LIGHT_GRAY);
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        tambahBuku.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPanel inputPanel = new JPanel(new GridLayout(0, 1));
                inputPanel.add(new JLabel("ID Buku:"));
                JTextField idField = new JTextField();
                inputPanel.add(idField);
                inputPanel.add(new JLabel("Judul Buku:"));
                JTextField judulField = new JTextField();
                inputPanel.add(judulField);
                inputPanel.add(new JLabel("Pengarang:"));
                JTextField pengarangField = new JTextField();
                inputPanel.add(pengarangField);
                inputPanel.add(new JLabel("ISBN:"));
                JTextField isbnField = new JTextField();
                inputPanel.add(isbnField);
                inputPanel.add(new JLabel("Kategori:"));
                JComboBox<String> kategoriComboBox = new JComboBox<>(new String[]{KategoriBuku.FIKSI, KategoriBuku.NON_FIKSI, KategoriBuku.REFERENSI});
                inputPanel.add(kategoriComboBox);

                int result = JOptionPane.showConfirmDialog(null, inputPanel, "Tambah Buku",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    String id = idField.getText();
                    String judul = judulField.getText();
                    String pengarang = pengarangField.getText();
                    String ISBN = isbnField.getText();
                    String kategori = (String) kategoriComboBox.getSelectedItem();

                    if (id != null && judul != null && pengarang != null && ISBN != null && kategori != null) {
                        Buku buku = new Buku(id, judul, pengarang, ISBN, kategori);
                        pengelolaPerpustakaan.tambahBuku(buku);
                        JOptionPane.showMessageDialog(null, "Buku berhasil ditambahkan!");
                    }
                }
            }
        });

        hapusBuku.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                String id = JOptionPane.showInputDialog("ID Buku yang akan dihapus:");
                if (id != null) {
                    pengelolaPerpustakaan.hapusBuku(id);
                    JOptionPane.showMessageDialog(null, "Buku berhasil dihapus!");
                }
            }
        });

        daftarBuku.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                for (Buku buku : pengelolaPerpustakaan.getDaftarBuku()) {
                    textArea.append("ID: " + buku.id + ", Judul: " + buku.judul + ", Pengarang: " + buku.pengarang + ", ISBN: " + buku.getISBN() + ", Kategori: " + buku.kategori + ", Status: " + buku.getStatus() + "\n");
                }
            }
        });

        tambahAnggota.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPanel inputPanel = new JPanel(new GridLayout(0, 1));
                inputPanel.add(new JLabel("ID Anggota:"));
                JTextField idField = new JTextField();
                inputPanel.add(idField);
                inputPanel.add(new JLabel("Nama Anggota:"));
                JTextField namaField = new JTextField();
                inputPanel.add(namaField);
                inputPanel.add(new JLabel("Email:"));
                JTextField emailField = new JTextField();
                inputPanel.add(emailField);
                inputPanel.add(new JLabel("Tipe Keanggotaan (Siswa/Mahasiswa/Umum):"));
                JTextField tipeField = new JTextField();
                inputPanel.add(tipeField);

                int result = JOptionPane.showConfirmDialog(null, inputPanel, "Tambah Anggota",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    String id = idField.getText();
                    String nama = namaField.getText();
                    String email = emailField.getText();
                    String tipeKeanggotaan = tipeField.getText();

                    if (id != null && nama != null && email != null && tipeKeanggotaan != null) {
                        AnggotaPerpustakaan anggota;
                        if (tipeKeanggotaan.equalsIgnoreCase("Siswa")) {
                            anggota = new Siswa(id, nama, email);
                        } else if (tipeKeanggotaan.equalsIgnoreCase("Mahasiswa")) {
                            anggota = new Mahasiswa(id, nama, email);
                        } else {
                            anggota = new Umum(id, nama, email);
                        }
                        pengelolaPerpustakaan.tambahAnggota(anggota);
                        JOptionPane.showMessageDialog(null, "Anggota berhasil ditambahkan!");
                    }
                }
            }
        });

        hapusAnggota.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String id = JOptionPane.showInputDialog("ID Anggota yang akan dihapus:");
                if (id != null) {
                    pengelolaPerpustakaan.hapusAnggota(id);
                    JOptionPane.showMessageDialog(null, "Anggota berhasil dihapus!");
                }
            }
        });

        daftarAnggota.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                textArea.setText("");
                for (AnggotaPerpustakaan anggota : pengelolaPerpustakaan.getDaftarAnggota()) {
                    textArea.append("ID: " + anggota.idAnggota + ", Nama: " + anggota.nama + ", Email: " + anggota.email + ", Tipe Keanggotaan: " + anggota.tipeKeanggotaan + "\n");
                }
            }
        });

        pinjamBuku.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JPanel inputPanel = new JPanel(new GridLayout(0, 1));
                inputPanel.add(new JLabel("ID Anggota:"));
                JTextField idAnggotaField = new JTextField();
                inputPanel.add(idAnggotaField);
                inputPanel.add(new JLabel("ID Buku:"));
                JTextField idBukuField = new JTextField();
                inputPanel.add(idBukuField);

                int result = JOptionPane.showConfirmDialog(null, inputPanel, "Pinjam Buku",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    String idAnggota = idAnggotaField.getText();
                    String idBuku = idBukuField.getText();
                    Date tanggalPinjam = new Date();

                    if (idAnggota != null && idBuku != null) {
                        pengelolaPerpustakaan.pinjamBuku(idAnggota, idBuku, tanggalPinjam);
                        JOptionPane.showMessageDialog(null, "Buku berhasil dipinjam!");
                    }
                }
            }
        });

        kembalikanBuku.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                String idTransaksi = JOptionPane.showInputDialog("ID Transaksi:");
                Date tanggalKembali = new Date();

                if (idTransaksi != null) {
                    pengelolaPerpustakaan.kembalikanBuku(idTransaksi, tanggalKembali);
                    JOptionPane.showMessageDialog(null, "Buku berhasil dikembalikan!");
                }
            }
        });

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PerpustakaanGUI().setVisible(true);
            }
        });
    }
}
