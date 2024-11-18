package com.hatefulbug.payment.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "payment_methods")
public class PaymentMethod {
    @Id
    @Column(name = "PaymentMethodID", nullable = false)
    private Integer id;

    @Column(name = "MethodName", nullable = false, length = 50)
    private String methodName;

    @Column(name = "Description")
    private String description;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "CreatedAt")
    private Instant createdAt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "UpdatedAt")
    private Instant updatedAt;

}