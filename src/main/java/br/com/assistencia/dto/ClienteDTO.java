package br.com.assistencia.dto;

import br.com.assistencia.enums.Marca;
import br.com.assistencia.enums.Smart;
import br.com.assistencia.enums.Status;
import br.com.assistencia.modelo.Cliente;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record ClienteDTO(

        Long id,
        String dataEntrada,
        Integer ordem,
        String nome,
        String fone,
        String email,
        Marca marca,
        String modelo,
        Integer polegadas,
        Smart smart,
        String descricao,
        @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
        LocalDate dataEntrega,
        Double valor,
        Status status) {
    public ClienteDTO(Cliente cadastrar) {

       this(cadastrar.getId(),
               cadastrar.getDataEntrada(),
               cadastrar.getOrdem(),
               cadastrar.getNome(),
               cadastrar.getFone(),
               cadastrar.getEmail(),
               cadastrar.getMarca(),
               cadastrar.getModelo(),
               cadastrar.getPolegadas(),
               cadastrar.getSmart(),
               cadastrar.getDescricao(),
               cadastrar.getDataEntrega(),
               cadastrar.getValor(),
               cadastrar.getStatus());

    }
}
