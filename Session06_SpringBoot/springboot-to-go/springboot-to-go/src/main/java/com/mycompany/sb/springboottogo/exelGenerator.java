package com.mycompany.sb.springboottogo;

import org.springframework.stereotype.Component;

@Component
public class exelGenerator {
    public void generateFile(String filename) {
        // Logic to generate an Excel file
        System.out.println("Generating Excel file: " + filename);
    }
}
