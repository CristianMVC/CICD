/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.local.cicd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author Usuario
 */

@SpringBootApplication
@EntityScan("com.local.cicd.entity")
@EnableJpaRepositories("com.local.cicd.repository")
public class CICD {

    public static void main(String[] args) {
        SpringApplication.run(CICD.class, args);
    }
}
