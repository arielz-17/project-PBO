public class KategoriBuku {
    public static final String FIKSI = "Fiksi";
    public static final String NON_FIKSI = "Non-Fiksi";
    public static final String REFERENSI = "Referensi";

    public static boolean isValidKategori(String kategori) {
        return kategori.equals(FIKSI) || kategori.equals(NON_FIKSI) || kategori.equals(REFERENSI);
    }
}
