/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.local.cicd.entity;

import com.local.cicd.entity.enums.Roles;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author Usuario
 */

@Entity
public class Rol {
    
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Enumerated(EnumType.STRING)
    private Roles nombre;
    
    @ManyToMany(mappedBy = "roles")
    private Set<Usuario> usuario;

    public Rol() {
    }

    public Rol(Long id, Roles nombre, Set<Usuario> usuario) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
    }

    public Rol(Roles nombre) {
        this.nombre = nombre;
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Roles getNombre() {
        return nombre;
    }

    public void setNombre(Roles nombre) {
        this.nombre = nombre;
    }

    public Set<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(Set<Usuario> usuario) {
        this.usuario = usuario;
    }
    
    
    
    
}
