package com.reto.juancamilo.controller;

import com.reto.juancamilo.DTO.Cashoutrequest;
import com.reto.juancamilo.model.Cashouts;
import com.reto.juancamilo.services.interfaces.ICashoutService;
import com.reto.juancamilo.services.interfaces.IPymentMicroservice;
import com.reto.juancamilo.services.interfaces.ITransactionHistoryMicroservice;
import com.reto.juancamilo.services.interfaces.IUserServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.swing.text.TableView;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cashouts")
public class ControllerCashout {

    private final IUserServices userServices;
    private final IPymentMicroservice iPymentMicroservice;
    private final ICashoutService iCashoutService;
    private final ITransactionHistoryMicroservice transactionHistoryMicroservice;

    public ControllerCashout(IUserServices userServices, IPymentMicroservice iPymentMicroservice, ICashoutService iCashoutService, ITransactionHistoryMicroservice transactionHistoryMicroservice) {
        this.userServices = userServices;
        this.iPymentMicroservice = iPymentMicroservice;
        this.iCashoutService = iCashoutService;
        this.transactionHistoryMicroservice = transactionHistoryMicroservice;
    }

    @PostMapping
    public Mono<ResponseEntity<Cashouts>> cashouts(@RequestBody Cashoutrequest catshoutreq){

        return userServices.getUserById(catshoutreq.getUserid()).filter(users -> users.getBalance()>=catshoutreq.getAmount())
                .flatMap(users -> iPymentMicroservice.payments(catshoutreq))
                .filter(estado -> estado.equalsIgnoreCase("approved"))
                .then(userServices.updateUserBalance(catshoutreq))
                .then(iCashoutService.createCashout(catshoutreq))
                .map(objCashout ->ResponseEntity.status(HttpStatus.OK).body(objCashout))
                .switchIfEmpty( Mono.error(new Exception("Payment failed")))
                .doOnError(Throwable->new Exception("Payment failed"));
    }

    @GetMapping("/user/{userid}")
    public Mono<ResponseEntity<List<Cashouts>>> catshoutUserId(@PathVariable String userid){
        //ResponseEntity.status(HttpStatus.OK)


        return transactionHistoryMicroservice.transactionHistoryMicroservice(userid)
                .map(list -> {
                    return ResponseEntity.status(HttpStatus.OK).body(list);
                }).onErrorResume(error -> {
                   return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                           Collections.singletonList(new Cashouts())));

                });

    }


}
