package br.com.fiap.dao;

import br.com.fiap.model.Contato;
import jakarta.persistence.EntityManager;

public class ContatoDao {

    private EntityManager em;

    public ContatoDao(EntityManager em){
        this.em = em;
    }

    public void salvar(Contato contato){
        em.persist(contato);
    }

    public void atualizar(Contato contato){
        em.merge(contato);
    }

    public void remover(Contato contato) {
        Contato contatoExcluir = em.find(Contato.class, contato.getId());
        em.remove(contatoExcluir);
    }
}
