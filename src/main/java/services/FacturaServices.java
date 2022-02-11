package services;

import model.Consulta;
import model.Factura;
import model.Mensaje;
import providers.FacturaProvider;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("facturas")
public class FacturaServices {

    @GET
    @Path("consulta/{id}/{num_factura}")
    public Response consulta(@PathParam("id") int id, @PathParam("num_factura")int num_factura){
        try {
            FacturaProvider provider = new FacturaProvider();
            ArrayList<Consulta> consultas = provider.consulta(id, num_factura);
            return Response
                    .ok(consultas)
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

    @GET
    @Path("all")
    public Response getAll(){
        try {
            FacturaProvider provider = new FacturaProvider();
            ArrayList<Factura> facturas = provider.getAllFacturas();
            return Response
                    .ok(facturas)
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
