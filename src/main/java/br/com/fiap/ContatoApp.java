package br.com.fiap;

import br.com.fiap.dao.Conexao;
import br.com.fiap.dao.ContatoDao;
import br.com.fiap.dao.TipoContatoDao;
import br.com.fiap.model.Contato;
import br.com.fiap.model.TipoContato;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

public class ContatoApp {
    public static void main(String[] args) {

        EntityManager em = Conexao.getEntityManager();

        salvar(em);
        //remover(em);
        //atualizar(em);
        //consultarContatoPorId(em);
        //listarTodosOsContatos(em);
        //listarContatosPorEmail(em);
        consultarTipoContatoPorId(em);
    }

    private static void consultarTipoContatoPorId(EntityManager em) {


        TipoContatoDao dao = new TipoContatoDao(em);
        TipoContato tipoContatoBuscado = new TipoContato();
        tipoContatoBuscado.setId(2l);

        TipoContato tipoContatoEncontrado = new TipoContato();

        tipoContatoEncontrado = dao.buscarTipoContatoPeloId(tipoContatoBuscado);

        System.out.println(tipoContatoEncontrado.getTipo());
        System.out.println(tipoContatoEncontrado.getContatos());
    }

    public static void listarContatosPorEmail(EntityManager em) {

        ContatoDao dao = new ContatoDao(em);


        List<Contato> contatos = dao.listarContatosPorEmail("BetinhoDoAbacate@email.com");

        for (Contato contato : contatos) {
            System.out.println("-----------------------------");
            System.out.println(contato.toString());
        }

    }

    public static void listarTodosOsContatos(EntityManager em) {

        ContatoDao dao = new ContatoDao(em);


        List<Contato> contatos = dao.listarTodosOsContatos();

        for (Contato contato : contatos) {
            System.out.println("-----------------------------");
            System.out.println(contato.toString());
        }

    }

    public static void salvar(EntityManager em) {
        TipoContato tipoContato =  new TipoContato();
        tipoContato.setId(2L);
        tipoContato.setTipo("Familia");

        //TipoContatoDao tipoContatoDao = new TipoContatoDao(em);

        em.getTransaction().begin();
        //tipoContatoDao.salvar(tipoContato);

        Contato contato = new Contato();
        ContatoDao dao = new ContatoDao(em);
        contato.setNome("Amanda");
        contato.setEmail("Amadao@Fiap.com");
        contato.setDataNascimento(LocalDate.of(2007, 12, 15));
        contato.setTipoContato(tipoContato);


        dao.salvar(contato);
        em.getTransaction().commit();
    }

    public static void atualizar(EntityManager em) {
        Contato contato = new Contato();
        ContatoDao dao = new ContatoDao(em);
        contato.setId(7L);
        contato.setNome("Rodrigão");
        contato.setEmail("Rodrigui@gmail.com");
        contato.setDataNascimento(LocalDate.of(1990, 3, 1));

        em.getTransaction().begin();
        dao.atualizar(contato);
        em.getTransaction().commit();
    }

    public static void remover(EntityManager em) {

        Contato contato = new Contato();
        ContatoDao dao = new ContatoDao(em);

        contato.setId(7L);

        em.getTransaction().begin();
        dao.remover(contato);
        em.getTransaction().commit();
    }


    public static void consultarContatoPorId(EntityManager em) {


        ContatoDao dao = new ContatoDao(em);


        em.getTransaction().begin();
        dao.consultarPorId(9L);
        em.getTransaction().commit();
    }
}
