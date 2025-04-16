package dao;

import model.FoodItem;
import jakarta.persistence.*;
import java.util.List;

public class FoodItemDao {

    private EntityManagerFactory emf;
    private EntityManager em;

    public FoodItemDao() {
        emf = Persistence.createEntityManagerFactory("canteenorderPU");
        em = emf.createEntityManager();
    }

    // Get all food items
    public List<FoodItem> getAllFoodItems() {
        TypedQuery<FoodItem> query = em.createQuery("SELECT f FROM FoodItem f", FoodItem.class);
        return query.getResultList();
    }

    // Get a specific food item by ID
    public FoodItem getFoodItemById(int id) {
        return em.find(FoodItem.class, id);
    }

    // Add a new food item
    public void addFoodItem(FoodItem foodItem) {
        em.getTransaction().begin();
        em.persist(foodItem);
        em.getTransaction().commit();
    }

    // Update an existing food item
    public void updateFoodItem(FoodItem foodItem) {
        em.getTransaction().begin();
        em.merge(foodItem);  // Merge will update the existing food item
        em.getTransaction().commit();
    }

    // Delete a food item
    public void deleteFoodItem(int id) {
        FoodItem foodItem = em.find(FoodItem.class, id);
        if (foodItem != null) {
            em.getTransaction().begin();
            em.remove(foodItem);
            em.getTransaction().commit();
        }
    }

    public void close() {
        em.close();
        emf.close();
    }
}
