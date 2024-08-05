package com.reto.juancamilo.services.interfaces;


import com.reto.juancamilo.DTO.Cashoutrequest;
import com.reto.juancamilo.model.Users;
import reactor.core.publisher.Mono;

public interface IUserServices {
    Mono<Users> getUserById(String id);
    Mono<Users> createUser(Users users);
    Mono<Users> updateUserBalance(Cashoutrequest cashoutrequest);
}
