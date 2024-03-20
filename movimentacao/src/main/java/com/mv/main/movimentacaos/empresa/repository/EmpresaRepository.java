package com.mv.main.movimentacaos.empresa.repository;

import com.mv.main.movimentacaos.empresa.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmpresaRepository extends JpaRepository<Empresa, UUID> {

    Boolean existsByCNPJ(String cpnj);
    Empresa findByCNPJ(String cpnj);
}
