package com.modern.ch06;

import lombok.Data;

@Data
public class Transaction {
    private final Currency currency;
    private final int cost;
}