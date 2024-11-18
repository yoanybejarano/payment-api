package com.hatefulbug.payment.api.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "audit_logs")
public class AuditLog {
    @Id
    @Column(name = "LogID", nullable = false)
    private Integer id;

    @Column(name = "Action", nullable = false, length = 100)
    private String action;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "UserID", nullable = false)
    private User user;

    @Lob
    @Column(name = "Details")
    private String details;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "Timestamp")
    private Instant timestamp;

}