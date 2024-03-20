package com.mv.main.movimentacaos.empresa.service;

import com.mv.main.movimentacaos.empresa.exception.DataIntegrityViolation;
import com.mv.main.movimentacaos.empresa.exception.ErrorInternal;
import com.mv.main.movimentacaos.empresa.model.Empresa;
import com.mv.main.movimentacaos.empresa.repository.EmpresaRepository;
import com.mv.main.movimentacaos.empresa.service.inter.EmpresaServiceInter;
import jakarta.persistence.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class EmpresaService implements EmpresaServiceInter {
    @Autowired
    private EmpresaRepository repository;
    @Override
    public Empresa save(Empresa empresa)throws DataIntegrityViolation,ErrorInternal {

        try {
            return repository.save(empresa);

        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolation();
        }catch (PersistenceException e){
            throw new ErrorInternal();
        }
    }

    @Override
    public Boolean existsByCNPJ(String cnpj) {
        return repository.existsByCNPJ(cnpj);
    }
}
