package br.com.assistencia.infra;

import br.com.assistencia.dto.MensagemDeErros;
import br.com.assistencia.dto.ValidandoCampos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class TratamentoDeErros {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<MensagemDeErros>objetoNaoEncontrado(){
        var novosErros = new MensagemDeErros(HttpStatus.NOT_FOUND,"Objeto não encontrado");
        return new ResponseEntity<>(novosErros,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?>validarCampos(MethodArgumentNotValidException ex){
        var erro =  ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erro.stream().map(ValidandoCampos::new).toList());
    }
}
