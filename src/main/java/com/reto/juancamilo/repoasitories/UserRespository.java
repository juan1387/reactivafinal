package com.reto.juancamilo.repoasitories;

import com.reto.juancamilo.model.Users;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRespository extends ReactiveCrudRepository<Users, String> {
}
