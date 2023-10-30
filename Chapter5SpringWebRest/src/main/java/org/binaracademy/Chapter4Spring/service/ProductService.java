package org.binaracademy.Chapter4Spring.service;

import org.binaracademy.Chapter4Spring.model.Merchant;
import org.binaracademy.Chapter4Spring.model.Product;
import org.binaracademy.Chapter4Spring.model.dto.ProductViewDto;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    List<Product> getFromMerchant(List<Merchant> merchantList);

    List<Product> getFromOpenMerchant();

    List<Product> getByName(String name, int page, int size);

    List<ProductViewDto> getFromOpenMerchantViewDto();
}
