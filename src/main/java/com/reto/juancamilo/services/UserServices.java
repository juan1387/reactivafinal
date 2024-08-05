package com.reto.juancamilo.services;

import com.reto.juancamilo.DTO.Cashoutrequest;
import com.reto.juancamilo.model.Users;
import com.reto.juancamilo.repoasitories.UserRespository;
import com.reto.juancamilo.services.interfaces.IUserServices;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserServices implements IUserServices {
    private final UserRespository userRespository;

    public UserServices(UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    @Override
    public Mono<Users> getUserById(String id) {
        return userRespository.findById(id);
    }

    @Override
    public Mono<Users> createUser(Users users) {
        return userRespository.save(users);
    }

    @Override
    public Mono<Users> updateUserBalance(Cashoutrequest cashoutrequest) {
       return userRespository.findById(cashoutrequest.getUserid()).flatMap(usr->{
            return userRespository.save(new Users(cashoutrequest.getUserid(),usr.getBalance()-cashoutrequest.getAmount()));
        });
    }
}
