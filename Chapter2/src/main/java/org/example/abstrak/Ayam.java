package org.example.abstrak;

public class Ayam extends Animal{
    public static final int JUMLAH_KAKI=2;

    public Ayam(String rfid) {
        super(rfid);
    }

    @Override
    public void bunyi() {
        System.out.println("Petok");
    }

    @Override
    public void jalan() {

    }

    @Override
    public double harga() {
        return 0;
    }
}
