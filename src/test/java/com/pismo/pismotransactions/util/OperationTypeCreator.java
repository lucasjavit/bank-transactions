package com.pismo.pismotransactions.util;

import com.pismo.pismotransactions.model.OperationType;

public class OperationTypeCreator {

    public static OperationType createOperationTypeToBeSaved() {
        return OperationType.builder()
                .id(1l)
                .description("COMPRA A VISTA")
                .build();
    }
}
