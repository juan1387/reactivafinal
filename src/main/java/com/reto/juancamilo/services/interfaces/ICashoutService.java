package com.reto.juancamilo.services.interfaces;

import com.reto.juancamilo.DTO.Cashoutrequest;
import com.reto.juancamilo.model.Cashouts;
import reactor.core.publisher.Mono;

public interface ICashoutService {
    Mono<Cashouts> createCashout(Cashoutrequest cashoutrequest);
}
