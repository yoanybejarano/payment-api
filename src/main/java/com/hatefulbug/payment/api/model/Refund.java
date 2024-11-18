package com.hatefulbug.payment.api.model;

import com.hatefulbug.payment.api.enums.RefundStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "refunds")
public class Refund {
    @Id
    @Column(name = "RefundID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PaymentID", nullable = false)
    private Payment payment;

    @Column(name = "RefundAmount", nullable = false, precision = 10, scale = 2)
    private BigDecimal refundAmount;

    @Lob
    @Column(name = "RefundReason")
    private String refundReason;

    @ColumnDefault("'Initiated'")
    @Enumerated(EnumType.STRING)
    @Column(name = "RefundStatus")
    private RefundStatus refundStatus;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "RefundDate")
    private Instant refundDate;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "CreatedAt")
    private Instant createdAt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "UpdatedAt")
    private Instant updatedAt;

}