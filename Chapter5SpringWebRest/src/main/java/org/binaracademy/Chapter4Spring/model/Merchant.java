package org.binaracademy.Chapter4Spring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "merchant")
public class Merchant extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String location;
    private boolean open;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "merchant")
    private List<Product> productList;

    public void print() {
        System.out.println("Nama: "+name +". Location: "+location+". Buka: "+openLabel());
    }

    private String openLabel() {
        return open? "Ya":"Tidak";
    }
}
