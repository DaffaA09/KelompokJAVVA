/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rental.models;

// ========== CUSTOMER CLASS ==========
public class Pelanggan {
    private String idPelanggan;
    private String nama;
    private String noTelp;
    private String alamat;
    
    public Pelanggan(String idPelanggan, String nama, String noTelp, String alamat) {
        this.idPelanggan = idPelanggan;
        this.nama = nama;
        this.noTelp = noTelp;
        this.alamat = alamat;
    }
    
    // Encapsulation - Getter methods
    public String getIdPelanggan() { 
        return idPelanggan; 
    }
    public String getNama() { 
        return nama; 
    }
    public String getNoTelp() { 
        return noTelp; 
    }
    public String getAlamat() { 
        return alamat; 
    }
    
    // Encapsulation - Setter methods
    public void setNama(String nama) { 
        this.nama = nama; 
    }
    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp; 
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat; 
    }
    
    @Override
    public String toString() {
        return String.format("ID: %s | Nama: %s | Telp: %s | Alamat: %s", 
                           idPelanggan, nama, noTelp, alamat);
    }
}
