package com.aktepe.shipment.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Date;

public class Shipping {
    private int saleId;
    private boolean status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date createdAt;

    public Shipping() {
    }

    public Shipping(int saleId, boolean status, Date createdAt) {
        this.saleId = saleId;
        this.status = status;
        this.createdAt = createdAt;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Shipping{" +
                "saleId='" + saleId + '\'' +
                ", status=" + status +
                ", createdAt=" + createdAt +
                '}';
    }
}
