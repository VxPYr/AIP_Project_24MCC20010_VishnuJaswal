package bean;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import model.Order;

import java.util.List;

@Stateless
public class OrderBean {

    @PersistenceContext(unitName = "canteenPU")
    private EntityManager em;

    public void placeOrder(Order order) {
        em.persist(order);
    }

    public void updateOrder(Order order) {
        em.merge(order);
    }

    public void cancelOrder(Long orderId) {
        Order order = em.find(Order.class, orderId);
        if (order != null) {
            em.remove(order);
        }
    }

    public Order findOrder(Long id) {
        return em.find(Order.class, id);
    }

    public List<Order> findAllOrders() {
        return em.createQuery("SELECT o FROM Order o", Order.class).getResultList();
    }

    public List<Order> findOrdersByUserId(Long userId) {
        return em.createQuery("SELECT o FROM Order o WHERE o.user.id = :userId", Order.class)
                 .setParameter("userId", userId)
                 .getResultList();
    }
}
