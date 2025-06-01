/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rental.system;


import java.util.ArrayList;
import rental.models.*;
import rental.exceptions.*;

// ========== SYSTEM MANAGEMENT CLASS ==========
public class SystemRental {
    private ArrayList<PlayStation> daftarPS;
    private ArrayList<Pelanggan> daftarPelanggan;
    private ArrayList<Penyewaan> daftarSewa;
    
    public SystemRental() {
        daftarPS = new ArrayList<>();
        daftarPelanggan = new ArrayList<>();
        daftarSewa = new ArrayList<>();
    }
    
    public void tambahPS(PlayStation ps) {
        daftarPS.add(ps);
        System.out.println("PlayStation berhasil ditambahkan: " + ps.getTipe());
    }
    
    public void tambahPelanggan(Pelanggan pelanggan) {
        daftarPelanggan.add(pelanggan);
        System.out.println("Pelanggan berhasil ditambahkan: " + pelanggan.getNama());
    }
    
    public boolean hapusPS(String id) {
        for (int i = 0; i < daftarPS.size(); i++) {
            if (daftarPS.get(i).getId().equals(id)) {
                daftarPS.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public PlayStation cariPS(String id) throws PSNotAvailableException {
        for (PlayStation ps : daftarPS) {
            if (ps.getId().equals(id)) {
                if (ps.isSedangDisewa()) {
                    throw new PSNotAvailableException("PlayStation dengan ID " + id + " sedang disewa!");
                }
                return ps;
            }
        }
        throw new PSNotAvailableException("PlayStation dengan ID " + id + " tidak ditemukan!");
    }
    
    public Pelanggan cariPelanggan(String id) throws PelangganNotFoundException {
        for (Pelanggan pelanggan : daftarPelanggan) {
            if (pelanggan.getIdPelanggan().equals(id)) {
                return pelanggan;
            }
        }
        throw new PelangganNotFoundException("Pelanggan dengan ID " + id + " tidak ditemukan!");
    }
    
    public Penyewaan buatPenyewaan(String idPelanggan, String idPS, int durasi) 
            throws PelangganNotFoundException, PSNotAvailableException {
        
        Pelanggan pelanggan = cariPelanggan(idPelanggan);
        PlayStation ps = cariPS(idPS);
        
        String idSewa = "R" + (daftarSewa.size() + 1);
        Penyewaan penyewaan = new Penyewaan(idSewa, pelanggan, ps, durasi);
        
        ps.sewa(); // Set status menjadi disewa
        daftarSewa.add(penyewaan);
        
        return penyewaan;
    }
    
    public void kembalikanPS(String idSewa) {
        for (Penyewaan sewa : daftarSewa) {
            if (sewa.getIdSewa().equals(idSewa)) {
                sewa.getPlaystation().kembali();
                System.out.println("PlayStation berhasil dikembalikan!");
                return;
            }
        }
        System.out.println("ID Sewa tidak ditemukan!");
    }
    
    public void tampilkanPStersedia() {
        System.out.println("\n=== DAFTAR PLAYSTATION TERSEDIA ===");
        boolean adaTersedia = false;
        for (PlayStation ps : daftarPS) {
            if (!ps.isSedangDisewa()) {
                System.out.println(ps.toString());
                adaTersedia = true;
            }
        }
        if (!adaTersedia) {
            System.out.println("Tidak ada PlayStation yang tersedia saat ini.");
        }
        System.out.println("===================================");
    }
    
    public void tampilkanRiwayatSewa() {
        System.out.println("\n=== RIWAYAT PENYEWAAN ===");
        if (daftarSewa.isEmpty()) {
            System.out.println("Belum ada riwayat penyewaan.");
        } else {
            for (Penyewaan sewa : daftarSewa) {
                sewa.tampilkanDetailSewa();
            }
        }
        System.out.println("========================");
    }
    
    public int getTotalPS() { 
        return daftarPS.size(); 
    }
    public int getTotalPelanggan() { 
        return daftarPelanggan.size(); 
    }
}
