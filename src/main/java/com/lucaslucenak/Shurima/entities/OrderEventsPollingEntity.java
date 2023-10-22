package com.lucaslucenak.Shurima.entities;

import java.time.OffsetDateTime;
import java.util.UUID;

public class OrderEventsPollingEntity {
    private UUID id;
    private String code;
    private String fullCode;
    private UUID orderId;
    private UUID merchantId;
    private OffsetDateTime createdAt;

    public OrderEventsPollingEntity() {
    }

    public OrderEventsPollingEntity(UUID id, String code, String fullCode, UUID orderId, UUID merchantId, OffsetDateTime createdAt) {
        this.id = id;
        this.code = code;
        this.fullCode = fullCode;
        this.orderId = orderId;
        this.merchantId = merchantId;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullCode() {
        return fullCode;
    }

    public void setFullCode(String fullCode) {
        this.fullCode = fullCode;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public UUID getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(UUID merchantId) {
        this.merchantId = merchantId;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
