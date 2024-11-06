package br.com.assistencia.dto;

import org.springframework.validation.FieldError;

public record ValidandoCampos(String campo, String mensagem) {
    public ValidandoCampos(FieldError erros){
        this(erros.getField(),erros.getDefaultMessage());
    }
}