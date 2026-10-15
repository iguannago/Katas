package com.getinthecloud.katas.bank;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.*;

class RecordedWithdrawalsTest {


    private final Clock clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());

    @Test
    void shouldRecordWithdrawal() {
        RecordedWithdrawals recordedWithdrawals = new RecordedWithdrawals();
        Withdrawal withdrawal = new Withdrawal(LocalDateTime.now(clock), BigDecimal.valueOf(100));

        recordedWithdrawals.add(withdrawal);

        assertEquals(1, recordedWithdrawals.getRecordedWithdrawals().size());
        assertEquals(LocalDateTime.now(clock), withdrawal.date());
    }

}