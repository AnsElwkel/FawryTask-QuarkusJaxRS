package org.gs;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.gs.dataaccess.Product;
import org.gs.dataaccess.ProductService;

import java.util.NoSuchElementException;

@Path("/update-product")
public class UpdateProduct {

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateProduct(@QueryParam("name") String name,
                                  @QueryParam("description") String description,
                                  @QueryParam("price") double price,
                                  @QueryParam("id") int id) {

        if(ProductService.getInstance().searchProduct(id)){
            ProductService.getInstance().updateProduct(id, name, description, price);
            return Response.ok("Product updated successfully").build();
        }else{
            return Response.status(404).entity("Product with ID " + id + " not found").build();
        }
    }
}
