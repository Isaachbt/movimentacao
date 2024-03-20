package com.mv.main.movimentacaos.empresa.controller;

import com.mv.main.movimentacaos.empresa.dto.EmpresaDTO;
import com.mv.main.movimentacaos.empresa.exception.EmpresaExists;
import com.mv.main.movimentacaos.empresa.model.Empresa;
import com.mv.main.movimentacaos.empresa.service.inter.EmpresaServiceInter;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("empresa/")
public class EmpresaController {

    @Autowired
    private EmpresaServiceInter empresaService;
    @PostMapping("Registering")
    public ResponseEntity<Object> RegisteringEmpresa(@RequestBody @Valid EmpresaDTO dto){

        if (empresaService.existsByCNPJ(dto.CNPJ())){
            throw new EmpresaExists();
        }

        var empresa = new Empresa();
        BeanUtils.copyProperties(dto,empresa);
        return ResponseEntity.status(HttpStatus.OK).body(empresaService.save(empresa));

    }
}
