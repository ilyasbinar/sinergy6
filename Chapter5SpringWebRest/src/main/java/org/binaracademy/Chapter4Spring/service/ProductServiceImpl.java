package org.binaracademy.Chapter4Spring.service;

import org.binaracademy.Chapter4Spring.model.Merchant;
import org.binaracademy.Chapter4Spring.model.Product;
import org.binaracademy.Chapter4Spring.model.dto.ProductEditNameDto;
import org.binaracademy.Chapter4Spring.model.dto.ProductViewDto;
import org.binaracademy.Chapter4Spring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    MerchantService merchantService;
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getFromMerchant(List<Merchant> merchantList) {
        return null;// productRepository.findAllByMerchant(merchantList);
    }

    @Override
    public List<Product> getFromOpenMerchant() {
        List<Product> productList =null;// productRepository.findByOpenMerchantJPQL();
//
//        List<Product> productList1 = productRepository.findByOpenMerchant(Product.class);
//        List<ProductViewDto> productList3 = productRepository.findByOpenMerchant(ProductViewDto.class);
//        List<ProductEditNameDto> productList4 = productRepository.findByOpenMerchant(ProductEditNameDto.class);

        return productList;
    }

    public List<Product> getByName(String name, int page, int size){
        Page<Product> productPage = productRepository.findAll(PageRequest.of(page, size,
                Sort.by("name")));

        Pageable pageable = PageRequest.of(0, 10, Sort.by("name"));
        List<Product> productsList = productRepository.findAllByNameLike(name, pageable);
        return productsList;
    }

    @Override
    public List<ProductViewDto> getFromOpenMerchantViewDto() {
        ProductViewDto productViewDto = new ProductViewDto();
        Product product =new Product();
            product.fromViewDto(productViewDto);
        productRepository.save(product);

        List<Product> productList = null;// productRepository.findByOpenMerchant(Product.class);
        List<ProductViewDto> productViewDtoList = null;//productRepository.findByOpenMerchant(ProductViewDto.class);
        List<ProductEditNameDto> ProductEditNameDtoList = null;//productRepository.findByOpenMerchant(ProductEditNameDto.class);


        return null;//productRepository.findByOpenMerchantProductViewDto();
    }

    @Override
    public boolean areAllAvailable(List<Product> productList) {
        //cek merchant open and product available
        for(Product p: productList){
            if(p.getMerchant().isOpen()){
                return false;
            }
            if(!p.isAvailable()){
                return false;
            }
        }

        return true;
    }
}
