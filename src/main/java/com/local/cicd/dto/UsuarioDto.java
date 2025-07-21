/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.local.cicd.dto;

import com.local.cicd.entity.Rol;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Usuario
 */
public class UsuarioDto {
    
    private long id;
    
    private String nombre;
    
    private String password;
    
    private List<String> roles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }



    public UsuarioDto(long id, String nombre, String password, List<String> roles) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.roles = roles;
    }
    
    

    
    
    
}
