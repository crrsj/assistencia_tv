package br.com.assistencia.service;


import br.com.assistencia.dto.ClienteDTO;
import br.com.assistencia.modelo.Cliente;
import br.com.assistencia.repositorio.ClienteRepositorio;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Cliente buscarPorId(Long id){
        Optional<Cliente> buscarId = clienteRepositorio.findById(id);
        return buscarId.orElseThrow();
    }


    @Transactional
    public Cliente atualizarCliente(ClienteDTO clienteDTO){
    var atualizar = clienteRepositorio.getReferenceById(clienteDTO.id());
    atualizar.atualizando(clienteDTO);
    return atualizar;
    }

    public void excluir(Long id){
        clienteRepositorio.deleteById(id);
    }
}
