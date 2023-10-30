package org.binaracademy.Chapter4Spring.controller;

import jakarta.validation.Valid;
import org.binaracademy.Chapter4Spring.model.Merchant;
import org.binaracademy.Chapter4Spring.model.dto.MerchantEditNameDto;
import org.binaracademy.Chapter4Spring.service.MerchantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("merchants")
public class MerchantController {

    private final MerchantService merchantService;

    @Autowired
    public MerchantController(MerchantService merchantService){
        this.merchantService=merchantService;
    }

    private final static Logger logger = LoggerFactory.getLogger(MerchantController.class);

    @GetMapping("hello")
    public String helloWorld(){
        return "Hello world";
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAll(){
        Map<String, Object> response  = new HashMap<>();
        response.put("status", "success");

        Map<String, Object> data = new HashMap<>();
        data.put("merchants", merchantService.getAll());
        response.put("data", data);

        response.put("total-row", 100);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public Merchant add(@RequestBody @Valid Merchant merchant) throws InterruptedException {
        return merchantService.create(merchant);
    }

    @GetMapping("{id}")
    public Merchant show(@PathVariable("id") UUID idMerchant){
        return merchantService.getById(idMerchant);
    }

    @PutMapping("{id}")
    public Merchant put(@PathVariable("id") UUID idMerchant,
                        @RequestBody Merchant merchant){
        return merchantService.update(merchant, idMerchant);
    }

    @PatchMapping("{id}")
    public Merchant patch(@PathVariable("id") UUID idMerchant,
                        @RequestBody @Valid MerchantEditNameDto merchantEditNameDto){
        return merchantService.updateName(merchantEditNameDto, idMerchant);
    }
}
