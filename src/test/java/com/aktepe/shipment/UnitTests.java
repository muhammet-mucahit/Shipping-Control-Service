package com.aktepe.shipment;

import com.aktepe.shipment.entity.Product;
import com.aktepe.shipment.entity.Sale;
import com.aktepe.shipment.entity.Shipping;
import com.aktepe.shipment.error.MyNotFoundError;
import com.aktepe.shipment.service.OtherServices;
import com.aktepe.shipment.controller.ShippingController;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThatObject;

public class UnitTests {
    private final int saleId = 3;
    private final int productId = 15;

    private Sale expectedSale;
    private Product expectedProduct;

    private Date createdAt;
    private Shipping expectedShipping;


    @Autowired
    private ShippingController service;

    @BeforeEach
    void setUp() throws ParseException {
        expectedSale = new Sale(saleId, "0c784421-3cbb-4566-ab72-06628413758b", productId);
        expectedProduct = new Product(productId, "Beauty", "Generic Concrete Ball", "113.00", "https://s3.amazonaws.com/uifaces/faces/twitter/petar_prog/128.jpg");
        createdAt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse("2020-01-19T13:06:34.419Z");
        expectedShipping = new Shipping(saleId, false, createdAt);
    }

    @Test
    void testSaleService() {
        Sale actualSale = OtherServices.getSale(saleId);
        assertThatObject(actualSale).isEqualToComparingFieldByField(expectedSale);
    }

    @Test
    void testSaleServiceBadStory() {
        Assertions.assertThrows(MyNotFoundError.class, () -> OtherServices.getSale(90));
    }

    @Test
    void testProductService() {
        Product actualProduct = OtherServices.getProduct(productId);
        assertThatObject(actualProduct).isEqualToComparingFieldByField(expectedProduct);
    }

    @Test
    void testProductServiceBadStory() {
        Assertions.assertThrows(MyNotFoundError.class, () -> OtherServices.getProduct(90));
    }

    @Test
    void testShippingService() {
        Shipping expectedShipping = new Shipping(saleId, false, createdAt);
        Shipping actualShipping = OtherServices.getShipping(saleId);
        assertThatObject(actualShipping).isEqualToComparingFieldByField(expectedShipping);
    }

    @Test
    void testShippingServiceBadStory() {
        Assertions.assertThrows(MyNotFoundError.class, () -> OtherServices.getShipping(90));
    }

    @AfterEach
    void tearDown() {
        expectedSale = null;
        expectedProduct = null;
        expectedShipping = null;
    }
}
