package com.hatefulbug.payment.api.service;

import com.hatefulbug.payment.api.model.AuditLog;
import com.hatefulbug.payment.api.request.PartialAuditLog;

import java.util.Date;
import java.util.List;

public interface AuditLogService {
    void createAuditLog(PartialAuditLog auditLogData);
    List<AuditLog> getLogsByDateRange (Date from, Date to);
    List<AuditLog> getLogsByUser(int userId);
}
