package com.aktepe.shipment.controller;

import com.aktepe.shipment.entity.ShippingControl;
import com.aktepe.shipment.service.ShippingControlService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
public class ShippingController {

    private final ShippingControlService shippingControlService;

    public ShippingController(ShippingControlService shippingControlService) {
        this.shippingControlService = shippingControlService;
    }

    @GetMapping(value = "/sale/{saleId}/shipping", produces = APPLICATION_JSON_VALUE)
    public ShippingControl getShippingInfo(@PathVariable int saleId) {
        return shippingControlService.getShippingInfo(saleId);
    }
}