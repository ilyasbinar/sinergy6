package org.binaracademy.chapter3db.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "karyawan")
public class Karyawan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdDate;
    private LocalDateTime deletedDate;
    private LocalDateTime updatedDate;

    private String alamat;
    private LocalDate dob;
    @Column(length = 100)
    @Max(100)
    private String name;
    private String status;

    public Karyawan(String name, LocalDate dob) {
        this.dob = dob;
        this.name = name;
    }

    public void print() {
        System.out.println("Nama: "+ name+". Tanggal Lahir: "+dob+" Created Date: "+createdDate);
    }

    //todo: implementasi relasi ke detail karyawan

}
