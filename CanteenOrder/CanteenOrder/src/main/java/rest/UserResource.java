package rest;

import bean.UserBean;
import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.User;

import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @EJB
    private UserBean userBean;

    @POST
    public Response createUser(User user) {
        userBean.createUser(user);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{id}")
    public User getUser(@PathParam("id") Long id) {
        return userBean.findUser(id);
    }

    @GET
    public List<User> getAllUsers() {
        return userBean.findAllUsers();
    }

    @PUT
    @Path("/{id}")
    public Response updateUser(@PathParam("id") Long id, User user) {
        user.setId(id);
        userBean.updateUser(user);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") Long id) {
        userBean.deleteUser(id);
        return Response.noContent().build();
    }
}
