package org.example.abstrak;

public class Sapi extends Animal{
    private double berat;

    public final double HARGA_PER_KG = 100000;

    public Sapi(String rfid) {
        super(rfid);
    }

    @Override
    public void bunyi() {
        System.out.println("Moooooo...");
    }

    @Override
    public void jalan() {
        System.out.println("Pelan");
    }

    @Override
    public double harga() {
        return berat*HARGA_PER_KG;
    }


    public double getBerat() {
        return berat;
    }

    public void setBerat(double berat) {
        this.berat = berat;
    }
}
