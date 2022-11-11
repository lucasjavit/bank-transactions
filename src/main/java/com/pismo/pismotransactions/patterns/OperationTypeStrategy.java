package com.pismo.pismotransactions.patterns;

import java.math.BigDecimal;

public interface OperationTypeStrategy {

    BigDecimal setSign(BigDecimal amount);

    BigDecimal calculateCredit(BigDecimal credit, BigDecimal amount);


}
