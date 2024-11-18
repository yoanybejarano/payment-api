package com.hatefulbug.payment.api.enums;

public enum InvoiceStatus {
    PAID("Paid"),
    UNPAID("Unpaid"),
    OVERDUE("Overdue");

    private String status;
    InvoiceStatus(String status) {
        this.status = status;
    }
}
