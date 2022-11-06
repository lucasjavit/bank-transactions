package com.pismo.pismotransactions.repository;

import com.pismo.pismotransactions.model.OperationType;
import com.pismo.pismotransactions.util.OperationTypeCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@ExtendWith(SpringExtension.class)
class OperationTypetRepositoryTest {

    @Autowired
    private OperationTypetRepository operationTypetRepository;

    @Test
    @DisplayName("shouldBeSaveWhenSuccessful")
    public void shouldBeSaveWhenSuccessful() {
        OperationType operationTypeToBeSaved = OperationTypeCreator.createOperationTypeToBeSaved();

        OperationType operationType = operationTypetRepository.save(operationTypeToBeSaved);

        assertThat(operationType).isNotNull();
        assertThat(operationType.getId()).isNotNull();
        assertThat(operationType.getDescription()).isEqualTo(operationTypeToBeSaved.getDescription());
    }

    @Test
    @DisplayName("shouldBeFindByIdOperationTypeWhenSuccessful")
    public void shouldBeFindByIdOperationTypeWhenSuccessful() {
        OperationType operationTypeToBeSaved = OperationTypeCreator.createOperationTypeToBeSaved();

        OperationType operationType = operationTypetRepository.save(operationTypeToBeSaved);


        Optional<OperationType> optionalOperationType = operationTypetRepository.findById(1l);

        assertThat(optionalOperationType)
                .isNotNull()
                .isNotEmpty();

        assertThat(optionalOperationType.get()).isNotNull();
        assertThat(optionalOperationType.get().getId()).isEqualTo(1l);
    }

}