package iuh.fit.se.dao.daoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import iuh.fit.se.dao.UserDAO;
import iuh.fit.se.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("userPU");
    @Override
    public void addUser(User user) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(user);
            tx.commit();
        }catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }
    }

    @Override
    public ArrayList<User> getAllUsers() {
        EntityManager em = emf.createEntityManager();
        try {
            return (ArrayList<User>) em.createQuery("SELECT u FROM User u", User.class).getResultList();
        } finally {
            em.close();
        }
    }
}
