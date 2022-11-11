package com.pismo.pismotransactions.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_iD")
    private Long id;

    @Column(name = "document_number", unique = true)
    private Long documentNumber;

    @Column(unique = true)
    private BigDecimal credit;

    @JsonManagedReference
    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private List<Transaction> transactions;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
