/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rental.models;

// ========== CONCRETE CLASSES - INHERITANCE ==========
public class PS3 extends PlayStation {
    private String kapasitas;
    
    public PS3(String id, String merk, double hargaPerJam, String kapasitas) {
        super(id, merk, hargaPerJam);
        this.kapasitas = kapasitas;
    }
    
    public String getKapasitas() { 
        return kapasitas; 
    }
    
    @Override
    public String getTipe() {
        return "PlayStation 3 (" + kapasitas + ")";
    }
    
    // Polymorphism - Different implementation for PS3
    @Override
    public void sewa() {
        if (!sedangDisewa) {
            setSedangDisewa(true);
            System.out.println("PS3 " + id + " berhasil disewa!");
        } else {
            System.out.println("PS3 " + id + " sedang tidak tersedia!");
        }
    }
    
    @Override
    public void kembali() {
        if (sedangDisewa) {
            setSedangDisewa(false);
            System.out.println("PS3 " + id + " berhasil dikembalikan!");
        }
    }
    
    @Override
    public double hitungBiaya() {
        return hargaPerJam; // Base rate for PS3
    }
}
