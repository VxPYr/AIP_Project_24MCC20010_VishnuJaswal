package dao;

import model.Order;
import model.User;
import model.FoodItem;
import jakarta.persistence.*;
import java.util.List;

public class OrderDao {
    
    private EntityManagerFactory emf;
    private EntityManager em;

    public OrderDao() {
        emf = Persistence.createEntityManagerFactory("CanteenOrderPU");
        em = emf.createEntityManager();
    }

    // Place an order
    public void placeOrder(Order order) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(order);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    // Get all orders for a user
    public List<Order> getOrdersByUser(Long userId) {
        // Retrieve orders associated with the user ID
        String query = "SELECT o FROM Order o WHERE o.user.id = :userId";
        TypedQuery<Order> typedQuery = em.createQuery(query, Order.class);
        typedQuery.setParameter("userId", userId);
        return typedQuery.getResultList();
    }

    // Close the entity manager
    public void close() {
        em.close();
        emf.close();
    }
}
