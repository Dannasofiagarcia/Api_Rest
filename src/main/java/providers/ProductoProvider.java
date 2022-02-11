package providers;

import db.DBConnection;
import model.Producto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductoProvider {

    public ArrayList<Producto> getAllProductos() throws SQLException {
        ArrayList<Producto> output = new ArrayList<>();

        String sql = "SELECT * FROM productos";
        DBConnection connection = new DBConnection();
        connection.connect();

        ResultSet resultSet = connection.getDataBySQL(sql);
        while (resultSet.next()){
            output.add(new Producto(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getInt(4)
            ));
        }
        connection.disconnect();
        return output;
    }
}
