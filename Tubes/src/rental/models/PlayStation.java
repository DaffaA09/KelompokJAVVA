/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rental.models;
import rental.interfaces.IRental;

// ========== ABSTRACT CLASS ==========
public abstract class PlayStation implements IRental {
    protected String id;
    protected String merk;
    protected double hargaPerJam;
    protected boolean sedangDisewa;
    
    public PlayStation(String id, String merk, double hargaPerJam) {
        this.id = id;
        this.merk = merk;
        this.hargaPerJam = hargaPerJam;
        this.sedangDisewa = false;
    }
    
    // Encapsulation - Getter methods
    public String getId() { 
        return id; 
    }
    public String getMerk() { 
        return merk; 
    }
    public double getHargaPerJam() { 
        return hargaPerJam; 
    }
    public boolean isSedangDisewa() { 
        return sedangDisewa; 
    }
    
    // Encapsulation - Setter method
   
    public void setSedangDisewa(boolean status) { 
        this.sedangDisewa = status; 
    }
    
    // Abstract method - harus di implementasi di subclass
    public abstract String getTipe();
    
    // Abstract methods from IRental interface - harus di implementasi di subclass
    @Override
    public abstract void sewa();
    @Override
    public abstract void kembali();
    @Override
    public abstract double hitungBiaya();
    
    @Override
    public String toString() {
        return String.format("ID: %s | Merk: %s | Tipe: %s | Harga: Rp%.0f/jam | Status: %s", 
                           id, merk, getTipe(), hargaPerJam, 
                           sedangDisewa ? "Disewa" : "Tersedia");
    }
}
