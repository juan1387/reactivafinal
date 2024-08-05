package com.reto.juancamilo.services;

import com.reto.juancamilo.DTO.Cashoutrequest;
import com.reto.juancamilo.model.Cashouts;
import com.reto.juancamilo.services.interfaces.ICashoutService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CashoutService implements ICashoutService {
    @Override
    public Mono<Cashouts> createCashout(Cashoutrequest cashoutrequest) {
        return null;
    }
}
