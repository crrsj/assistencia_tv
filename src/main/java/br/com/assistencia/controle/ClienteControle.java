package br.com.assistencia.controle;


import br.com.assistencia.dto.BuscarClientes;
import br.com.assistencia.dto.ClienteDTO;
import br.com.assistencia.service.ClienteServico;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("assistencia")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ClienteControle {

    private final ClienteServico clienteServico;

    @PostMapping
    public ResponseEntity<ClienteDTO>cadastrarCliente(@RequestBody @Valid ClienteDTO clienteDTO){
        var cadastrar = clienteServico.cadastrarCliente(clienteDTO);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().
         path("{id}").buildAndExpand(cadastrar.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClienteDTO(cadastrar));
    }

    @GetMapping
    public ResponseEntity<List<BuscarClientes>>buscarTodos(){
        var buscaTodos = clienteServico.ListarTodos().stream().map(BuscarClientes::new).toList();
        return ResponseEntity.ok(buscaTodos);
    }

    @GetMapping("{id}")
    public ResponseEntity<BuscarClientes>buscarPorId(@PathVariable Long id){
        var buscar = clienteServico.buscarPorId(id);
        return ResponseEntity.ok().body(new BuscarClientes(buscar));
    }

    @PutMapping("atualizar")
    public ResponseEntity<ClienteDTO>atualizarClientes(@RequestBody ClienteDTO clienteDTO){
        var atualize = clienteServico.atualizarCliente(clienteDTO);
        return ResponseEntity.ok().body(new ClienteDTO(atualize));
    }


    @DeleteMapping("deletar/{id}")
    public ResponseEntity<Void>excluir(@PathVariable Long id){
        clienteServico.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
