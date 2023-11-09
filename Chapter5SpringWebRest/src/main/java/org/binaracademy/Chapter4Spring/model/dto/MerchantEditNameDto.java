package org.binaracademy.Chapter4Spring.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class MerchantEditNameDto {
//    @Max(50)
    @Size(min = 1, max = 50)
    private String name;
}
