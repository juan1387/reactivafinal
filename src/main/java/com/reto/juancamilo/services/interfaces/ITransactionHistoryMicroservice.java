package com.reto.juancamilo.services.interfaces;

import com.reto.juancamilo.model.Cashouts;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ITransactionHistoryMicroservice {

    Mono<List<Cashouts>> transactionHistoryMicroservice(String userId);
}
