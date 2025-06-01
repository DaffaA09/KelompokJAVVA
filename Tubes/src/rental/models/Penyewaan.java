/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rental.models;

// ========== RENTAL CLASS ==========
public class Penyewaan {
    private String idSewa;
    private Pelanggan pelanggan;
    private PlayStation playstation;
    private int durasi;
    private double totalBiaya;
    
    public Penyewaan(String idSewa, Pelanggan pelanggan, PlayStation playstation, int durasi) {
        this.idSewa = idSewa;
        this.pelanggan = pelanggan;
        this.playstation = playstation;
        this.durasi = durasi;
        hitungTotalBiaya();
    }
    
    // Encapsulation - Getter methods
    public String getIdSewa() { 
        return idSewa; 
    }
    public Pelanggan getPelanggan() { 
        return pelanggan; 
    }
    public PlayStation getPlaystation() { 
        return playstation; 
    }
    public int getDurasi() { 
        return durasi; 
    }
    public double getTotalBiaya() { 
        return totalBiaya; 
    }
    
    public void hitungTotalBiaya() {
        this.totalBiaya = playstation.hitungBiaya() * durasi;
    }
    
    public void tampilkanDetailSewa() {
        System.out.println("\n=== DETAIL PENYEWAAN ===");
        System.out.println("ID Sewa: " + idSewa);
        System.out.println("Pelanggan: " + pelanggan.getNama());
        System.out.println("PlayStation: " + playstation.getTipe());
        System.out.println("Durasi: " + durasi + " jam");
        System.out.println("Total Biaya: Rp" + String.format("%.0f", totalBiaya));
        System.out.println("========================");
    }
}
