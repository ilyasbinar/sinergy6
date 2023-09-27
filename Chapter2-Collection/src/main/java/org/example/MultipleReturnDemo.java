package org.example;

public class MultipleReturnDemo {

    // Thanks mas Andhika :)
    public static Object[] objectArray(){
        Object[] oArr = new Object[4];
        oArr[0] = "String";
        oArr[1] = 1;
        oArr[2] = 'c';
        oArr[3] = new Employee("111111", "Fulan", "081214124", 100000);
        return oArr;
    }
}
