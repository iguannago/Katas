package com.getinthecloud.katas.bank;

import java.util.ArrayList;
import java.util.List;

public class RecordedWithdrawals {

    private final List<Withdrawal> recordedWithdrawals = new ArrayList<>();

    public void add(Withdrawal any) {
        recordedWithdrawals.add(any);
    }

    public List<Withdrawal> getRecordedWithdrawals() {
        return recordedWithdrawals;
    }
}
