/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rental;

import java.util.Scanner;
import rental.system.SystemRental;
import rental.models.*;
import rental.exceptions.*;

// ========== MAIN CLASS ==========
public class Rentaltest {
    private static SystemRental sistem = new SystemRental();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        inisialisasiData();
        
        int pilihan;
        do {
            tampilkanMenu();
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); 
            
            prosesMenu(pilihan);
            
        } while (pilihan != 0);
        
        System.out.println("Terima kasih telah menggunakan Sistem Rental PlayStation!");
        scanner.close();
    }
    
    private static void inisialisasiData() {
        // Menambahkan beberapa PlayStation
        sistem.tambahPS(new PS3("PS3-01", "Sony", 3000, "500GB"));
        sistem.tambahPS(new PS3("PS3-02", "Sony", 3000, "1TB"));
        sistem.tambahPS(new PS4("PS4-01", "Sony", 5000, "825GB", true));
        sistem.tambahPS(new PS4("PS4-02", "Sony", 5000, "825GB", true));
        
        // Menambahkan beberapa pelanggan
        sistem.tambahPelanggan(new Pelanggan("C001", "Aradea", "081234567890", "Jakarta"));
        sistem.tambahPelanggan(new Pelanggan("C002", "Satria", "082345678901", "Bandung"));
        sistem.tambahPelanggan(new Pelanggan("C003", "Permana", "083456789012", "Surabaya"));
        
        System.out.println("Data awal berhasil dimuat!\n");
    }
    
    private static void tampilkanMenu() {
        System.out.println("\n========== SISTEM RENTAL PLAYSTATION ==========");
        System.out.println("1. Tampilkan PlayStation Tersedia");
        System.out.println("2. Buat Penyewaan");
        System.out.println("3. Kembalikan PlayStation");
        System.out.println("4. Tampilkan Riwayat Penyewaan");
        System.out.println("5. Tambah PlayStation Baru");
        System.out.println("6. Tambah Pelanggan Baru");
        System.out.println("0. Keluar");
        System.out.println("===============================================");
    }
    
    private static void prosesMenu(int pilihan) {
        try {
            switch (pilihan) {
                case 1:
                    sistem.tampilkanPStersedia();
                    break;
                    
                case 2:
                    buatPenyewaan();
                    break;
                    
                case 3:
                    kembalikanPS();
                    break;
                    
                case 4:
                    sistem.tampilkanRiwayatSewa();
                    break;
                    
                case 5:
                    tambahPSBaru();
                    break;
                    
                case 6:
                    tambahPelangganBaru();
                    break;
                    
                case 0:
                    break;
                    
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void buatPenyewaan() {
        try {
            System.out.print("Masukkan ID Pelanggan: ");
            String idPelanggan = scanner.nextLine();
            
            System.out.print("Masukkan ID PlayStation: ");
            String idPS = scanner.nextLine();
            
            System.out.print("Masukkan durasi sewa (jam): ");
            int durasi = scanner.nextInt();
            scanner.nextLine();
            
            Penyewaan penyewaan = sistem.buatPenyewaan(idPelanggan, idPS, durasi);
            penyewaan.tampilkanDetailSewa();
            
        } catch (PelangganNotFoundException | PSNotAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void kembalikanPS() {
        System.out.print("Masukkan ID Sewa: ");
        String idSewa = scanner.nextLine();
        sistem.kembalikanPS(idSewa);
    }
    
    private static void tambahPSBaru() {
        System.out.print("Masukkan ID PlayStation: ");
        String id = scanner.nextLine();
        
        System.out.print("Masukkan Merk: ");
        String merk = scanner.nextLine();
        
        System.out.print("Masukkan Harga per Jam: ");
        double harga = scanner.nextDouble();
        scanner.nextLine();
        
        System.out.print("Pilih Tipe (1=PS4, 2=PS5): ");
        int tipe = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Masukkan Kapasitas: ");
        String kapasitas = scanner.nextLine();
        
        if (tipe == 1) {
            sistem.tambahPS(new PS3(id, merk, harga, kapasitas));
        } else if (tipe == 2) {
            System.out.print("Support 4K? (true/false): ");
            boolean support4K = scanner.nextBoolean();
            scanner.nextLine();
            sistem.tambahPS(new PS4(id, merk, harga, kapasitas, support4K));
        }
    }
    
    private static void tambahPelangganBaru() {
        System.out.print("Masukkan ID Pelanggan: ");
        String id = scanner.nextLine();
        
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();
        
        System.out.print("Masukkan No. Telp: ");
        String noTelp = scanner.nextLine();
        
        System.out.print("Masukkan Alamat: ");
        String alamat = scanner.nextLine();
        
        sistem.tambahPelanggan(new Pelanggan(id, nama, noTelp, alamat));
    }
}
