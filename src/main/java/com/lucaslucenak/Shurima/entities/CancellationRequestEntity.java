package com.lucaslucenak.Shurima.entities;

public class CancellationRequestEntity {

    private String cancellationCode;
    private String reason;

    public CancellationRequestEntity() {
    }

    public CancellationRequestEntity(String cancellationCode, String reason) {
        this.cancellationCode = cancellationCode;
        this.reason = reason;
    }

    public String getCancellationCode() {
        return cancellationCode;
    }

    public void setCancellationCode(String cancellationCode) {
        this.cancellationCode = cancellationCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
