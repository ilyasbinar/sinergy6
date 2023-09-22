package org.example;

import java.util.List;

public class Employee {

    private Departemen departemen;

    private Menu menu;

    private int jumlah;

    private String nip;
    private String nama;
    private String noHp;

    private long gaji;

    public Employee(String nip, String nama, String noHp) {
        this.nip = nip;
        this.nama = nama;
        this.noHp = noHp;
    }

    public Employee(Menu menu) {
        this.menu = menu;
    }

    public Employee(String nip, String nama, String noHp, long gaji) {
        this.nip = nip;
        this.nama = nama;
        this.noHp = noHp;
        this.gaji = gaji;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public long getGaji() {
        return gaji;
    }

    public void setGaji(long gaji) {
        this.gaji = gaji;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public void printEmployee() {
        System.out.println(nip+" "+nama+" "+noHp+" "+gaji);
    }

    public Departemen getDepartemen() {
        return departemen;
    }

    public void setDepartemen(Departemen departemen) {
        this.departemen = departemen;
    }

    public List<Employee> addDepartemen(Departemen departemen, List<Employee> employeeList) {
        return employeeList;
    }
}
