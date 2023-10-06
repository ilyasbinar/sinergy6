package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class MethodReference {
    public static void main(String arg[]){
        List<String> stringList =  new ArrayList<>();
        stringList.add("100000");
        stringList.add("200000");
        stringList.add("400000");

        List<Integer> integerList0 = new ArrayList<>();
        for(String s:stringList){
            integerList0.add(Integer.parseInt(s));
        }

        List<Integer> integerList1  = stringList.stream()
                .map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s){
                return Integer.parseInt(s);
            }
        }).toList();


        List<Integer> integerList2  = stringList.stream()
                .map(s -> Integer.parseInt(s)).toList();


        List<Integer> integerList3 = stringList.stream()
                .map(Integer::parseInt).toList();


        List<Employee> list = Arrays.asList(
                new Employee("Ilyas", 2000000l),
                new Employee("Ren", 1000000l),
                new Employee("Akhmad Fajar", 4000000l),
                new Employee("Sulton", 3000000l)
        );

        ComparatorProvider comparatorProvider = new ComparatorProvider();

        list.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee employee1, Employee employee2) {
                return comparatorProvider.compareBySalary(employee1, employee2);
            }
        });

        //lambda
        list.sort((employee1, employee2) -> comparatorProvider.compareBySalary(employee1, employee2));

        //method reference
        list.sort(comparatorProvider::compareBySalary);

        list.sort(ComparatorProviderStatic::compareBySalary);


        System.out.println("");
    }
}

class ComparatorProvider {
    public int compareBySalary(Employee e1, Employee e2){
        return e1.getSalary().compareTo(e2.getSalary());
    }
}

class ComparatorProviderStatic{
    public static int compareBySalary(Employee e1, Employee e2){
        return e1.getSalary().compareTo(e2.getSalary());
    }
}
