/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.local.cicd.repository;

import com.local.cicd.entity.Rol;
import com.local.cicd.entity.enums.Roles;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Usuario
 */

@Repository
public interface RolRepository extends JpaRepository<Rol,Long>{
    
     Optional<Rol> findByNombre(Roles nombre);

}


