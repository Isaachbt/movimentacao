package com.mv.main.movimentacaos.cliente.controller;

import com.mv.main.movimentacaos.cliente.dto.UserDTO;
import com.mv.main.movimentacaos.cliente.model.User;
import com.mv.main.movimentacaos.cliente.service.inter.UserServiceInter;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user/")
public class UserController {

    @Autowired
    private UserServiceInter service;

    @PostMapping("Registering")
    public ResponseEntity<?> RegisteringUser(@RequestBody @Valid UserDTO userDTO){

        if (service.existsByCPF(userDTO.CPF())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuario ja existe");
        }
        var user = new User();
        BeanUtils.copyProperties(userDTO,user);
        return ResponseEntity.status(HttpStatus.OK).body(service.saveUser(user));

    }
}
