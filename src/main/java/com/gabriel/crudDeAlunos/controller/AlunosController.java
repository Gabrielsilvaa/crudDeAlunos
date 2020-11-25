package com.gabriel.crudDeAlunos.controller;

import com.gabriel.crudDeAlunos.domain.model.Alunos;
import com.gabriel.crudDeAlunos.domain.repositoty.AlunosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/aluno")
public class AlunosController {

    @Autowired
    private AlunosRepository alunosRepository;

    //Lista alunos
    @GetMapping
    public List<Alunos> lista(){
        return alunosRepository.findAll();
    }

    //Insert
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Alunos add(@Valid @RequestBody Alunos alunos){
        return alunosRepository.save(alunos);
    }

    @PutMapping("/{alunosId}")
    public ResponseEntity<Alunos> update(@Valid @PathVariable Long alunosId,
                                         @RequestBody Alunos alunos){

        if (!alunosRepository.existsById(alunosId)){
            return ResponseEntity.notFound().build();
        }
        alunos.setId(alunosId);
        alunos = alunosRepository.save(alunos);
        return ResponseEntity.ok(alunos);
    }

    @DeleteMapping("/{alunosId}")
    public ResponseEntity<Void> delete(@PathVariable Long alunosId){

        if (!alunosRepository.existsById(alunosId)){
            return ResponseEntity.notFound().build();
        }

        alunosRepository.deleteById(alunosId);
        return ResponseEntity.noContent().build();
    }


}
