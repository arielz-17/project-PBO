package com.librarymanagement;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LibraryGUI {
    public void start(Stage primaryStage) {

        Label labelJudul = new Label("Judul:");
        TextField textJudul = new TextField();

        Label labelPengarang = new Label("Pengarang:");
        TextField textPengarang = new TextField();

        Label labelISBN = new Label("ISBN:");
        TextField textISBN = new TextField();

        Label labelKategori = new Label("Kategori:");
        TextField textKategori = new TextField();

        Button btnTambahBuku = new Button("Tambah Buku");
        btnTambahBuku.setOnAction(e -> {

            System.out.println("Buku ditambahkan: " + textJudul.getText());
        });

        Label labelNama = new Label("Nama:");
        TextField textNama = new TextField();

        Label labelNomorAnggota = new Label("Nomor Anggota:");
        TextField textNomorAnggota = new TextField();

        Label labelEmail = new Label("Email:");
        TextField textEmail = new TextField();

        Button btnTambahAnggota = new Button("Tambah Anggota");
        btnTambahAnggota.setOnAction(e -> {
            System.out.println("Anggota ditambahkan: " + textNama.getText());
        });

        Label labelPeminjaman = new Label("Peminjaman Buku");
        Label labelNomorAnggotaPinjam = new Label("Nomor Anggota:");
        TextField textNomorAnggotaPinjam = new TextField();

        Label labelISBNPinjam = new Label("ISBN Buku:");
        TextField textISBNPinjam = new TextField();

        Button btnPinjamBuku = new Button("Pinjam Buku");
        btnPinjamBuku.setOnAction(e -> {

            System.out.println("Buku dipinjam: " + textISBNPinjam.getText() + " oleh anggota: " + textNomorAnggotaPinjam.getText());
        });


        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);


        gridPane.add(labelJudul, 0, 0);
        gridPane.add(textJudul, 1, 0);
        gridPane.add(labelPengarang, 0, 1);
        gridPane.add(textPengarang, 1, 1);
        gridPane.add(labelISBN, 0, 2);
        gridPane.add(textISBN, 1, 2);
        gridPane.add(labelKategori, 0, 3);
        gridPane.add(textKategori, 1, 3);
        gridPane.add(btnTambahBuku, 1, 4);

        gridPane.add(labelNama, 0, 5);
        gridPane.add(textNama, 1, 5);
        gridPane.add(labelNomorAnggota, 0, 6);
        gridPane.add(textNomorAnggota, 1, 6);
        gridPane.add(labelEmail, 0, 7);
        gridPane.add(textEmail, 1, 7);
        gridPane.add(btnTambahAnggota, 1, 8);

        gridPane.add(labelPeminjaman, 0, 9, 2, 1);
        gridPane.add(labelNomorAnggotaPinjam, 0, 10);
        gridPane.add(textNomorAnggotaPinjam, 1, 10);
        gridPane.add(labelISBNPinjam, 0, 11);
        gridPane.add(textISBNPinjam, 1, 11);
        gridPane.add(btnPinjamBuku, 1, 12);

        Scene scene = new Scene(gridPane, 500, 600);

        primaryStage.setTitle("Sistem Manajemen Perpustakaan");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
