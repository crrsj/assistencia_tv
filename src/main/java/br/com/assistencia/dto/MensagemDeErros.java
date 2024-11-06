package br.com.assistencia.dto;

import org.springframework.http.HttpStatus;

public record MensagemDeErros(HttpStatus status,String mensagem) {
}
