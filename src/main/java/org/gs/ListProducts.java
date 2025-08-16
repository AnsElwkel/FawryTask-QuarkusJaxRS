
package org.gs;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.gs.dataaccess.Product;
import org.gs.dataaccess.ProductService;

import java.util.List;

@Path("/list-products")
public class ListProducts {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getProducts() {
        StringBuilder response = new StringBuilder("<h1>List of products</h1>");
        List<Product> products = ProductService.getInstance().getProducts();
        for (Product product : products) {
            response.append("<p>").append(product).append("</p>");
        }
        return response.toString();
    }


}