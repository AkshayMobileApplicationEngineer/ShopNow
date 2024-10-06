package com.example.ecomm;

public class Product_model {

    public int product_imag;
    public String product_name, product_price,discount,product_stock;


    public Product_model(int product_imag, String product_name, String product_price,String discount,String product_stock){
        this.product_imag=product_imag;
        this.product_name=product_name;
        this.product_price=product_price;
        this.product_stock=product_price;
        this.discount=discount;

    }
}
