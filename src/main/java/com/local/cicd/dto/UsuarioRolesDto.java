/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.local.cicd.dto;

import com.local.cicd.entity.enums.Roles;
import java.util.Set;

/**
 *
 * @author Usuario
 */
public class UsuarioRolesDto {
    
    
    private String nombre;
    private Set<Roles> roles;

    public UsuarioRolesDto(String nombre, Set<Roles> roles) {
        this.nombre = nombre;
        this.roles = roles;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }
    
    
    
}
