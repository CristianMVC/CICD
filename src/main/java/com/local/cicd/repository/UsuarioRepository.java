/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.local.cicd.repository;

import com.local.cicd.config.Instancia;
import com.local.cicd.entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




/**
 *
 * @author Usuario
 */

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> { 
    
     Optional<Usuario> findByNombre(String nombre);
    
}
