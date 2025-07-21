/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.local.cicd.service;

import com.local.cicd.dto.GenericErrorDto;
import com.local.cicd.dto.UsuarioDto;
import com.local.cicd.dto.UsuarioRolesDto;
import com.local.cicd.entity.Rol;
import com.local.cicd.entity.Usuario;
import com.local.cicd.entity.enums.Roles;
import com.local.cicd.repository.RolRepository;
import com.local.cicd.repository.UsuarioRepository;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class UsuarioService {

    UsuarioRepository usuarioRepository;

    RolRepository rolRepository;

    @Autowired
    PasswordEncoder passEncoder;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, RolRepository rolRepository) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
    }

    public ResponseEntity insertar(Usuario usuario) {
      
        return usuarioRepository.findByNombre(usuario.getNombre())
                
                .<ResponseEntity>map(u -> ResponseEntity.status(409).body( new GenericErrorDto("El usuario ya existe.")))
                .orElseGet(() -> {
                    
                    usuario.setPassword(passEncoder.encode(usuario.getPassword()));
                    Usuario usuarioResponse = usuarioRepository.save(usuario);
                    UsuarioDto usuarioDto = usuarioResponse.getUsuarioDto();
                    return ResponseEntity.ok(usuarioDto);
                });

    }

    public UsuarioDto asignarRol(UsuarioRolesDto usuarioRolesDto) {

        Usuario usuario = usuarioRepository.findByNombre(usuarioRolesDto.getNombre())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado."));

        Set<Rol> roles = new HashSet<Rol>();

        usuarioRolesDto.getRoles().stream().forEach(nombre -> {

            Roles nombreEnum = Roles.valueOf(nombre.toString());

            Rol rol = rolRepository.findByNombre(nombreEnum)
                    .orElseThrow(() -> new RuntimeException("Rol ROLE_USER no encontrado"));

            roles.add(rol);
        });

        usuario.setRoles(roles);
        usuarioRepository.save(usuario);

        return usuario.getUsuarioDto();
    }

}
