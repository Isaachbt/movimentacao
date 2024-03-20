package com.mv.main.movimentacaos.cliente.repository;

import com.mv.main.movimentacaos.cliente.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Boolean existsByCPF(String CPF);
}
