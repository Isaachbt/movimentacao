package com.mv.main.movimentacaos.empresa.service.inter;
import com.mv.main.movimentacaos.empresa.model.Empresa;

import java.util.Optional;
import java.util.UUID;

public interface EmpresaServiceInter {

    Empresa save(Empresa empresa);

    Boolean existsByCNPJ(String cnpj);

    Optional<Empresa> findById(UUID uuid);
}
