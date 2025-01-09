package br.cnj.primeiroprojeto.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.cnj.primeiroprojeto.models.CasoJudicial;
import br.cnj.primeiroprojeto.services.CasoJudicialService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/casos")
public class CasoJudicialController {
    private final CasoJudicialService service;

    public CasoJudicialController(CasoJudicialService service) {
        this.service = service;
    };

    @GetMapping
    public ResponseEntity<List<CasoJudicial>> pegarTodosCasosJudiciais() {
        List<CasoJudicial> casos = service.pegarTodosCasosJudiciais();

        return ResponseEntity.ok(casos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CasoJudicial> pegarCasoPorID(@PathVariable Long id) {
        CasoJudicial caso = service.pegarCasoJudicialPorID(id);

        if (caso == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(caso);
    }
    
    @PostMapping
    public ResponseEntity<String> criarCaso(@RequestBody CasoJudicial entity) {
        String response = service.criarCaso(entity);
        
        return ResponseEntity.status(201).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CasoJudicial> atualizarCaso(@PathVariable Long id, @RequestBody CasoJudicial entity) {
        CasoJudicial caso = service.atualizarCasoJudicial(entity);
        
        return ResponseEntity.status(201).body(caso);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deletarCaso(@PathVariable Long id) {
        service.removerCasoJudicial(id);

        return ResponseEntity.noContent().build();
    }

}
