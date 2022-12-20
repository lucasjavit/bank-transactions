package com.pismo.pismotransactions.patterns;

import java.math.BigDecimal;

public class InstallmentOperationType implements OperationTypeStrategy {


    @Override
    public BigDecimal setSign(BigDecimal amount) {
        return amount.negate().setScale(2);
    }

    @Override
    public BigDecimal calculateCredit(BigDecimal credit, BigDecimal amount) {
        return credit.add(amount);
    }
}
