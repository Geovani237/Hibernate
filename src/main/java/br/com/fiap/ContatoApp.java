package br.com.fiap;

import br.com.fiap.dao.Conexao;
import br.com.fiap.dao.ContatoDao;
import br.com.fiap.model.Contato;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;

public class ContatoApp {
    public static void main(String[] args){

        EntityManager em = Conexao.getEntityManager();

        //salvar(em);
        remover(em);
        //atualizar(em);


    }

    public static void salvar(EntityManager em){
        Contato contato = new Contato();
        ContatoDao dao = new ContatoDao(em);
        contato.setNome("Rodrigão");
        contato.setEmail("rOdri@gmail.com");
        contato.setDataNascimento(LocalDate.of(2005,11,15));

        em.getTransaction().begin();
        dao.salvar(contato);
        em.getTransaction().commit();
    }

    public static void atualizar(EntityManager em){
        Contato contato = new Contato();
        ContatoDao dao = new ContatoDao(em);
        contato.setId(7L);
        contato.setNome("Rodrigão");
        contato.setEmail("Rodrigui@gmail.com");
        contato.setDataNascimento(LocalDate.of(1990,3,1));

        em.getTransaction().begin();
        dao.atualizar(contato);
        em.getTransaction().commit();
    }

    public static void remover(EntityManager em){

        Contato contato = new Contato();
        ContatoDao dao = new ContatoDao(em);

        contato.setId(7L);

        em.getTransaction().begin();
        dao.remover(contato);
        em.getTransaction().commit();
    }
}
