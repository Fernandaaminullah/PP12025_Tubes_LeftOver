package TubesPP1;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class MainProgram {

    // Method simpanKeFile diletakkan di luar main
    public static void simpanKeFile(StackPenyewaan sistem, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            List<Penyewaan> semua = sistem.getSemua();
            for (Penyewaan p : semua) {
                writer.write(p.getNamaPenyewa() + ";" + p.getJenisPakaian() + ";" + p.getTanggal() + ";" + p.getDurasiHari() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Gagal menyimpan ke file: " + e.getMessage());
        }
    }

        public static void loadDariFile(StackPenyewaan sistem, String filename) { 
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length == 4) {
                    String nama = data[0];
                    String jenis = data[1];
                    String tanggal = data[2];
                    int durasi = Integer.parseInt(data[3]);
                    Penyewaan p = new Penyewaan(nama, jenis, tanggal, durasi);
                    sistem.tambahPenyewaanTanpaPesan(p); // method baru, lihat bawah
                }
            }
        } catch (Exception e) {
            // File belum ada? Tidak masalah.
        }
    }

    public static void main(String[] args) {
        StackPenyewaan sistem = new StackPenyewaan();
        loadDariFile(sistem, "penyewaan.txt"); // <-- Tambahkan ini
        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== SISTEM PENYEWAAN JAS & KEBAYA ===");
            System.out.println("1. Tambah Penyewaan");
            System.out.println("2. Lihat Penyewaan Terakhir");
            System.out.println("3. Hapus Penyewaan Terakhir");
            System.out.println("4. Tampilkan Semua Penyewaan");
            System.out.println("5. Cari Penyewaan Berdasarkan Nama");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Nama Penyewa               : ");
                    String nama = input.nextLine();
                    System.out.print("Jenis Pakaian (Jas/Kebaya) : ");
                    String jenis = input.nextLine();
                    System.out.print("Tanggal (dd-mm-yyyy)       : ");
                    String tanggal = input.nextLine();
                    System.out.print("Durasi sewa (hari)         : ");
                    int durasi = input.nextInt();
                    input.nextLine();

                    Penyewaan baru = new Penyewaan(nama, jenis, tanggal, durasi);
                    sistem.tambahPenyewaan(baru);
                    simpanKeFile(sistem, "penyewaan.txt");
                    break;

                case 2:
                    sistem.lihatPenyewaanTerakhir();
                    break;

                case 3:
                    sistem.hapusPenyewaanTerakhir();
                    simpanKeFile(sistem, "penyewaan.txt");
                    break;

                case 4:
                    sistem.tampilkanSemua();
                    break;

                case 5:
                    System.out.print("Masukkan nama yang dicari: ");
                    String cariNama = input.nextLine();
                    sistem.cariBerdasarkanNama(cariNama);
                    break;

                case 0:
                    System.out.println("Terima kasih telah menggunakan sistem.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);

        input.close();
    }
}