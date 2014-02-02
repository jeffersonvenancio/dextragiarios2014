package com.dextra.webapp.context;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.transaction.UserTransaction;

import com.dextra.webapp.entity.Usuario;

@WebListener
public class DatabaseLoader implements ServletContextListener {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // TODO: ver se estah rodando o mock

        UserTransaction transaction = TransactionContainer.get();
        try {
            transaction.begin();
            this.load();
            transaction.commit();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // do nothing
    }

    public void load() {

        Usuario usuario = new Usuario();
        usuario.setNome("blablabla");
        this.em.persist(usuario);

    }

}
