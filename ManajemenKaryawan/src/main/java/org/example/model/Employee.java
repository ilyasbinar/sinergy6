package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "karyawan")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String empId;
    private String name;
    private String address;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "departement_id", referencedColumnName = "id")
    private Departement departement;

    private LocalDateTime createdDate;
}
