package org.example;

import org.example.service.PriceService;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        System.out.println("Lambda");

        //Consumer
        Consumer<String> consumer =  t-> System.out.println(t);
        consumer.accept("Ini adalah consumer");

        //BiConsumer
        BiConsumer<String, Integer> biConsumer = (a, b) -> System.out.println("Nama saya: "+a+" umur saya "+b);
        biConsumer.accept("Ilyas", 35);

        //Supplier
        Supplier<String> supplier = () -> "Ini suplier";
        supplier.get();

        Predicate<String> predicate = s -> "Ini predicate".length()>5;


        //konvensional
        PriceService priceServiceImpl = new PriceService() {
            @Override
            public Long getPrice(String code) {
                //logic basePrice=-besePrice*discount;
                long basePrice = 5000000;
                long discount =100000;
                return basePrice-discount;
            }
        };
        priceServiceImpl.getPrice("abc");

        //lambda
        PriceService priceServiceImplLambda = code -> {
            long discount =0;
            long basePrice = 5000000;
            discount = code.equals("abc")? 100000:50000;
            return basePrice-discount;
        };
        priceServiceImplLambda.getPrice("abc");

        //Method Reference

        List<String> plList = new ArrayList<>();
        plList.add("Java");
        plList.add("Phyton");
        plList.add("Ruby");

        for(String s:plList){
            System.out.println(s);
        }

        plList.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        //lambda
        plList.forEach(s -> System.out.println(s));

        //method reference static method
        plList.forEach(System.out::println);

        for(String s:plList){
            if(s.length()>4){
                plList.remove(s);
            }
        }

        plList.removeIf(pl -> pl.length()>4);


        List<Employee> employeeList = Arrays.asList(new Employee("aaaa"), new Employee("bbbbb"));
        employeeList.forEach(employee -> System.out.println(employee.getId()));
        employeeList.forEach(employee -> System.out.println(employee.getId().toUpperCase()));

        employeeList.forEach(System.out::println);


        Map<String, Integer> pair = new HashMap<>();
        pair.put("Nasi Goreng", 15000);
        pair.put("Nasi Ayam Goreng", 20000);
        pair.put("Teh Manis", 50000);


        for(Map.Entry<String, Integer> entry: pair.entrySet()){
            System.out.println(entry.getKey()+": "+entry.getValue());
        }

        pair.forEach((key, value) -> System.out.println(key + ": " + value));

    }
}