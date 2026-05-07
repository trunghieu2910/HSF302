package com.mycompany.spring.ioc.v1scan;

import org.springframework.stereotype.Component;

@Component // nghĩa là đây là 1 object (bean) sẽ đc tuẹ động new bởi thư viện Spring , SpringContext
//@Service (cho class service)  @Repository (cho class repo)   cũng đc luôn , 2 thằng này là con của @Component
// --> nó gắn ý nghĩa với từng tầng trong code / nếu chia code theo từng tầng thì nên để cụ thể
public class PdfGenerator {
    public void generateFile(String fileName){
        //TODO : LOGIC XỬ LÝ IN RA FILE PDF
        System.out.println("(V1)The pdf file " +fileName+ " created successfully");
    }
}
