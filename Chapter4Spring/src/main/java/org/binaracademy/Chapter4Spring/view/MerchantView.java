package org.binaracademy.Chapter4Spring.view;

import org.binaracademy.Chapter4Spring.model.Merchant;

import java.util.List;

public class MerchantView {
    public static void showAllMerchant(List<Merchant> merchantList){
        merchantList.forEach(Merchant::print);
    }

    public static void showMerchantMenuOption() {
        System.out.println("Silakan pilih menu:");
        System.out.println("1. Tambah");
        System.out.println("2. Edit Status");
        System.out.println("3. Tampilkan yang sedang buka");
    }
}
