package com.getinthecloud.katas.bank;

import java.util.ArrayList;
import java.util.List;

public class RecordedDeposits {
    private final List<Deposit> deposits = new ArrayList<>();

    public void add(Deposit deposit) {
        deposits.add(deposit);
    }

    public List<Deposit> getDeposits() {
        return deposits;
    }
}
