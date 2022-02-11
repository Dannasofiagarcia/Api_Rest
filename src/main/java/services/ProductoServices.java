package services;

import model.Mensaje;
import model.Producto;
import providers.ProductoProvider;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("productos")
public class ProductoServices {

    @GET
    @Path("all")
    public Response getAll(){
        try {
            ProductoProvider provider = new ProductoProvider();
            ArrayList<Producto> productos = provider.getAllProductos();
            return Response
                    .ok(productos)
                    .header("Content-Type","application/json")
                    .build();
        } catch (SQLException exception) {
            exception.printStackTrace();
            return Response
                    .status(500)
                    .entity(new Mensaje("Operacion fallida"))
                    .header("Content-Type","application/json")
                    .build();
        }
    }
}
