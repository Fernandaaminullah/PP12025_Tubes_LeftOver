package TubesPP1;

/**
 * KELAS PENYEWAAN
 * Menyimpan informasi penyewaan Jas atau Kebaya
 * Praktikum Pemrograman I - UNPAS
 */
public class Penyewaan {

    // ATRIBUT PENYEWAAN
    private String namaPenyewa;
    private String jenisPakaian; // "Jas" atau "Kebaya"
    private String tanggal;
    private int durasiHari;

    // KONSTRUKTOR PENYEWAAN
    public Penyewaan(String namaPenyewa, String jenisPakaian, String tanggal, int durasiHari) {
        this.namaPenyewa = namaPenyewa;
        this.jenisPakaian = jenisPakaian;
        this.tanggal = tanggal;
        this.durasiHari = durasiHari;
    }

    // METHOD GETTER
    public String getNamaPenyewa() {
        return namaPenyewa;
    }

    public String getJenisPakaian() {
        return jenisPakaian;
    }

    public String getTanggal() {
        return tanggal;
    }

    public int getDurasiHari() {
        return durasiHari;
    }

    // METHOD TAMBAHAN UNTUK KOMPATIBILITAS DENGAN MainProgram
    public String getNama() {
        return namaPenyewa;
    }

    public String getJenis() {
        return jenisPakaian;
    }

    public int getDurasi() {
        return durasiHari;
    }

    // METHOD TOSTRING UNTUK MENAMPILKAN DATA PENYEWAAN
    @Override
    public String toString() {
        return namaPenyewa + " menyewa " + jenisPakaian + 
               " pada " + tanggal + " selama " + durasiHari + " hari.";
    }
}
