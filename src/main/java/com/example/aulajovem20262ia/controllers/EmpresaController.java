package com.example.aulajovem20262ia.controllers;


import com.example.aulajovem20262ia.DTO.EmpresaConsultaResponse;
import com.example.aulajovem20262ia.DTO.EmpresaRequest;
import com.example.aulajovem20262ia.DTO.EmpresaResponse;
import com.example.aulajovem20262ia.DTO.UsuarioConsultaResponse;
import com.example.aulajovem20262ia.entities.Empresa;
import com.example.aulajovem20262ia.entities.Usuario;
import com.example.aulajovem20262ia.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;


    @GetMapping
    public List<EmpresaConsultaResponse> listarTodos(){

        return empresaRepository.findAll()
                .stream()
                .map(EmpresaConsultaResponse::new).toList();
    }


    @PostMapping("/criar")
    public ResponseEntity<EmpresaResponse> cadastrarEmpresa(@RequestBody EmpresaRequest empresaRequest){

        Empresa empresaBanco = new Empresa();

        empresaBanco.setRazaoSocial(empresaRequest.getRazaoSocial());
        empresaBanco.setCnpj(empresaRequest.getCnpj());
        empresaBanco.setNomeFantasia(empresaRequest.getNomeFantasia());
        empresaBanco.setInscricaoEstaual(empresaRequest.getInscricaoEstaual());


        empresaRepository.save(empresaBanco);

        EmpresaResponse empresaResponse = new EmpresaResponse();

        empresaResponse.setId(empresaBanco.getId());
        empresaResponse.setMensagem("Cadastro da empresa realizado com sucesso!");

        return ResponseEntity.ok(empresaResponse);
    }


    @GetMapping("/cnpj/{cnpj}/usuarios")
    public ResponseEntity<List<UsuarioConsultaResponse>> buscarUsuariosPorCnpjEmpresa(@PathVariable String cnpj){

       var empresaBanco = empresaRepository.getEmpresaByCnpj(cnpj).orElse(null);

       if (empresaBanco==null)
           return ResponseEntity.notFound().build();

       var usuarioEmpresaBanco = empresaBanco.getUsuarios()
               .stream()
               .map(UsuarioConsultaResponse::new)
               .toList();

        return ResponseEntity.ok(usuarioEmpresaBanco);

    }

}
