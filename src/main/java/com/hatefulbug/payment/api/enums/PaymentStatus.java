package com.hatefulbug.payment.api.enums;

public enum PaymentStatus {
    PENDING("Pending"),
    COMPLETED("Completed"),
    FAILED("Failed");

    private String status;
    PaymentStatus(String value) {
        this.status = value;
    }
}
