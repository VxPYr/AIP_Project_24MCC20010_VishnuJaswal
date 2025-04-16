package rest;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import dao.FoodItemDao;
import model.FoodItem;
import java.util.List;

@Path("/fooditems")
public class FoodItemResource {

    private FoodItemDao foodItemDao = new FoodItemDao();

    // Get all food items
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFoodItems() {
        List<FoodItem> foodItems = foodItemDao.getAllFoodItems();
        return Response.ok(foodItems).build();
    }

    // Get a specific food item by ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFoodItem(@PathParam("id") int id) {
        FoodItem foodItem = foodItemDao.getFoodItemById(id);
        if (foodItem != null) {
            return Response.ok(foodItem).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    // Add a new food item
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addFoodItem(FoodItem foodItem) {
        foodItemDao.addFoodItem(foodItem);
        return Response.status(Response.Status.CREATED).entity(foodItem).build();
    }

    // Update an existing food item
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateFoodItem(@PathParam("id") int id, FoodItem foodItem) {
        FoodItem existingFoodItem = foodItemDao.getFoodItemById(id);
        if (existingFoodItem == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        existingFoodItem.setName(foodItem.getName());
        existingFoodItem.setPrice(foodItem.getPrice());
        foodItemDao.updateFoodItem(existingFoodItem);
        return Response.ok(existingFoodItem).build();
    }

    // Delete a food item
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteFoodItem(@PathParam("id") int id) {
        FoodItem foodItem = foodItemDao.getFoodItemById(id);
        if (foodItem == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        foodItemDao.deleteFoodItem(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
