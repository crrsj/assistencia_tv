package br.com.assistencia.service;


import br.com.assistencia.dto.ClienteDTO;
import br.com.assistencia.modelo.Cliente;
import br.com.assistencia.repositorio.ClienteRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServico {
    private final ClienteRepositorio clienteRepositorio;

    public Cliente cadastrarCliente(ClienteDTO clienteDTO){
        var cadastrar = new Cliente(clienteDTO);
        return clienteRepositorio.save(cadastrar);
    }
    public List<Cliente> ListarTodos(){
        return clienteRepositorio.findAll();

    }
}
