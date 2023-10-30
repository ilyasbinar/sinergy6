package org.binaracademy.Chapter4Spring.model.dto;

import jakarta.validation.constraints.Max;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class MerchantEditNameDto {
    @Max(50)
    private String name;
}
