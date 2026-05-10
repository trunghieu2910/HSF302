package com.mycompany.superapp.web1cuccoffee.controller;
// class nnayf sẽ lo các xử lý liên quan đến sản phẩm - product bao gồm CRUD product
// Xử lý request - response nhưng ử góc độ request-response
// NÓ NẮNG NGHE CÁC URL VÀ XEM URL NÀO PHÙ HỢP VỚI NÓ THÌ GỌI -- METHOD MAPPING VỚI URL !!!
// 2 VIỆC  :  NÓ PHẢI NẮNG NGHE URL  , NGHE XONG GỌI ĐÚNG HÀM TƯƠNG ỨNG VỚI URL ĐÓ
// VIỆC  0 :  NÓ PHẢI LÀ 1 BEAN ĐƯỢC NEW TỰ ĐỘNG , VÀO RAM VÀ NGHE
// VIỆC 1 : NGHE -
// VIỆC 2 : NGHE HAMF NÀO MAP VỚI HÀM NÀO  ? -- TRẢ VỀ HTML

import com.mycompany.superapp.web1cuccoffee.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

// QUAN TRỌNG : 1 URL GET   --> Ứng với 1 hàm returrn " tên trang HTML nào đó "
@Controller
public class ProductController {
    @RequestMapping("/products") // URL nào thì gọi hàm này
  // @GetMapping("/products") // URL nào thì gọi hàm này
    public  String list(Model model){ // ta sẽ nhét data vào model

        // showw all product
        model.addAttribute("msg", "Hi admins !");
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("1", "Cà phê sữa đá",10000));
        productList.add(new Product("2", "Cà phê đen đá",9000));
        productList.add(new Product("3", "Cà phê sữa nóng",12000));
        model.addAttribute("products", productList);

        return "products";
    }
    //TRƯỚC KHI THỰC THI LỆNH RETURN CHO URL GET... THÌ SPRING NÓ SẼ ĐÍNH KÈM , CÁI THÙNG ĐỒ VÀO CÙNG TRANG TRẢ VỀ, VÀ ĐƯA TÊN TRANG + THÙNG ĐỒ CHO THYMELEAF MIX, TRỘN, RENDER"
    // LÀM SAO NHÉT DATA VÀ THÙNG VÀ LẤY RA
    // CONTROLLER NHÉT ĐỒ VÀO THÙNG
    // TRANG WEB HTML/THEMELEAF LẤY ĐỒ TỪ THÙNG RA HIỂN THỊ
    // LOGIC NHƯ SAU :
}
