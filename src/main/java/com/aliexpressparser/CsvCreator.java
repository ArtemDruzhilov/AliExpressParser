package com.aliexpressparser;

import com.aliexpressparser.aliexpressresponse.Product;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvCreator {

    public void write(final List<Product> products, final String path) throws IOException {
        final CSVWriter writer = new CSVWriter(new FileWriter(path));
        final String[] headers = {"Title",
                "Original min price",
                "Original max price",
                "Min price",
                "Max price",
                "Discount, %",
                "Number of reviews",
                "Positive rate",
                "Average star",
                "URL"};
        writer.writeNext(headers);
        products.forEach(p -> writer.writeNext(p.getMainElements()));
        writer.close();
    }
}
