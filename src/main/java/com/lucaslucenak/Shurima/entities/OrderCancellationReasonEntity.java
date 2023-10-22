package com.lucaslucenak.Shurima.entities;

public class OrderCancellationReasonEntity {

    private String cancelCodeId;
    private String description;

    public OrderCancellationReasonEntity() {
    }

    public OrderCancellationReasonEntity(String cancelCodeId, String description) {
        this.cancelCodeId = cancelCodeId;
        this.description = description;
    }

    public String getCancelCodeId() {
        return cancelCodeId;
    }

    public void setCancelCodeId(String cancelCodeId) {
        this.cancelCodeId = cancelCodeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
