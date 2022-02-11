package services;

import model.Detalle;
import model.Mensaje;
import providers.DetalleProvider;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("detalles")
public class DetalleServices {

    @GET
    @Path("all")
    public Response getAll(){
        try {
            DetalleProvider provider = new DetalleProvider();
            ArrayList<Detalle> detalles = provider.getAllDetalles();
            return Response
                    .ok(detalles)
                    .header("Content-Type","application/json")
                    .build();
        } catch (SQLException exception) {
            exception.printStackTrace();
            return Response
                    .status(500)
                    .entity(new Mensaje("Operación fallida"))
                    .header("Content-Type","application/json")
                    .build();
        }
    }

}
