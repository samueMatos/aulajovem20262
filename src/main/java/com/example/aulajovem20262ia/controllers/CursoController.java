package com.example.aulajovem20262ia.controllers;


import com.example.aulajovem20262ia.DTO.CursoConsultaResponse;
import com.example.aulajovem20262ia.DTO.CursoRequest;
import com.example.aulajovem20262ia.DTO.CursoResponse;
import com.example.aulajovem20262ia.entities.Curso;
import com.example.aulajovem20262ia.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public ResponseEntity<CursoResponse> cadastrarCurso(@RequestBody CursoRequest cursoRequest){
        Curso cursoBanco = new Curso();

        cursoBanco.setDescricao(cursoRequest.getDescricao());
        cursoBanco.setTitulo(cursoRequest.getTitulo());


        cursoRepository.save(cursoBanco);

        return ResponseEntity.ok(new CursoResponse(cursoBanco.getId(),"lasanha1"));

    }


    @GetMapping
    public ResponseEntity<List<CursoConsultaResponse>> listarTodos(){


        var listaCurso = cursoRepository.findAll()
                .stream()
                .map(CursoConsultaResponse::new).toList();

        return ResponseEntity.ok(listaCurso);


    }

}
