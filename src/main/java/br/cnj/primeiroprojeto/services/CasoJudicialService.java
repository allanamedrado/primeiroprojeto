package br.cnj.primeiroprojeto.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import br.cnj.primeiroprojeto.models.CasoJudicial;

@Service
public class CasoJudicialService {
    private List<CasoJudicial> casos;

    public CasoJudicialService() {
        casos = new ArrayList<CasoJudicial>(Arrays.asList(new CasoJudicial[]{
            new CasoJudicial(1, 'A', "Caso 1"),
            new CasoJudicial(2, 'B', "Caso 2")            
        }));
    }

    public List<CasoJudicial> pegarTodosCasosJudiciais() {
        return casos;
    }

    public CasoJudicial pegarCasoJudicialPorID(Long id) {
        for (CasoJudicial caso : casos) {
            if (caso.getNumero() == id) {
                return caso;
            } 
        }

        return null;
    }

    public String criarCaso(CasoJudicial entity) {
        for (CasoJudicial caso : casos) {
            if (caso.getNumero() == entity.getNumero()) {
                return "Este caso já existe!";
            } 
        }

        casos.add(entity);
        return "Criado!";
    }
}
