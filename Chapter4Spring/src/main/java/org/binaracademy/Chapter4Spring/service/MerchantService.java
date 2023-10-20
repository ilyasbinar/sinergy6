package org.binaracademy.Chapter4Spring.service;

import org.binaracademy.Chapter4Spring.model.Merchant;
import org.binaracademy.Chapter4Spring.repository.MerchantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.List;

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

        merchant.setOpen(true);
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
}
