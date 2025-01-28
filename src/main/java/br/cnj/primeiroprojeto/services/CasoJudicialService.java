package br.cnj.primeiroprojeto.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import br.cnj.primeiroprojeto.dao.CasoJudicialDAO;
import br.cnj.primeiroprojeto.models.CasoJudicial;

@Service
public class CasoJudicialService {
    private List<CasoJudicial> casos;
    private final CasoJudicialDAO casoJudicialDAO;

    public CasoJudicialService(CasoJudicialDAO casoJudicialDAO) {
        this.casoJudicialDAO = casoJudicialDAO;
    }

    public List<CasoJudicial> pegarTodosCasosJudiciais() {
        return casoJudicialDAO.findAll();
    }

    public CasoJudicial pegarCasoJudicialPorID(int id) {
        return casoJudicialDAO.findById(id);
    }

    public void criarCaso(CasoJudicial entity) {
        casoJudicialDAO.save(entity);
    }

    public void atualizarCasoJudicial(CasoJudicial entity) {
        casoJudicialDAO.update(entity);
    }

    public void removerCasoJudicial(int id) {
        casoJudicialDAO.delete(id);
    }
}
