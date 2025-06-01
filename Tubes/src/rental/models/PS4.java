/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rental.models;

public class PS4 extends PlayStation {
    private String kapasitas;
    private boolean support4K;
    
    public PS4(String id, String merk, double hargaPerJam, String kapasitas, boolean support4K) {
        super(id, merk, hargaPerJam);
        this.kapasitas = kapasitas;
        this.support4K = support4K;
    }
    
    public String getKapasitas() { 
        return kapasitas; 
    }
    public boolean isSupport4K() { 
        return support4K; 
    }
    
    @Override
    public String getTipe() {
        return "PlayStation 4 (" + kapasitas + ")" + (support4K ? " - 4K Support" : "");
    }
    
    // Polymorphism - Different implementation for PS4
    @Override
    public void sewa() {
        if (!sedangDisewa) {
            setSedangDisewa(true);
            System.out.println("PS4 " + id + " berhasil disewa!");
        } else {
            System.out.println("PS4 " + id + " sedang tidak tersedia!");
        }
    }
    
    @Override
    public void kembali() {
        if (sedangDisewa) {
            setSedangDisewa(false);
            System.out.println("PS4 " + id + " berhasil dikembalikan!");
        }
    }
    
    @Override
    public double hitungBiaya() {
        // PS5 has premium pricing
        return hargaPerJam * 1.5;
    }
}
