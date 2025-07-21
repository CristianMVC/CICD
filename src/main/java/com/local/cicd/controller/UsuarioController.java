/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.local.cicd.controller;

import com.local.cicd.dto.UsuarioDto;
import com.local.cicd.dto.AuthRequestDto;
import com.local.cicd.dto.TokenResponseDto;
import com.local.cicd.dto.UsuarioRolesDto;
import com.local.cicd.entity.Usuario;
import com.local.cicd.service.UsuarioService;
import com.local.cicd.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    JwtUtil jUtil;

    @PostMapping("/crear")
    public ResponseEntity<UsuarioDto> crearUsuario(@RequestBody Usuario usuario) {       
        return usuarioService.insertar(usuario);
    }
    
    @PostMapping("/asignarRol")
    public ResponseEntity<UsuarioDto> asignarRol(@RequestBody UsuarioRolesDto usuarioRolesDto) {
        
        UsuarioDto result = usuarioService.asignarRol(usuarioRolesDto);
    
        return ResponseEntity.ok(result);
    }
    
    
    

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> login(@RequestBody AuthRequestDto authRequest) {

      
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getNombre(),
                        authRequest.getPassword()
                )
        );
   
        User user = (User) authentication.getPrincipal();
        String token = jUtil.generateToken(user.getUsername());
          
       
        return ResponseEntity.ok(new TokenResponseDto(token));

    }

}
