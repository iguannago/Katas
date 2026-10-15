package com.getinthecloud.katas.bank;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Withdrawal(LocalDateTime date, BigDecimal balance) {
}
