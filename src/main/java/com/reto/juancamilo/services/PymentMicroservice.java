package com.reto.juancamilo.services;

import com.reto.juancamilo.DTO.Cashoutrequest;
import com.reto.juancamilo.services.interfaces.IPymentMicroservice;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PymentMicroservice  implements IPymentMicroservice {
    @Override
    public Mono<String> payments(Cashoutrequest cashoutrequest) {
        return null;
    }
}
