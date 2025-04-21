package br.com.fiap.dao;

import br.com.fiap.model.Contato;
import br.com.fiap.model.TipoContato;
import jakarta.persistence.EntityManager;

public class TipoContatoDao {
    private EntityManager em;

    public TipoContatoDao(EntityManager em){
        this.em = em;
    }

    public void salvar(TipoContato tipoContato){
        em.persist(tipoContato);
    }

    public TipoContato buscarTipoContatoPeloId(TipoContato tipoContato){
        return em.find(TipoContato.class, tipoContato.getId());
    }
}
