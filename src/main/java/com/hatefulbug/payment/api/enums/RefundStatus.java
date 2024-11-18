package com.hatefulbug.payment.api.enums;

public enum RefundStatus {
    INITIATED("Initiated"),
    PROCESSED("Processed");

    private String status;
    RefundStatus(String status) {
        this.status = status;
    }
}
