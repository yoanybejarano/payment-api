package com.hatefulbug.payment.api.request;

import com.hatefulbug.payment.api.enums.CurrencyType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class PartialPayment {
    private int userId;
    private BigDecimal amount;
    private String currency;
    private int paymentMethodId;
}
