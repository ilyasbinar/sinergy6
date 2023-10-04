package org.example;

import org.example.service.EmployeeService;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        System.out.println("Optional Class in Java");

        Optional<Employee> employeeOptional = Optional.ofNullable(new Employee("11111"));
        createEmployee(employeeOptional);

        if(employeeOptional.isPresent()) {
            createEmployee(employeeOptional.get());
        }

        employeeOptional.ifPresent(Main::createEmployee);


        Employee employee = new Employee("11111");

        if(employee.getAddress() != null){

        }

        if(employee.getAddressOptional().isPresent()){

        }

//        employee.get

//        employee.setAddress("Alamat");

//        String departementName = employee.getDepartement().getName();




        Optional<String> address = Optional.ofNullable(employee.getAddressOptional())
                .orElseGet(()->{
                    //logic
                    return Optional.of("N/A");
                });


        EmployeeService employeeService = new EmployeeService();

//        employeeService.getEmployeeById("1111");

        String address2 = employee.getAddressOptional().orElse("N/A");
        String address3 = Optional.ofNullable(employee.getAddress()).orElse("N/A");

        System.out.println(address3);

        if(employee.getAddress()==null){
            address3 = employee.getAddress();
        }else {
            address3 = "N/A";
        }

        String address4 = Optional.ofNullable(employee.getAddress()).orElseGet(() -> {
            //logic
            String addr = getDefaultAddress();
            return addr;
        });

        System.out.println(address4);

        Integer empId = Optional.ofNullable(employee.getEmpId())
                .map(a -> Integer.valueOf(a))
                .orElse(1111);

        System.out.println(empId);

        String employeeStartWith1 = Optional.ofNullable(employee.getEmpId())
                .filter(employeeId -> employeeId.startsWith("1"))
                .orElse("N/A");

        System.out.println("employeeStartWith1: "+employeeStartWith1);

//        String departementName = Optional.ofNullable(employee.getDepartementOptional().get().getName())
//                .map(a -> a.toLowerCase())
//                .orElse("N/A");
//
//        System.out.println(departementName);
    }

    private static String getDefaultAddress() {
        return "N/A from method";
    }

    public static void createEmployee(Employee employee){
        //logic
    }

    public static void createEmployee(Optional<Employee> employee){
        //logic
    }


}