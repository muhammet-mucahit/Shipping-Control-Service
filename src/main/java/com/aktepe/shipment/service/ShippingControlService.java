package com.aktepe.shipment.service;

import com.aktepe.shipment.entity.Product;
import com.aktepe.shipment.entity.Sale;
import com.aktepe.shipment.entity.Shipping;
import com.aktepe.shipment.entity.ShippingControl;
import org.springframework.stereotype.Service;

@Service
public class ShippingControlService {
    public ShippingControl getShippingInfo(int saleId) {
        Sale sale = OtherServices.getSale(saleId);
        Product product = OtherServices.getProduct(sale.getProductId());
        Shipping shipping = OtherServices.getShipping(saleId);
        ShippingControl shippingControl = new ShippingControl(shipping.getStatus(), sale, product);

        return shippingControl;
    }
}