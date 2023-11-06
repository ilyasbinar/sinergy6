package org.binaracademy.Chapter4Spring.service;

import org.binaracademy.Chapter4Spring.model.Order;
import org.binaracademy.Chapter4Spring.model.OrderDetail;
import org.binaracademy.Chapter4Spring.model.Product;
import org.binaracademy.Chapter4Spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerCheckoutService {
    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;

    private void checkout(Order order){
        /*
         - Mengubah status order
         - Mengubah cek apakah ada stok
         - History pesanan di insert
         - Update saldo di tabel gopay
         */

        List<Product> productList = new ArrayList<>();
        for(OrderDetail orderDetail: order.getOrderDetailList()){
            productList.add(orderDetail.getProduct());
        }

        if(!productService.areAllAvailable(productList));{
            throw new RuntimeException();
        }
//        orderService.changeStatus(order);


    }
}
