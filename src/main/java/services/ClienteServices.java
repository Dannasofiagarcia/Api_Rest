package services;

import model.Cliente;
import model.Mensaje;
import providers.ClienteProvider;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("clientes")
public class ClienteServices {

    @GET
    @Path("all")
    public Response getAll(){
        try {
            ClienteProvider provider = new ClienteProvider();
            ArrayList<Cliente> clientes = provider.getAllClientes();
            return Response
                    .ok(clientes)
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
