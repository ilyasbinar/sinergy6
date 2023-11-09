package org.binaracademy.Chapter4Spring.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import net.sf.jasperreports.engine.JRException;
import org.binaracademy.Chapter4Spring.model.Item;
import org.binaracademy.Chapter4Spring.model.Merchant;
import org.binaracademy.Chapter4Spring.model.Order;
import org.binaracademy.Chapter4Spring.model.Product;
import org.binaracademy.Chapter4Spring.model.dto.MerchantEditNameDto;
import org.binaracademy.Chapter4Spring.model.dto.MerchantReportDto;
import org.binaracademy.Chapter4Spring.model.dto.MerchantReportMonthDto;
import org.binaracademy.Chapter4Spring.service.JasperReportService;
import org.binaracademy.Chapter4Spring.service.MerchantService;
import org.binaracademy.Chapter4Spring.service.OrderService;
import org.binaracademy.Chapter4Spring.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("merchants")
public class MerchantController {

    private final MerchantService merchantService;
    private final OrderService orderService;

    private final ProductService productService;

    private final JasperReportService jasperReportService;



    @Autowired
    public MerchantController(MerchantService merchantService, OrderService orderService,
                              ProductService productService, JasperReportService jasperReportService){
        this.merchantService=merchantService;
        this.orderService = orderService;
        this.productService = productService;
        this.jasperReportService = jasperReportService;
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
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Merchant ditemukan",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Merchant tidak ditemukan",
                    content = {@Content(mediaType = "application/json")})
    })
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

    //mingguan -> date
    //bulanan -> november 2023 : 2023-11   11-2023   2023/11 YYYY-MM-DD
    //custom -> startDate dan endDate

    @PostMapping("reporting1/{id}")
    public String generateReporting1(@PathVariable("id") UUID idMerchant,
                                     @RequestBody @Valid MerchantReportMonthDto merchantReportMonthDto){
        //disini kita bisa dapat informasi merchantId dari user yang login.

        //dapatkan datanya
        List<Order> orderMerchant = orderService.getOrderByMerchantAndMonth(idMerchant, merchantReportMonthDto);

        //proses dengan jasper report

        //return pdf

        return null;
    }
//    @PostMapping("reporting1/{id}")
//    public String generateReporting1(@PathVariable("id") UUID idMerchant,
//                        @RequestBody @Valid MerchantReportDto merchantReportDto){
//        //disini kita bisa dapat informasi merchantId dari user yang login.
//
//        /*
//            Response Login:
//            - token
//            - username
//            - role:admin | merchant | user
//            - informasi merchant: merchant_id, merchant_name
//
//           http://binarfud/products
//
//           productsByMerchantId
//
//         */
//
//        //dapatkan datanya
//        List<Order> orderMerchant = orderService.getOrderByMerchantAndDateRange(idMerchant, merchantReportDto);
//
//        //proses dengan jasper report
//
//        //return pdf
//
//        return null;
//    }
//
//    @PostMapping("reporting2/{id}/{startDate}/{endDate}")
//    public String generateReporting2(@PathVariable("id") UUID idMerchant,
//                                     @PathVariable("startDate") long startDate,
//                                     @PathVariable("endDate") UUID endDate){
//        //disini kita bisa dapat informasi merchantId dari user yang login.
//
//        return null;
//    }

    @GetMapping("reporting/product/{id}/{format}")
    public ResponseEntity<Resource> generateReportingProduct(@PathVariable("id") UUID idMerchant,
                                                             @PathVariable String format){
        //dapatkan data
        Merchant merchant = merchantService.getById(idMerchant);
        List<Product> products = merchant.getProductList();

        //olah data di jasper
        byte[] reportContent = jasperReportService.getProductMerchantReport(products, format);

        //response sebagai file
        ByteArrayResource resource = new ByteArrayResource(reportContent);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(resource.contentLength())
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        ContentDisposition.attachment()
                                .filename("item-report." + format)
                                .build().toString())
                .body(resource);
    }
}
