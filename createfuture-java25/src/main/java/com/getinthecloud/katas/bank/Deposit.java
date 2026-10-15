package com.getinthecloud.katas.bank;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Deposit(LocalDateTime date, BigDecimal balance) {
}
