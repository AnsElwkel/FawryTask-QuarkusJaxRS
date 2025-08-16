package org.gs;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.gs.dataaccess.Product;
import org.gs.dataaccess.ProductService;

@Path("/add-product")
public class AddProduct {
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProduct(@QueryParam("name") String name,
                               @QueryParam("description") String description,
                               @QueryParam("price") double price,
                               @QueryParam("id") int id) {

        if (ProductService.getInstance().searchProduct(id)) {
            return Response.status(Response.Status.CONFLICT).entity("Product with ID " + id + " already exists").build();
        }

        ProductService.getInstance().addProduct(new Product(name, id, description, price));
        return Response.status(Response.Status.CREATED).entity("Product added successfully").build();
    }
}
