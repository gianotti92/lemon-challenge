package com.lemon.wallet.service;

import com.lemon.wallet.exception.ApiException;
import com.lemon.wallet.model.CurrencyType;
import com.lemon.wallet.model.Transaction;
import com.lemon.wallet.model.Wallet;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

        Map<CurrencyType, BigDecimal> mapFrom = createMap(walletsFrom);
        Map<CurrencyType, BigDecimal> mapTo =createMap(walletsTo);

        BigDecimal fromAmountInWallet = mapFrom.get(transaction.getCurrencyType());

        if(fromAmountInWallet.compareTo(transaction.getAmount()) <= 0) {
            throw new ApiException("lo valores estan mal"); //revisar  mensaje y exception
        }

        //realizar movimiento

        //persistir


        //devolver movimiento con id

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

    private Map<CurrencyType, BigDecimal> createMap(List<Wallet> wallets) {
        return wallets.stream().collect(Collectors.toMap(Wallet::getCurrencyType, wallet -> wallet.getAmount()));
    }
}
