package org.binaracademy.Chapter4Spring.service;

import org.binaracademy.Chapter4Spring.model.Merchant;
import org.binaracademy.Chapter4Spring.model.Order;
import org.binaracademy.Chapter4Spring.model.Product;
import org.binaracademy.Chapter4Spring.model.User;
import org.binaracademy.Chapter4Spring.model.dto.MerchantReportDto;
import org.binaracademy.Chapter4Spring.model.dto.MerchantReportMonthDto;
import org.binaracademy.Chapter4Spring.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    MerchantService merchantService;

    @Autowired
    OrderRepository orderRepository;


    public void checkout(){

    }

    public List<Order> getOrderByMerchantAndDateRange(UUID idMerchant, MerchantReportDto merchantReportDto) {
        Merchant merchant = merchantService.getById(idMerchant);
        return orderRepository.getOrderByMerchant(idMerchant);
    }

    public List<Order> getOrderByMerchantAndMonth(UUID idMerchant, MerchantReportMonthDto merchantReportMonthDto) {
        return null;
    }
}
