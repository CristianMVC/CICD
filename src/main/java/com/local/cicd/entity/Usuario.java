/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.local.cicd.entity;

import com.local.cicd.dto.UsuarioDto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author Usuario
 */
@Entity
public class Usuario {

    @Id
    @GeneratedValue
    private long id;

    private String nombre;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuario_roles",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    private Set<Rol> roles;

    public Usuario(String nombre, String password, Set<Rol> roles) {
        this.nombre = nombre;
        this.password = password;
        this.roles = roles;
    }

    public Usuario() {
    }

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

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    public UsuarioDto getUsuarioDto() {
        List<String> listaRoles = new ArrayList<String>();

        listaRoles = Optional.ofNullable(roles)
                .map(r -> r.stream()
                .map(role -> role.getNombre().name())
                .collect(Collectors.toList()))
                .orElse(Collections.singletonList("[No posee roles]"));

        return new UsuarioDto(getId(), getNombre(), getPassword(), listaRoles);

    }

}
