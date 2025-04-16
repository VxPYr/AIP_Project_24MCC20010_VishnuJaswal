package rest;

import bean.OrderBean;
import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Order;

import java.util.List;

@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {

    @EJB
    private OrderBean orderBean;

    @POST
    public Response placeOrder(Order order) {
        orderBean.placeOrder(order);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{id}")
    public Order getOrder(@PathParam("id") Long id) {
        return orderBean.findOrder(id);
    }

    @GET
    public List<Order> getAllOrders() {
        return orderBean.findAllOrders();
    }

    @PUT
    @Path("/{id}")
    public Response updateOrder(@PathParam("id") Long id, Order order) {
        order.setId(id);
        orderBean.updateOrder(order);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response cancelOrder(@PathParam("id") Long id) {
        orderBean.cancelOrder(id);
        return Response.noContent().build();
    }

    @GET
    @Path("/user/{userId}")
    public List<Order> getOrdersByUser(@PathParam("userId") Long userId) {
        return orderBean.findOrdersByUserId(userId);
    }
}
