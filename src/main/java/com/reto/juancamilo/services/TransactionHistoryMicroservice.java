package com.reto.juancamilo.services;

import com.reto.juancamilo.model.Cashouts;
import com.reto.juancamilo.services.interfaces.ITransactionHistoryMicroservice;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class TransactionHistoryMicroservice implements ITransactionHistoryMicroservice {
    @Override
    public Mono<List<Cashouts>> transactionHistoryMicroservice(String userId) {
        return null;
    }
}
