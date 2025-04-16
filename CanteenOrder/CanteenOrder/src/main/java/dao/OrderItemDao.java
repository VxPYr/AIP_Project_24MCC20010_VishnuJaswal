package dao;

import model.OrderItem;
import jakarta.persistence.*;
import java.util.List;

public class OrderItemDao {
    
    private EntityManagerFactory emf;
    private EntityManager em;

    public OrderItemDao() {
        emf = Persistence.createEntityManagerFactory("CanteenOrderPU");
        em = emf.createEntityManager();
    }

    // Get all order items by order ID
    public List<OrderItem> getOrderItemsByOrderId(int orderId) {
        TypedQuery<OrderItem> query = em.createQuery("SELECT oi FROM OrderItem oi WHERE oi.order.id = :orderId", OrderItem.class);
        query.setParameter("orderId", orderId);
        return query.getResultList();
    }

    // Close the entity manager
    public void close() {
        em.close();
        emf.close();
    }
}
