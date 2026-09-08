package com.example.aulajovem20262ia.controllers;

import com.example.aulajovem20262ia.DTO.AtualizaStatusUsuarioRequest;
import com.example.aulajovem20262ia.DTO.UsuarioRequest;
import com.example.aulajovem20262ia.DTO.UsuarioResponse;
import com.example.aulajovem20262ia.entities.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @GetMapping
    public String ConsultaUsuario(){
        return "Hello Word!";
    }

    @GetMapping("/{id}")
    public Usuario ConsultaUsuarioPorId(@PathVariable Long id){
        Usuario usuario = new Usuario();

        usuario.setNome("Samuel");
        usuario.setCpf("063225155155");
        usuario.setDataNascimento("27/12/1993");
        return usuario;
    }

    @GetMapping("/empresa/{empresaId}")
    public Usuario ConsultaUsuarioPorEmpresa(@PathVariable Long empresaId){
        Usuario usuarioContrutorCompleto =
                new Usuario("Samuel","063720095945459","27/12/1193");
        return usuarioContrutorCompleto;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> CadastrarUsuario(@RequestBody UsuarioRequest usuarioRequest){
        Usuario usuarioBanco = new Usuario();
        usuarioBanco.setNome(usuarioRequest.getNome());
        usuarioBanco.setCpf(usuarioRequest.getCpf());
        usuarioBanco.setDataNascimento(usuarioRequest.getDataNascimento());

        usuarioBanco.setDataCadastro(LocalDateTime.now());
        usuarioBanco.setStatus("A");

        return ResponseEntity.ok(new UsuarioResponse(usuarioBanco.getId(),
                "Cadastro com sucesso!"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse>
    AtualizarUsuario(@PathVariable Long id, @RequestBody UsuarioRequest usuarioRequest){
        //Consulta no banco
        Usuario usuarioBanco = new Usuario();

        if(usuarioBanco != null){
            usuarioBanco.setNome(usuarioRequest.getNome());
            usuarioBanco.setCpf(usuarioRequest.getCpf());
            usuarioBanco.setDataNascimento(usuarioRequest.getDataNascimento());
            usuarioBanco.setDataAtualizacao(LocalDateTime.now());

            return ResponseEntity.ok(new UsuarioResponse(usuarioBanco.getId(),
                    "UsuarioAtulizado com sucesso!"));
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<UsuarioResponse>
    AtualizarStatus(@PathVariable Long id, @RequestBody AtualizaStatusUsuarioRequest usuarioRequest){
        //Consulta no banco
        Usuario usuarioBanco = new Usuario();

        if(usuarioBanco != null){
           usuarioBanco.setStatus(usuarioRequest.getStatus());

            return ResponseEntity.ok(new UsuarioResponse(usuarioBanco.getId(),
                    "Status atualizado com sucesso!"));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsuarioResponse>
    AtualizarStatus(@PathVariable Long id){
        //Consulta no banco
        Usuario usuarioBanco = new Usuario();

        if(usuarioBanco != null){
            usuarioBanco.setStatus("D");

            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }




}
