package dao;

import model.User;
import jakarta.persistence.*;
import java.util.List;

public class UserDao {
    
    private EntityManagerFactory emf;
    private EntityManager em;

    public UserDao() {
        emf = Persistence.createEntityManagerFactory("CanteenOrderPU");
        em = emf.createEntityManager();
    }

    // Authenticate user
    public User authenticate(String username, String password) {
        try {
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    // Create new user
    public void createUser(User user) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(user);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    // Delete a user by ID
    public void deleteUser(int userId) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            User user = em.find(User.class, userId);
            if (user != null) {
                em.remove(user);
            }
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    // Get all users
    public List<User> getAllUsers() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    // Close the entity manager
    public void close() {
        em.close();
        emf.close();
    }
}
