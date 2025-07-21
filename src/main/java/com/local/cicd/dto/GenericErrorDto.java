package com.local.cicd.dto;

/**
 *
 * @author Usuario
 */
public class GenericErrorDto {
    
    private String error;

    public GenericErrorDto(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String nombre) {
        this.error = nombre;
    }

 
}
