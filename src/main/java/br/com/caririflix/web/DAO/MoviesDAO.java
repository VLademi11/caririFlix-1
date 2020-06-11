package br.com.caririflix.web.DAO;

import javax.persistence.EntityManager;

import br.com.caririflix.web.DAO.util.*;
import br.com.caririflix.web.model.Movies;


///falta criar list
public class MoviesDAO {

    public void save(Movies movies) {
        EntityManager em = ConnectionFactory.getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(movies);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            if (em.isOpen() && em.getTransaction().isActive())
                em.close();
        }

    }

    public void update(Movies movies) {
        EntityManager em = ConnectionFactory.getEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(movies);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            if (em.isOpen() && em.getTransaction().isActive())
                em.close();
        }

    }

    public void remove(Movies movies) {
        EntityManager em = ConnectionFactory.getEntityManager();

        try {
            em.getTransaction().begin();
            em.remove(movies);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            if (em.isOpen() && em.getTransaction().isActive())
                em.close();
        }

    }

    public Movies findById(Integer code) {
        EntityManager em = ConnectionFactory.getEntityManager();

        try {
            Movies b = em.find(Movies.class, code);
            return b;
        } finally {
            if (em.isOpen() && em.getTransaction().isActive())
                em.close();
        }

    }
}