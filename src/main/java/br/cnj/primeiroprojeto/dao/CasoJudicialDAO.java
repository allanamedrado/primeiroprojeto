package br.cnj.primeiroprojeto.dao;

import java.util.List;

import br.cnj.primeiroprojeto.models.CasoJudicial;

public interface CasoJudicialDAO {
    CasoJudicial findById(int id);
    List<CasoJudicial> findAll();
    List<CasoJudicial> findAll(int page, int pageSize, String sortBy, String sortOrder);
    void save(CasoJudicial casoJudicial);
    void update(CasoJudicial casoJudicial);
    void delete(int id);  
    
}