package com.mv.main.movimentacaos.cliente.service;

import com.mv.main.movimentacaos.cliente.model.User;
import com.mv.main.movimentacaos.cliente.repository.UserRepository;
import com.mv.main.movimentacaos.cliente.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements UserServiceInter {

    @Autowired
    private UserRepository repository;
    @Override
    public Optional<User> findByUser(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Boolean existsByCPF(String cpf) {
        return repository.existsByCPF(cpf);
    }

    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }
}
