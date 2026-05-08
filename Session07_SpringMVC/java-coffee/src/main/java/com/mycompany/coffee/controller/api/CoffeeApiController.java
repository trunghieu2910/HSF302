package com.mycompany.coffee.controller.api;

import com.mycompany.coffee.entity.Coffee;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController // phục vuh các URL muốn lấy data thô JSON ,
// nhận JSON từ trang web gửi nên
// thường bạn sẽ thấy URL API nó tâchs hẳn url của web thuần
// https:..../api/v1/??
//           /api/v2/??
@RequestMapping("/api/v1")
public class CoffeeApiController {
    @GetMapping("/cup") // http://localhost:8080/api/v1/cup
    public Coffee getACup() {
        return new Coffee("CF005", "Cà phê  toping JSON ", 29_000); // lấy từ db nên qua service gọi repository --> JPA ---> Hibernate---> JDBC --> TABLE
    }// GỌI JACKSON để convertObject --> JSON

    // data thôi  -- WebAPI : gọi hàm qua url  trả về JSON
    //Swagger UI : ĐỂ TEST API
// MUỐN GỬI DATA JSON TỪ TRÌNH DUYỆT NÊN
    @PostMapping("/add")
    public Coffee addACup(@RequestBody Coffee cup) {
        // sửa obejct đã nhận và trả về
        String oldName = cup.getName();
        cup.setName(oldName + "Tên đã chỉnh sửa thông tin");
        return cup; // trả về data đã lưu
    }
}
