package org.example.view;

import org.example.model.Departement;
import org.example.model.Employee;
import org.example.service.DepartementService;
import org.example.utils.Constant;

import java.util.List;
import java.util.Map;

public class EmployeeView {
    public void tableEmployee(List<Employee> employees){
        if(employees.isEmpty()){
            System.out.println("Maaf belum ada pegawai yang terdaftar pada sistem.");
        }else{
            StringBuilder sb = new StringBuilder();
            sb.append(Constant.LINE_30C).append(Constant.NEW_LINE)
                    .append("Daftar Pegawai Binar").append(Constant.NEW_LINE)
                    .append("Nama").append(Constant.TAB2).append(Constant.PIPE_LINE).append("NIP")
                        .append(Constant.NEW_LINE);
            for (Employee e:employees){
                sb.append(e.getName()).append(Constant.TAB2).append(Constant.PIPE_LINE).append(e.getEmpId())
                        .append(Constant.NEW_LINE);
            }
            System.out.println(sb);
        }

    }

    public void fieldName() {
        System.out.print("Nama: ");
    }

    public void fieldEmpId() {
        System.out.print("NIP: ");
    }

    public void fieldAddress() {
        System.out.print("Alamat: ");
    }

    public void fieldDepartement() {
        DepartementService ds = new DepartementService();
        Map<Integer, Departement> departementMap = ds.getDepartements();
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Integer, Departement> entry:departementMap.entrySet()){
            sb.append(entry.getKey()).append(". ").append(entry.getValue().getName()).append(Constant.NEW_LINE);
        }
        System.out.print(sb);
        System.out.print("Pilih Departemen: ");
    }

    public void inputEmpIdForm() {
        System.out.print("Silakan input NIP pegawai: ");
    }

    public void showEmployee(Employee employee) {
        StringBuilder sb = new StringBuilder();


//        String address ="";
//        if(employee.getAddress()!=null) address = employee.getAddress();
//        else address = "N/A";

//        String address = employee.getAddress()!=null?employee.getAddress():"N/A";

//        String address = employee.getAddressOptional().orElse("N/A");
        String address = employee.getAddress();
        address = address.toUpperCase();


        sb.append("Nama\t\t:"+employee.getName()).append(Constant.NEW_LINE)
                .append("NIP\t\t\t:"+employee.getEmpId()).append(Constant.NEW_LINE)
                .append("Alamat\t\t:"+address).append(Constant.NEW_LINE)
                .append("Departemen\t:"+employee.getDepartement().getName());
        System.out.println(sb);
    }
}
