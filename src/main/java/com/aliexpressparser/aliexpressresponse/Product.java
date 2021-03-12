package com.aliexpressparser.aliexpressresponse;

public class Product {
    private String oriMinPrice;
    private String oriMaxPrice;
    private String productTitle;
    private String minPrice;
    private String maxPrice;
    private double discount;
    private String productDetailUrl;
    private double productPositiveRate;
    private double productAverageStar;
    private int itemEvalTotalNum;

    public String[] getMainElements() {
        final String[] mainElements = new String[10];
        mainElements[0] = productTitle;
        mainElements[1] = oriMinPrice;
        mainElements[2] = oriMaxPrice;
        mainElements[3] = minPrice;
        mainElements[4] = maxPrice;
        mainElements[5] = Double.toString(discount);
        mainElements[6] = Integer.toString(itemEvalTotalNum);
        mainElements[7] = Double.toString(productPositiveRate);
        mainElements[8] = Double.toString(productAverageStar);
        mainElements[9] = productDetailUrl;
        return mainElements;
    }
}
