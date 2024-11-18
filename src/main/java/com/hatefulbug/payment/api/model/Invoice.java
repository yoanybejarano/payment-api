package com.hatefulbug.payment.api.model;

import com.hatefulbug.payment.api.enums.InvoiceStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "invoices")
public class Invoice {
    @Id
    @Column(name = "InvoiceID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "UserID", nullable = false)
    private User user;

    @Column(name = "TotalAmount", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "InvoiceDate")
    private Instant invoiceDate;

    @Column(name = "DueDate", nullable = false)
    private Instant dueDate;

    @ColumnDefault("'Unpaid'")
    @Enumerated(EnumType.STRING)
    @Column(name = "InvoiceStatus")
    private InvoiceStatus invoiceStatus;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "CreatedAt")
    private Instant createdAt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "UpdatedAt")
    private Instant updatedAt;

}