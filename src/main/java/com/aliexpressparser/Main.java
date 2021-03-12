package com.aliexpressparser;

import com.aliexpressparser.aliexpressresponse.Product;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(final String[] args) throws IOException {
        List<Product> products = new Scraper().getProducts();
        new CsvCreator().write(products,"products.csv");
    }
}
