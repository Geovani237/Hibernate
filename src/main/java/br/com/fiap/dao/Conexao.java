package br.com.fiap.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Conexao {

    public static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("contato");

    public static EntityManager getEntityManager(){
        return EMF.createEntityManager();
    }
}
