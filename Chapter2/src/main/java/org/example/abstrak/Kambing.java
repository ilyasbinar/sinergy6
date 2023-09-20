package org.example.abstrak;

public class Kambing extends Animal{
    public final int JUMLAH_KAKI=4;

    public Kambing(String rfid) {
        super(rfid);
    }

    @Override
    public void bunyi() {
        System.out.println("Mbeeeeee");
    }

    @Override
    public void jalan() {
        System.out.println("Sedang");
    }

    @Override
    public double harga() {
        return 0;
    }
}
