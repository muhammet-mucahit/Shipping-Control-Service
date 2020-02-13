package com.aktepe.shipment.entity;

/*

{
 "status": "TESLİM EDİLDİ",
 "sale": {
 "id": 3,
 "code": "bf610641-da64-4153-ad34-0aadf7a993e1"
 },
 "product": {
 "id": 1,
 "name": "Tasty Frozen Keyboard",
 "price": 150.00
 }
}

 */
public class ShippingControl {
    private String status;
    private Sale sale;
    private Product product;

    public ShippingControl(boolean status, Sale sale, Product product) {
        this.status = status ? "TESLİM EDİLDİ" : "TESLİM EDİLMEDİ";
        this.sale = sale;
        this.product = product;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ShippingControl{" +
                "status='" + status + '\'' +
                ", sale=" + sale +
                ", product=" + product +
                '}';
    }
}
