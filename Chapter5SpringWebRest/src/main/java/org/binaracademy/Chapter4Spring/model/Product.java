package org.binaracademy.Chapter4Spring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.binaracademy.Chapter4Spring.model.dto.ProductViewDto;

import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "product")
public class Product extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;
    private long price; //boleh 0 tapi gak boleh null

    private boolean available;
    private double discount;

    @ManyToOne(targetEntity = Merchant.class)
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;


    public void fromViewDto(ProductViewDto productViewDto) {
        this.name=productViewDto.getName();
        this.price = productViewDto.getPrice();
    }
}
