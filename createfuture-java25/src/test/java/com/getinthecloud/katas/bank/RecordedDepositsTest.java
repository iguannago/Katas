package com.getinthecloud.katas.bank;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecordedDepositsTest {

    private final Clock clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());

    @Test
    void addDeposit() {
        RecordedDeposits recordedDeposits = new RecordedDeposits();
        Deposit deposit = new Deposit(LocalDateTime.now(clock), new BigDecimal("10.00"));

        recordedDeposits.add(deposit);

        assertEquals(1, recordedDeposits.getDeposits().size());
        assertEquals(LocalDateTime.now(clock), deposit.date());
        assertEquals(new BigDecimal("10.00"), deposit.balance());
    }

}