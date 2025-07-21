/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.local.cicd.config;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Usuario
 */


public class CreadorDeObjetos {

    private final Map<Class<?>, Object> beans = new HashMap<>();

    public void registrar(Class<?>... clases) {
        for (Class<?> clazz : clases) {
            if (clazz.isAnnotationPresent(Instancia.class)) {
                try {
                    Object instancia = clazz.getDeclaredConstructor().newInstance();
                    beans.put(clazz, instancia);
                } catch (Exception e) {
                    throw new RuntimeException("Error al instanciar " + clazz.getName(), e);
                }
            }
        }
    }
    
    

    @SuppressWarnings("unchecked")
    public <T> T obtener(Class<T> tipo) {
        Object instancia = beans.get(tipo);
        if (instancia == null) {
            throw new RuntimeException("No se encontró instancia para: " + tipo.getName());
        }
        return (T) instancia;
    }

}
