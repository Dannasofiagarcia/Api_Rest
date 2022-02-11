package providers;

import db.DBConnection;
import model.Detalle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DetalleProvider {

    public ArrayList<Detalle> getAllDetalles() throws SQLException {
        ArrayList<Detalle> output = new ArrayList<>();

        String sql = "SELECT * FROM detalles";
        DBConnection connection = new DBConnection();
        connection.connect();

        ResultSet resultSet = connection.getDataBySQL(sql);
        while (resultSet.next()){
            output.add(new Detalle(
                    resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getInt(3),
                    resultSet.getInt(4),
                    resultSet.getDouble(5)
            ));
        }
        connection.disconnect();
        return output;
    }
}
