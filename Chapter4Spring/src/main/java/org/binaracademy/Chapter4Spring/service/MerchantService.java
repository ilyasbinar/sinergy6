package org.binaracademy.Chapter4Spring.service;

import org.binaracademy.Chapter4Spring.model.Merchant;
import org.binaracademy.Chapter4Spring.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantService {
    @Autowired
    MerchantRepository merchantRepository;

    public List<Merchant> getAll(){
        return merchantRepository.findAll();
    }

    public Merchant create(Merchant merchant){
        //implementasikan logic disini
        return merchantRepository.save(merchant);
    }
}
