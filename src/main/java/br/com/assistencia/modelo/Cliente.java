package br.com.assistencia.modelo;

import br.com.assistencia.dto.ClienteDTO;
import br.com.assistencia.enums.Marca;
import br.com.assistencia.enums.Smart;
import br.com.assistencia.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Entity
@Table(name = "clientes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dataEntrada = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    private Integer ordem = new Random().nextInt(1000 + 1);
    private String nome;
    private String fone;
    private String email;
    private Marca marca;
    private String modelo;
    private Integer polegadas;
    private Smart smart;
    private String descricao;
    private LocalDate dataEntrega;
    private Double valor;
    private Status status;

    public Cliente(ClienteDTO clienteDTO) {
        this.id = clienteDTO.id();
        this.nome = clienteDTO.nome();
        this.fone = clienteDTO.fone();
        this.email = clienteDTO.email();
        this.marca = clienteDTO.marca();
        this.modelo = clienteDTO.modelo();
        this.polegadas = clienteDTO.polegadas();
        this.smart = clienteDTO.smart();
        this.descricao = clienteDTO.descricao();
        this.dataEntrega = clienteDTO.dataEntrega();
        this.valor = clienteDTO.valor();
        this.status = clienteDTO.status();
    }
}
