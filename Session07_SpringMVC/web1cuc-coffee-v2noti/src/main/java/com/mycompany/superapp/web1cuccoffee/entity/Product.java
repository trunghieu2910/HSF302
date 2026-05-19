package com.mycompany.superapp.web1cuccoffee.entity;

import jakarta.persistence.Entity;


// tương lai là entity để luuw xg table , nhưng hôm nay chưa cần
public class Product {
    private String id;
    // nếu key tự tăng thì dùng Long không dùng primitive
    private String name;
    private double price;
// boiler-plate code

    public Product() {
    }

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
