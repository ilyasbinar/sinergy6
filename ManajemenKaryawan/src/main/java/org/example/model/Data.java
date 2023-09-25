package org.example.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {
    //employees sengaja dibuat class variable untuk menyimpan data pegawai.
    //Sebenarnya dengan menjadikan employees static, employees dapat diakses secara langsung dari manapun.
    //Namun untuk pembelajaran, employees ini hanya diakses oleh service. Seolah-olah service dapat dari DAO.
    public static List<Employee> employees = new ArrayList<>();
    public static Map<Integer, Departement> departementMap = new HashMap<>();
}
