package com.pismo.pismotransactions;

import com.pismo.pismotransactions.model.OperationType;
import com.pismo.pismotransactions.repository.OperationTypetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PismoTransactionsApplication implements ApplicationRunner {

    @Autowired
    private OperationTypetRepository operationTypetRepository;

    public static void main(String[] args) {
        SpringApplication.run(PismoTransactionsApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        operationTypetRepository.save(new OperationType(1l, "COMPRA A VISTA"));
        operationTypetRepository.save(new OperationType(2l, "COMPRA PARCELADA"));
        operationTypetRepository.save(new OperationType(3l, "SAQUE"));
        operationTypetRepository.save(new OperationType(4l, "PAGAMENTO"));
    }
}
