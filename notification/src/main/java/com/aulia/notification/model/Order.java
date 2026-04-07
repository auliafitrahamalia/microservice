package com.aulia.notification.model;

public class Order {

    private long id;
    private long id_produk;
    private long id_pelanggan;
    private double harga;
    private int jumlah;
    private double total;
    private String email;

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public long getId_produk(){
        return id_produk;
    }

    public void setId_produk(long id_produk){
        this.id_produk = id_produk;
    }

    public long getId_pelanggan(){
        return id_pelanggan;
    }

    public void setId_pelanggan(long id_pelanggan){
        this.id_pelanggan = id_pelanggan;
    }

    public double getHarga(){
        return harga;
    }

    public void setHarga(double harga){
        this.harga = harga;
    }

    public int getJumlah(){
        return jumlah;
    }

    public void setJumlah(int jumlah){
        this.jumlah = jumlah;
    }

    public double getTotal(){
        return total;
    }

    public void setTotal(double total){
        this.total = total;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
}
