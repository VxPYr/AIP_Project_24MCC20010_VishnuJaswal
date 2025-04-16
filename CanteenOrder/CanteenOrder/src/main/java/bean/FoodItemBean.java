package bean;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import model.FoodItem;

import java.util.List;

@Stateless
public class FoodItemBean {

    @PersistenceContext(unitName = "canteenPU")
    private EntityManager em;

    public void addFoodItem(FoodItem item) {
        em.persist(item);
    }

    public void updateFoodItem(FoodItem item) {
        em.merge(item);
    }

    public void deleteFoodItem(Long itemId) {
        FoodItem item = em.find(FoodItem.class, itemId);
        if (item != null) {
            em.remove(item);
        }
    }

    public FoodItem findFoodItem(Long id) {
        return em.find(FoodItem.class, id);
    }

    public List<FoodItem> getAllFoodItems() {
        return em.createQuery("SELECT f FROM FoodItem f", FoodItem.class).getResultList();
    }
}
