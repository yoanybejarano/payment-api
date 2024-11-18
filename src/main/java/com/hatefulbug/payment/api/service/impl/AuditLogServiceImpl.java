package com.hatefulbug.payment.api.service.impl;

import com.hatefulbug.payment.api.model.AuditLog;
import com.hatefulbug.payment.api.model.User;
import com.hatefulbug.payment.api.repository.AuditLogRepository;
import com.hatefulbug.payment.api.repository.UserRepository;
import com.hatefulbug.payment.api.request.PartialAuditLog;
import com.hatefulbug.payment.api.service.AuditLogService;
import com.hatefulbug.payment.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuditLogServiceImpl implements AuditLogService {
    private final AuditLogRepository logRepository;
    private final UserRepository userRepository;

    @Transactional
    @Override
    public void createAuditLog(PartialAuditLog auditLogData) {
        User user = userRepository.findById(auditLogData.getUserId()).orElseThrow(() -> new RuntimeException(String.format("User with id %s not found", auditLogData.getUserId())));
        if (user != null) {
            AuditLog auditLog = new AuditLog();
            auditLog.setUser(user);
            auditLog.setAction(auditLogData.getAction());
            auditLog.setDetails(auditLogData.getDetails());
            logRepository.save(auditLog);
        }
    }

    @Override
    public List<AuditLog> getLogsByDateRange(Date from, Date to) {
        return logRepository.findAllByTimestampBetween(from.toInstant(), to.toInstant());
    }

    @Override
    public List<AuditLog> getLogsByUser(int userId) {
        return logRepository.findAllByUserId(userId);
    }
}
