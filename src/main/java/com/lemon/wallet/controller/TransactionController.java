package com.lemon.wallet.controller;

import com.lemon.wallet.adapter.TransactionAdapter;
import com.lemon.wallet.dto.TransactionDto;

import java.util.List;
import org.slf4j.Logger;


import com.lemon.wallet.dto.TransactionFilterDto;


import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lemon/challenge-api/transaction")
public class TransactionController {
    private final TransactionAdapter transactionAdapter;

    private static final Logger LOG = LoggerFactory.getLogger(TransactionController.class);

    public TransactionController(TransactionAdapter transactionAdapter) {
        this.transactionAdapter = transactionAdapter;
    }

    @PostMapping
    public TransactionDto createTransaction(@RequestBody TransactionDto transaction) {
        LOG.info(String.format("Init createTransaction to user: %s", transaction.getUserTo()));
        var response = transactionAdapter.createTransaction(transaction);
        LOG.info(String.format("Finish createTransaction to user: %s, with response: %s", transaction.getUserTo(), response));
        return response;
    }

    @GetMapping
    public List<TransactionDto> findTransactions(TransactionFilterDto filter) {
        LOG.info(String.format("Init findTransactions with filter: %s", filter));
        var response= transactionAdapter.find(filter);
        LOG.info(String.format("Finish findTransactions with filter: %s, with response: %s", filter, response));

        return response;
    }
}
