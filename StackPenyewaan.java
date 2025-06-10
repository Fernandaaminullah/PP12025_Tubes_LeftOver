package TubesPP1;

import java.util.Stack;

/**
 * KELAS STACKPENYEWAAN
 * Menyimpan riwayat penyewaan dengan struktur data Stack
 * Praktikum Pemrograman I - UNPAS
 */
public class StackPenyewaan {

    // ATRIBUT STACK RIWAYAT PENYEWAAN
    private Stack<Penyewaan> riwayat;

    public void tambahPenyewaanTanpaPesan(Penyewaan p) {
        riwayat.push(p);
    }
    // KONSTRUKTOR
    public StackPenyewaan() {
        riwayat = new Stack<>();
    }

    // METHOD UNTUK MENAMBAHKAN PENYEWAAN KE DALAM STACK
    public void tambahPenyewaan(Penyewaan p) {
        riwayat.push(p);
        System.out.println("Penyewaan berhasil ditambahkan.");
    }

    // METHOD UNTUK MENGHAPUS PENYEWAAN TERAKHIR
    public void hapusPenyewaanTerakhir() {
        if (!riwayat.isEmpty()) {
            Penyewaan terakhir = riwayat.pop();
            System.out.println("Riwayat terakhir dihapus:\n" + terakhir);
        } else {
            System.out.println("Tidak ada penyewaan untuk dihapus.");
        }
    }

    // METHOD UNTUK MELIHAT PENYEWAAN TERAKHIR
    public void lihatPenyewaanTerakhir() {
        if (!riwayat.isEmpty()) {
            System.out.println("Penyewaan terakhir:\n" + riwayat.peek());
        } else {
            System.out.println("Belum ada penyewaan.");
        }
    }

    // METHOD UNTUK MENAMPILKAN SEMUA PENYEWAAN
    public void tampilkanSemua() {
        if (riwayat.isEmpty()) {
            System.out.println("Belum ada riwayat penyewaan.");
            return;
        }

        System.out.println("Daftar semua penyewaan:");
        // Tampilkan dari atas ke bawah (yang terakhir dimasukkan di atas)
        for (int i = riwayat.size() - 1; i >= 0; i--) {
            System.out.println("- " + riwayat.get(i));
        }
    }

    // METHOD UNTUK MENCARI PENYEWAAN BERDASARKAN NAMA
    public void cariBerdasarkanNama(String nama) {
        boolean ditemukan = false;

        for (Penyewaan p : riwayat) {
            if (p.getNamaPenyewa().equalsIgnoreCase(nama)) {
                System.out.println("Ditemukan: " + p);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Tidak ditemukan penyewaan atas nama " + nama);
        }
    }

    // METHOD UNTUK MENGHITUNG TOTAL PENYEWAAN
    // public int hitungTotal() {
    //     return riwayat.size();
    // }

    public java.util.List<Penyewaan> getSemua() {
        return new java.util.ArrayList<>(riwayat);
    }
}
