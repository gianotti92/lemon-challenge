package com.lemon.wallet.service;

import com.lemon.wallet.exception.ApiException;
import com.lemon.wallet.model.Transaction;
import com.lemon.wallet.model.Wallet;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final WalletService WalletService;

    public TransactionService(com.lemon.wallet.service.WalletService walletService) {
        WalletService = walletService;
    }

    public Transaction createMovement(Transaction transaction) {

        List<Wallet> walletsFrom = WalletService.findWallets(transaction.getUserFrom());

        List<Wallet> walletsTo = WalletService.findWallets(transaction.getUserTo());

        String message = areInvalidWallets(walletsFrom, walletsTo, transaction.getUserFrom(), transaction.getUserTo());

        if (Strings.isNotBlank(message)) {
            throw new ApiException(message);
        }



        return null;
    }


    private String areInvalidWallets(List<Wallet> from, List<Wallet> to, Long... ids) {
        StringBuilder sb = new StringBuilder();

        if (from.isEmpty()) {
            sb.append(String.format("invalid wallet for userId:%s ", ids[0]));
        }

        if (to.isEmpty()) {
            sb.append(String.format("invalid wallet for userId:%s ", ids[1]));
        }

        return sb.toString();
    }

}
