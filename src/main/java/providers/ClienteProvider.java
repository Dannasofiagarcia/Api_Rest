package providers;

import db.DBConnection;
import model.Cliente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteProvider {

    /**
    public void createCliente(Cliente cliente) throws SQLException {
        Date fecha_nacimiento = new Date();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String noteDate = formatter.format(fecha_nacimiento);
        String sql = "INSERT INTO clientes(nombre, apellido, direccion, fecha_nacimiento, telefono, email, categoria) VALUES ('$NOMBRE','$APELLIDO', '$DIRECCION', $FECHA_NACIMIENTO', $TELEFONO', $EMAIL', $CATEGORIA')";
        sql = sql.replace("$NOMBRE", cliente.getNombre());
        sql = sql.replace("$APELLIDO", cliente.getApellido());
        sql = sql.replace("$DIRECCION", cliente.getDireccion());
        sql = sql.replace("$FECHA_NACIMIENTO", cliente.getFecha_nacimiento());
        sql = sql.replace("$TELEFONO", cliente.getTelefono());
        sql = sql.replace("$EMAIL", cliente.getEmail());
        sql = sql.replace("$CATEGORIA", cliente.getCategoria());
        DBConnection connection = new DBConnection();
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();
    }
    **/


    public ArrayList<Cliente> getAllClientes() throws SQLException {
        ArrayList<Cliente> output = new ArrayList<>();

        String sql = "SELECT * FROM clientes";
        DBConnection connection = new DBConnection();
        connection.connect();

        ResultSet resultSet = connection.getDataBySQL(sql);
        while (resultSet.next()){
            output.add(new Cliente(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8)
            ));
        }
        connection.disconnect();
        return output;
    }

    /**
    public void deleteByIdCliente(int id) throws SQLException {
        String sql = "DELETE FROM clientes WHERE id="+id;
        DBConnection connection = new DBConnection();
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();
    }
     **/
}
