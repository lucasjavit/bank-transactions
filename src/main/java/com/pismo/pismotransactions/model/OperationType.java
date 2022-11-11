package com.pismo.pismotransactions.model;

import com.pismo.pismotransactions.patterns.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "operation_types")
public class OperationType {

    @Id
    @Column(name = "operation_type_id")
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    public static OperationTypeStrategy getOperationType(Long operationId) {
        switch (operationId.intValue()) {
            case 1:
                return new CompraAVistaOperationType();
            case 2:
                return new CompraParceladaOperationType();
            case 3:
                return new SaqueperationType();
            default:
                return new PagamentoperationType();
        }
    }

}
