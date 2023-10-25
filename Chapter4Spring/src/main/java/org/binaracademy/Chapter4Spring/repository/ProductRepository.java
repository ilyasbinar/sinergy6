package org.binaracademy.Chapter4Spring.repository;

import org.binaracademy.Chapter4Spring.model.Merchant;
import org.binaracademy.Chapter4Spring.model.Product;
import org.binaracademy.Chapter4Spring.model.dto.ProductEditNameDto;
import org.binaracademy.Chapter4Spring.model.dto.ProductViewDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
//
//    List<Product> findAllByPriceGreaterThan(long price);
//
//    //JPQL
//    @Query("select p from Product p where p.price > ?1")
//    List<ProductViewDto> findAllByPriceGreaterThanViewDTO(long price);
//
//    //SQL native
//    @Query(value = "select * from product where price > ?1", nativeQuery = true)
//    List<ProductViewDto> findAllByPriceGreaterThanViewDTONative(long price);
//
//    /*
//        problem: mendapatkan daftar nama dan harga produk dari yang tokonya sedang buka
//        Solusi:
//        I.  1. dapatkan toko2 yang sedang buka
//            2. dapatkan produk dari toko-toko tersebut
//            3. Entity mapping ke DTO
//
//        II. dapatkan produk2 yang tokonya sedang buka dengan join query
//            + terapkan DTO projection
//            - JPQL
//            - Native query
//
//     */
//
//
//
//    List<Product> findAllByMerchant(List<Merchant> merchantList);
//
//    //EntityProjection
//    @Query("select p from Product p JOIN p.merchant m where m.open is true")
//    List<Product> findByOpenMerchantJPQL();
//
//    //DTOProjection
//    @Query("select p from Product p JOIN p.merchant m where m.open is true")
//    List<ProductViewDto> findByOpenMerchantProductViewDto();
//
//    //DTOProjection
//    @Query("select p from Product p JOIN p.merchant m where m.open is true")
//    List<ProductEditNameDto> findByOpenMerchantProductEditNameDto();
//
//    //Dynamic Projection
//    @Query("select p from Product p JOIN p.merchant m where m.open is true")
//    <T> List<T> findByOpenMerchant(Class<T> type);
//
//
//    @Query("select p from Product p JOIN p.merchant m " +
//            "where m.open is true AND p.price < ?1")
//    List<Product> findByOpenMerchantAndPriceCheaper(long priceLimit);
//
//
//    @Query("select p from Product p JOIN p.merchant m " +
//            "where m.open is true AND p.price < ?1")
//    <T> Collection<T> findByOpenMerchantAndPriceCheaper(long priceLimit, Class<T> type);
//
//
//    @Query(value = "select p.* from product p \n" +
//            "join merchant m on p.merchant_id =m.id \n" +
//            "where m.open is true", nativeQuery = true)
//    List<Product> findByOpenMerchantNative();
//
    List<Product> findAllByNameLike(String name, Pageable pageable);
}
