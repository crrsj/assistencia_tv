package br.com.assistencia.dto;

import br.com.assistencia.enums.Marca;
import br.com.assistencia.enums.Smart;
import br.com.assistencia.enums.Status;
import br.com.assistencia.modelo.Cliente;

import java.time.LocalDate;

public record BuscarClientes(
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
        LocalDate dataEntrega,
        Double valor,
        Status status) {

        public BuscarClientes(Cliente cliente){
            this(
                    cliente.getId(),
                    cliente.getDataEntrada(),
                    cliente.getOrdem(),
                    cliente.getNome(),
                    cliente.getFone(),
                    cliente.getEmail(),
                    cliente.getMarca(),
                    cliente.getModelo(),
                    cliente.getPolegadas(),
                    cliente.getSmart(),
                    cliente.getDescricao(),
                    cliente.getDataEntrega(),
                    cliente.getValor(),
                    cliente.getStatus());
        }
}
