package org.example;

import org.example.abstrak.Ayam;
import org.example.abstrak.Kambing;
import org.example.abstrak.Sapi;
import org.example.abstrak2.SapiInterfaceImpl;

public class Main {
    public static void main(String[] args) {
        Sapi gemoy = new Sapi("14918274812748174");

        gemoy.bunyi();
        gemoy.tidur();
        gemoy.setBerat(200.0);
        double harga = gemoy.harga();
        System.out.println(harga);


        Kambing kambing = new Kambing("ajdkfjasdjfkajdf");
        kambing.bunyi();
        kambing.tidur();
        System.out.println(kambing.JUMLAH_KAKI);


        SapiInterfaceImpl sapiBuldozer = new SapiInterfaceImpl();
        sapiBuldozer.bunyi();

        Ayam ayam = new Ayam("12498912041829481");
    }
}