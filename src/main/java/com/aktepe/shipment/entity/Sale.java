package com.aktepe.shipment.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class Sale {
    @ApiModelProperty(notes = "The database generated employee ID")
    private int id;
    private String saleCode;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int productId;

    public Sale() {}

    public Sale(int id, String saleCode, int productId) {
        this.id = id;
        this.saleCode = saleCode;
        this.productId = productId;
    }

    public Sale(String saleCode, int productId) {
        this.saleCode = saleCode;
        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty(value = "code", access = JsonProperty.Access.READ_ONLY)
    public String getSaleCode() {
        return saleCode;
    }

    @JsonProperty(value = "saleCode", access = JsonProperty.Access.WRITE_ONLY)
    public void setSaleCode(String saleCode) {
        this.saleCode = saleCode;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id='" + id + '\'' +
                ", saleCode='" + saleCode + '\'' +
                ", productId=" + productId +
                '}';
    }
}
