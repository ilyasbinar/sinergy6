package org.binaracademy.Chapter4Spring.repository;


import org.binaracademy.Chapter4Spring.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, UUID> {

    @Procedure("tutup_fajar_cafe")
    void tutupFajarCafe();


    @Procedure("editmerchant")
    void closeMerchantByName(@Param("merchant_name") String name);


    @Procedure("edit_merchant_status")
    void editStatusMerchant(@Param("merchant_name") String name, @Param("is_open") boolean isOpen);

    List<Merchant> findAllByName(String name);
}
