package com.mv.main.movimentacaos.cliente.service.inter;

import com.mv.main.movimentacaos.cliente.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserServiceInter {

    Optional<User> findByUser(UUID id);

    Boolean existsByCPF(String cpf);
    User saveUser(User user);

}
