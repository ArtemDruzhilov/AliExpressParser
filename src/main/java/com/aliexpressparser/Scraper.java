package com.aliexpressparser;

import com.aliexpressparser.aliexpressresponse.Product;
import com.aliexpressparser.aliexpressresponse.Response;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Scraper {

    private final String baseUrl = "https://gpsfront.aliexpress.com/getRecommendingResults." +
            "do?callback=jQuery18307058025139549018_1615199782261" +
            "&widget_id=5547572&platform=pc&limit=%d&offset=%d&phase=1" +
            "&productIds2Top=&postback=6db68f17-f5c8-43aa-b225-8ae1be3f8c9a&_=1615199835743";

    public List<Product> getProducts() {
        final List<Product> products = new ArrayList<Product>();
        final int stepSize = 10;
        for (int startIndex = 0; startIndex < 100; startIndex += stepSize) {
            System.out.print("Request for product data with indices from "+startIndex+" to "+(startIndex+stepSize)+".");
            List<Product> someProducts =getSomeProducts(stepSize, startIndex);
            System.out.println(" Data received for "+someProducts.size()+" products.");
            products.addAll(someProducts);
            wait(1000);
        }
        return products;
    }

    private List<Product> getSomeProducts(final int number, final int startIndex) {
        final String url = String.format(baseUrl, number, startIndex);
        final List<Product> products = new ArrayList<Product>();
        final HttpGet request = new HttpGet(url);
        try (final CloseableHttpClient httpClient = HttpClients.createDefault();
             final CloseableHttpResponse response = httpClient.execute(request)) {
            final HttpEntity entity = response.getEntity();
            if (entity != null) {
                products.addAll(parse(EntityUtils.toString(entity)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    private List<Product> parse(final String txt) {
        final int p1 = txt.indexOf("{");
        final int p2 = txt.lastIndexOf("}");
        final String json = txt.substring(p1, p2 + 1);
        final Gson gson = new Gson();
        final Response response = gson.fromJson(json, Response.class);
        return Arrays.asList(response.getResults());
    }

    private void wait(final int nMills) {
        try {
            Thread.sleep(nMills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
