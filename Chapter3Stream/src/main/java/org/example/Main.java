package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Stream!");

        /**
         * Intermediate Operation:
         * filter()
         * map()
         * distinct()
         * sorted()
         * limit()
         * skip()
         */

        /**
         * Terminal Operation
         * forEach()
         * toArray()
         * reduce()
         * collect()
         * min()
         * max()
         * count()
         * anyMatch()
         * allMatch()
         * noneMatch()
         * findFirst()
         * findAny()
         */

        //init data

        Departement it = new Departement("1", "IT");
        Departement finance = new Departement("2", "Finance");

        Employee ilyas = new Employee("1", "Ilyas", 3000000L);
        ilyas.setNoHp(Arrays.asList("0812","0812"));
        Employee alfrendo = new Employee("2", "Alfrendo", 4000000L);
        alfrendo.setNoHp(Arrays.asList("0812","0812"));
        Employee aulia = new Employee("3", "Aulia", 5000000L);
        aulia.setNoHp(Arrays.asList("0812","0812"));
        Employee nur = new Employee("4", "Nur", 6000000L);
        nur.setNoHp(Arrays.asList("0812","0812"));
        Employee aljovan = new Employee("5", "Aljovan", 7000000L);
        aljovan.setNoHp(Arrays.asList("0812","0812"));
        Employee hifni = new Employee("6", "Hifni", 7500000L);
        hifni.setNoHp(Arrays.asList("0815","0813"));


        List<Employee> itEmployees = Arrays.asList(ilyas, alfrendo, aulia, nur);
        List<Employee> financeEmployees = Arrays.asList(aljovan, hifni);

        List<Employee> employees = new ArrayList<>();
        employees.addAll(itEmployees);
        employees.addAll(financeEmployees);

        it.setEmployees(itEmployees);
        finance.setEmployees(financeEmployees);

        List<Departement> departements = Arrays.asList(it, finance);


        //Ambil nama2 departement dari List<Departemtn>
        List<String> departementNames = departements.stream()
                .map(departement -> departement.getName())
                .collect(Collectors.toList());

        departementNames.forEach(System.out::println);

        List<String> departementNames2 = departements.stream()
                .map(Departement::getName)
                .toList();

        departementNames2.forEach(System.out::println);

        //Mendapatkan nama2 employee dari List<Departement>
        //List<Departement> -stream-> List<Employee> -stream-> toList()
        List<String> employeeNames = departements.stream()
                .flatMap(departement -> departement.getEmployees().stream())
                .map(employee -> employee.getName())
                .toList()
                .stream().filter(s -> s.length()>5).toList();

        System.out.println("=======");
        employeeNames.forEach(System.out::println);
        System.out.println("=======");


        departements.stream()
                .flatMap(departement -> departement.getEmployees().stream())
                .map(employee -> employee.getName())
                .forEach(System.out::println);



        List<String> employeeNoHps = departements.stream()
                .flatMap(departement -> departement.getEmployees().stream())
                .flatMap(employee -> employee.getNoHp().stream())
                .map(s -> s)
                .toList();

        employeeNoHps.forEach(System.out::println);

        //Ambil employee yang gajinya lebih besar dari 4500000 dari List<Employee>
        employees.stream()
                .filter(employee -> employee.getSalary()>4500000)
                .toList()
                .forEach(employee -> {
                    System.out.println(employee.getName()+" digaji sebesar "+employee.getSalary());
                });

        //Mengurutkan employee berdasarkan nama dari List<Employee>
        List<Employee> employeeOrderByName = employees.stream()
                .sorted((e1, e2) -> EmployeeComparatorProvider.compareByName(e1, e2))
                .toList();


        List<Employee> employeeOrderByNameLamda = employees.stream()
                .sorted(EmployeeComparatorProvider::compareByName)
                .toList();


        //Descending
        List<Employee> employeeOrderByNameDescComparator = employees.stream()
                .sorted((e1, e2) -> EmployeeComparatorProvider.compareByNameDesc(e1, e2))
                .toList();
        List<Employee> employeeOrderByNameDescReversed = employees.stream()
                .sorted((e1, e2) -> EmployeeComparatorProvider.compareByName(e1, e2))
                .toList().reversed();

        System.out.println("===Data====");
        employeeOrderByNameDescReversed.forEach(employee -> System.out.println(employee.getName()));
        System.out.println("===========");

        System.out.println("==Page 1==");
        employeeOrderByNameDescReversed.stream()
                .limit(2)
                .forEach(employee -> System.out.println(employee.getName()));
        System.out.println();

        System.out.println("==Page 2==");
        employeeOrderByNameDescReversed.stream()
                .skip(2)
                .limit(2)
                .forEach(employee -> System.out.println(employee.getName()));

        System.out.println(employees.stream()
                .filter(employee -> employee.getSalary()>4500000)
                .count());

        //apakah ada yang di gaji 5000000
        boolean isSalary6MilExist = employees.stream()
                .anyMatch(employee -> employee.getSalary()==5000000);
        System.out.println(isSalary6MilExist);

        //apakah semua employee di gaji 5000000
        boolean areAllEmployeeSalary6Mill = employees.stream()
                .allMatch(employee -> employee.getSalary()==5000000);
        System.out.println(areAllEmployeeSalary6Mill);

        boolean isAllNoHpIdentic0812 = departements.stream()
                .flatMap(departement -> departement.getEmployees().stream())
                .flatMap(employee -> employee.getNoHp().stream())
                .allMatch(s -> s.equals("0812"));

        System.out.println(isAllNoHpIdentic0812);


        //mencari gaji paling besar
         employees.stream()
                .map(employee -> employee.getSalary())
                .toList()
                .stream()
                .max(Comparator.comparing(Long::longValue))
                .ifPresent(System.out::println);

         System.out.println(
                 employees.stream()
                         .map(employee -> employee.getSalary())
                         .reduce(0L, Long::sum));


        List<String> noHpUniques = departements.stream()
                .flatMap(departement -> departement.getEmployees().stream())
                .flatMap(employee -> employee.getNoHp().stream()).distinct().toList();

        noHpUniques.stream().forEach(System.out::println);

    }
}