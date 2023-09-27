package org.example.view;

import org.example.utils.Constant;

public class GeneralView {

    private GeneralView() {}

    public static void welcomeMessage(){
        System.out.println(Constant.LINE_30C);
        System.out.println("Selamat datang di BinarStaff");
        System.out.println(Constant.LINE_30C);
    }

    public static void menuOption(){
        StringBuilder sb = new StringBuilder();
        sb.append(Constant.LINE_30C).append(Constant.NEW_LINE)
                .append("Menu:").append(Constant.NEW_LINE)
                .append("1. Tambah Pegawai").append(Constant.NEW_LINE)
                .append("2. Lihat Pegawai").append(Constant.NEW_LINE)
                .append("3. Ubah Pegawai").append(Constant.NEW_LINE)
                .append("4. Hapus Pegawai").append(Constant.NEW_LINE)
                .append("0. Keluar").append(Constant.NEW_LINE);
        System.out.println(sb);
        System.out.print("Silakan pilih menu:" );
    }
}
