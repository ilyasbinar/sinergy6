package com.example.school.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private Integer schoolId;
}