package com.aktepe.shipment.service;

import com.aktepe.shipment.entity.Product;
import com.aktepe.shipment.entity.Sale;
import com.aktepe.shipment.entity.Shipping;
import com.aktepe.shipment.error.MyNotFoundError;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class OtherServices {
    static RestTemplate restTemplate = new RestTemplate();

    public static Sale getSale(int saleId) {
        final String uri = "http://5e209e06e31c6e0014c60962.mockapi.io/api/sales/" + saleId;
        Sale sale = null;
        try {
            sale = restTemplate.getForObject(uri, Sale.class);
        } catch (HttpClientErrorException.NotFound e) {
            throw new MyNotFoundError("There is no sale with this saleId!");
        }
        return sale;
    }

    public static Product getProduct(int productId) {
        final String uri = "http://5e209e06e31c6e0014c60962.mockapi.io/api/products/" + productId;
        Product product = null;
        try {
            product = restTemplate.getForObject(uri, Product.class);
        } catch (HttpClientErrorException.NotFound e) {
            throw new MyNotFoundError("There is no product with this productId relevant to this sale!");
        }
        return product;
    }

    public static Shipping getShipping(int saleId) {
        final String uri = "http://5e209e06e31c6e0014c60962.mockapi.io/api/shipping/" + saleId;
        Shipping shipping = null;
        try {
            shipping = restTemplate.getForObject(uri, Shipping.class);
        } catch (HttpClientErrorException.NotFound e) {
            throw new MyNotFoundError("There is no shipping with this saleId!");
        }
        return shipping;
    }
}
