package org.example.abstrak;

public abstract class Animal {

    private Species species;

    private String rfid;

    public Animal(String rfid) {
        this.rfid = rfid;
    }

    public abstract void bunyi();

    public abstract void jalan();

    public abstract double harga();

    public void tidur(){
        System.out.println("Zzzzzz");
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

}
