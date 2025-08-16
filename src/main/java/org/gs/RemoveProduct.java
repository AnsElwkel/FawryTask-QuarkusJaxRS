package org.gs;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.gs.dataaccess.ProductService;

import java.util.NoSuchElementException;

@Path("/remove-product")
public class RemoveProduct {

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response removeProduct(@QueryParam("id") int id){

        if(ProductService.getInstance().searchProduct(id)){
            ProductService.getInstance().removeProduct(id);
            return Response.ok("Product removed successfully").build();
        }else
            return Response.status(Response.Status.NOT_FOUND).entity("Product with ID " + id + " not found").build();
    }
}
