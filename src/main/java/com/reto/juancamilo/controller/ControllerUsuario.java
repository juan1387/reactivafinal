package com.reto.juancamilo.controller;

import com.reto.juancamilo.DTO.Cashoutrequest;
import com.reto.juancamilo.DTO.UserAmount;
import com.reto.juancamilo.model.Users;
import com.reto.juancamilo.services.interfaces.IUserServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("users")
public class ControllerUsuario {

    private final IUserServices userServices;

    public ControllerUsuario(IUserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("{id}")
    public Mono<ResponseEntity<Users>> getIdPorUsuario(@PathVariable String id){
        return userServices.getUserById(id).map(users->{
            return ResponseEntity.status(HttpStatus.OK).body(users);
        }).onErrorResume(err ->{
            return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Users(id)));
        });
    }

    @PostMapping()
    public Mono<ResponseEntity<Users>> createUser(@RequestBody Users users){

        return userServices.createUser(users)
                .map(usr -> {
                    return ResponseEntity.status(HttpStatus.OK).body(usr);
                }).onErrorResume(err ->{
                    return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Users(null)));
                });
    }

    @PutMapping("/{id}/balance")
    public Mono<ResponseEntity<Users>> updateBalanceUser(@RequestBody UserAmount amount, @PathVariable String id){
        return userServices.updateUserBalance(new Cashoutrequest(amount.getAmount(),id)).map(usr ->{
            return ResponseEntity.status(HttpStatus.OK).body(usr);
        }).onErrorResume(err ->{
            return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Users(id)));
        });
    }

}
