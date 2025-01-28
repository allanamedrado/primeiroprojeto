package br.cnj.primeiroprojeto.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.cnj.primeiroprojeto.dao.CasoJudicialDAO;
import br.cnj.primeiroprojeto.models.CasoJudicial;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CasoJudicialDAOImpl implements CasoJudicialDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public CasoJudicial findById(int id) {
        return entityManager.find(CasoJudicial.class, id);
    }

    @Override
    public List<CasoJudicial> findAll() {
        return entityManager.createQuery("SELECT c FROM CasoJudicial c", CasoJudicial.class).getResultList();
    }

    @Override
    public List<CasoJudicial> findAll(int page, int pageSize, String sortBy, String sortOrder) {
        int offset = (page - 1) * pageSize;
        String queryString = "SELECT c FROM CasoJudicial c ORDER BY c." + sortBy + " " + sortOrder;
        return entityManager.createQuery(queryString, CasoJudicial.class)
                .setFirstResult(offset)
                .setMaxResults(pageSize)
                .getResultList();
    }

    @Override
    public void save(CasoJudicial casoJudicial) {
        entityManager.persist(casoJudicial);
    }

    @Override
    public void update(CasoJudicial casoJudicial) {
        entityManager.merge(casoJudicial);
    }

    @Override
    public void delete(int id) {
        CasoJudicial casoJudicial = entityManager.find(CasoJudicial.class, id);
        if (casoJudicial != null) {
            entityManager.remove(casoJudicial);
        }
    }
}
