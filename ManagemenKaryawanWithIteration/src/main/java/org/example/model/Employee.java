package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Setter
@Getter
@NoArgsConstructor
public class Employee {
    private String empId;
    private String name;
    private String address;
    private Departement departement;

    public Optional<String> getAddressOptional(){
        return Optional.ofNullable(address);
    }
}
