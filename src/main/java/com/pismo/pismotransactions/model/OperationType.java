package com.pismo.pismotransactions.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "peration_types")
public class OperationType {

    @Id
    @Column(name = "operation_type_id")
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

}
