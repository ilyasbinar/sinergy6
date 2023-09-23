package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        List of String
        List<String> students = new ArrayList<>();
        students.add("Sulton");
        students.add("Aulia");
        students.add("Dimas");
        students.add("Nur");
        students.add("Nur");

        for(int i=0;i<students.size();i++){
            System.out.println(students.get(i));
        }

        for(String s:students){
            System.out.println(s);
        }

        Departemen it = new Departemen("IT");
        Departemen hrd = new Departemen("HRD");

//        List of Employee
        List<Employee> employees = new ArrayList<>();

        Employee sulton = new Employee("11111", "Sulton", "081111111", 100000000);
        sulton.setDepartemen(it);
//        List<Employee> itEmployee = sulton.addDepartement(it);
        Employee andhika = new Employee("55555", "Andhika", "0855555", 100000000);
        sulton.setDepartemen(it);
        Employee aulia = new Employee("22222", "Aulia", "08222222", 100000000);
        aulia.setDepartemen(hrd);

        employees.add(sulton);
        employees.add(aulia);

        System.out.println("===Pegawai Aktif=====");
        for(Employee e:employees){
            System.out.println(e.getDepartemen().getNama());
            e.printEmployee();
        }


        List<Employee> iTEmployees = new ArrayList<>();
        iTEmployees.add(sulton);
        iTEmployees.add(andhika);
        it.setEmployeeList(iTEmployees);

        System.out.println("====PEGAWAI IT======");
        for(Employee e:it.getEmployeeList()){
            e.printEmployee();
        }

        List<Employee> inactiveEmployees = new ArrayList<>();

        Employee dimas = new Employee("33333", "Dimas", "0833333");
        Employee nur = new Employee("44444", "Nur", "0844444");

        inactiveEmployees.add(dimas);
        inactiveEmployees.add(nur);

        System.out.println("===Pegawai Non Aktif=====");
        for(Employee e:inactiveEmployees){
            e.printEmployee();
        }

        List<Employee> reuniEmployees = new ArrayList<>();
        reuniEmployees.addAll(employees);
        reuniEmployees.addAll(inactiveEmployees);

        System.out.println("===Pegawai Reuni Undangan=====");
        int no=1;
        for(Employee e:reuniEmployees){
            System.out.println(no++);
            e.printEmployee();
        }


        Menu ayamGoreng = new Menu();
        Employee employee = new Employee(ayamGoreng);
//        Scanner.....
        employee.setJumlah(10);

        /*
         * Pesanan
         *  - Item (Menu, jumlah)
         *  - Item (Menu, jumlah)
         */


        Set<String> studentSet = new HashSet<>();
        studentSet.add("Sulton");
        studentSet.add("Nur");
        studentSet.add("Nur");

        for(String s:studentSet){
            System.out.println(s);
        }


        Map<String, Employee> employeeMap = new HashMap<>();
        employeeMap.put("11111", sulton);
        employeeMap.put("22222", aulia);
        employeeMap.put("33333", andhika);

//        Iterator<String> iterator =

        for(Map.Entry<String, Employee> e : employeeMap.entrySet()){
            System.out.println("Key = "+e.getKey());
            e.getValue().printEmployee();
        }

        //Call Multiple Return Demo
        Object[] oArr = MultipleReturnDemo.objectArray();
        for (Object o : oArr) {
            if(o instanceof Employee){
                ((Employee) o).printEmployee();
            }else{
                System.out.println(o);
            }
        }
    }
}