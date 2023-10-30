package org.binaracademy.Chapter4Spring.service;

import org.binaracademy.Chapter4Spring.model.Product;
import org.binaracademy.Chapter4Spring.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private void checkout(User user, List<Product> productList){
        /*
         - Mengubah status order
         - Mengubah stok per produk dikurangi jumlah orderan
         - History pesanan di insert
         - Update saldo di tabel gopay
         */

    }
}
