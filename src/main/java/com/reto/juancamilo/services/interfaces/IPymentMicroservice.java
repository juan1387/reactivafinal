package com.reto.juancamilo.services.interfaces;

import com.reto.juancamilo.DTO.Cashoutrequest;
import com.reto.juancamilo.model.Cashouts;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IPymentMicroservice {

    Mono<String> payments(Cashoutrequest cashoutrequest);

}
