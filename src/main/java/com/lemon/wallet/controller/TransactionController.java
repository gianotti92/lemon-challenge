package com.lemon.wallet.controller;

import com.lemon.wallet.adapter.TransactionAdapter;
import com.lemon.wallet.dto.TransactionDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lemon/challenge-api/transaction")
public class TransactionController {

    private final TransactionAdapter transactionAdapter;

    public TransactionController(TransactionAdapter transactionAdapter) {
        this.transactionAdapter = transactionAdapter;
    }

    @PostMapping
    public TransactionDto createMovement(@RequestBody TransactionDto transaction) {
        return transactionAdapter.createMovement(transaction);
    }
}
