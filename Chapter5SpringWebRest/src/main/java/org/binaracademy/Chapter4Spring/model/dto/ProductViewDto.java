package org.binaracademy.Chapter4Spring.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.binaracademy.Chapter4Spring.model.Merchant;

@Getter
@EqualsAndHashCode
public class ProductViewDto {
    @JsonProperty("nama")
    private String name;

    @JsonProperty("harga")
    private long price;



    //Dibawah akan lebih detail dibahas di topik selanjutnya
    @JsonProperty("nama_toko")
    private String merchantName;

    @JsonIgnore
    private Merchant merchant;

    public String getMerchantName(){
        return merchant.getName();
    }
}
