package com.mycompany.coffee.controller.web;

import com.mycompany.coffee.entity.Coffee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// trả về trang web đẹp
@Controller
// 1 bean đc tự new tự động bưởi cotainer chuyên tar lười các HTTP REQUEST TỪ URL của trình đuyệt người dùng
// có nhiều URL khác nhau thì ứng vưới nhiều hàm , method khác nhau
// các hàm trả về HTML trang wbe
public class CoffeWebController {
    @GetMapping("/") // user gõ< localhost:8080/ > thì sẽ vào hàm này
    public String Home(Model model) {
        model.addAttribute("cup1", "Cà phê sữa đá");
        model.addAttribute("cup2", new Coffee("CF001", "đối tượng Cà phê đen ", 29_000));
        return "index"; // trả về tên trang  cho trình duyệt
    }
    //==> HÌnh thành mô hình MVC : tại controller này hàm home đã đổ dữ liệu vào model và trả dữ liệu đó ở 1 trang html (view)
}
