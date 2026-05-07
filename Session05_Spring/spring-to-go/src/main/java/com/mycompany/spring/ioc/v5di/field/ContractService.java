package com.mycompany.spring.ioc.v5di.field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("nguyenTrungHieu")
public class ContractService {
    @Autowired
    private PdfGenerator pdfGenerator;

    public void processContract(){
        //TODO : LOGIC
        pdfGenerator.generateFile("(V5)contract.pdf");// có nguy cơ bị null do chưa set
    }
}
