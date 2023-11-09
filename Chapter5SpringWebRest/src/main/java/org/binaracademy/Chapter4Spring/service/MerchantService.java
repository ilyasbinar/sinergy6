package org.binaracademy.Chapter4Spring.service;

import org.binaracademy.Chapter4Spring.exception.GlobalException;
import org.binaracademy.Chapter4Spring.exception.MerchantNotFound;
import org.binaracademy.Chapter4Spring.model.Merchant;
import org.binaracademy.Chapter4Spring.model.dto.MerchantEditNameDto;
import org.binaracademy.Chapter4Spring.repository.MerchantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MerchantService {
    @Autowired
    MerchantRepository merchantRepository;

    private final static Logger logger = LoggerFactory.getLogger(MerchantService.class);

    public List<Merchant> getAll(){
        return merchantRepository.findAll();
    }

    public Merchant create(Merchant merchant) throws InterruptedException {
        //implementasikan logic disini
        StopWatch sw = new StopWatch();
        sw.start();

        merchant.setOpen(false);
        if(merchant.getName().isEmpty()) return null;
        merchant = merchantRepository.save(merchant);
        Thread.sleep(2000);
        sw.stop();
        if(sw.getTotalTimeMillis()>1000) {
            logger.warn("Method running selama >1 detik: " + sw.getTotalTimeMillis() + " ms");
        }

        return merchant;
    }

    public void editStatusMerchantByName(String name, boolean isOpen){
        merchantRepository.editStatusMerchant(name, isOpen);
    }

    public List<Merchant> getOpenMercant(){
        return merchantRepository.findAllByOpen(true);
    }

    public void callProcedure() {
        int jumlah = merchantRepository.getNumberOfMerchantOpen();
        int jumlah1 = merchantRepository.countAllByOpen(true);
    }

    public Merchant getById(UUID idMerchant) {
         Optional<Merchant> merchantOptional = merchantRepository.findById(idMerchant);
         if(merchantOptional.isEmpty()){
             throw new MerchantNotFound();
         }
         return merchantOptional.get();

    }

    public Merchant update(Merchant merchant, UUID idMerchant) {
        merchant.setId(idMerchant);
        return merchantRepository.save(merchant);
    }

    public Merchant updateName(MerchantEditNameDto merchantEditNameDto, UUID idMerchant) {
        Merchant merchant= getById(idMerchant);
        merchant.setName(merchantEditNameDto.getName());
        return merchantRepository.save(merchant);
    }
}
