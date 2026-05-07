package com.mycompany.spring.ioc.v4di.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("nguyenTrungHieu")
public class ContractService {
    private PdfGenerator pdfGenerator;
    // khôgn làm contructor  thì tự động có CTOR rỗng
@Autowired // CHƠI SETTER BẮT BUỘC PHẢI CÓ AUOTOWIRED
// BTHG NGTA SEẼ ƯA CÁCH ALMF NHƯ V3 HƠN
    public void setPdfGenerator(PdfGenerator pdfGenerator) {
        this.pdfGenerator = pdfGenerator;
    } //-> null problem
    public void processContract(){
        //TODO : LOGIC
        pdfGenerator.generateFile("(V4)contract.pdf");// có nguy cơ bị null do chưa set
    }
}
