package providers;

import db.DBConnection;
import model.Consulta;
import model.Factura;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FacturaProvider {

    public ArrayList<Factura> getAllFacturas() throws SQLException {
        ArrayList<Factura> output = new ArrayList<>();

        String sql = "SELECT * FROM facturas";
        DBConnection connection = new DBConnection();
        connection.connect();

        ResultSet resultSet = connection.getDataBySQL(sql);
        while (resultSet.next()){
            output.add(new Factura(
                    resultSet.getInt(1),
                    resultSet.getString(2)
            ));
        }
        connection.disconnect();
        return output;
    }

    public ArrayList<Consulta> consulta(int id, int num_factura) throws SQLException {
        ArrayList<Consulta> output = new ArrayList<>();

        String sql = "SELECT * FROM facturas JOIN detalles ON facturas.id_cliente = " + id + " AND facturas.num_factura = detalles.id_factura AND facturas.num_factura = " + num_factura;
        DBConnection connection = new DBConnection();
        connection.connect();

        ResultSet resultSet = connection.getDataBySQL(sql);
        int num_f = 0;
        int id_c = 0;
        int cantidadTotal_productos = 0;
        double total = 0;
        double total_descuento = 0;

        while (resultSet.next()){
            if(num_f == 0 ) {
                num_f = resultSet.getInt(1);
            }
            if(id_c == 0) {
                id_c = resultSet.getInt(2);
            }
            cantidadTotal_productos += resultSet.getInt(6);
            total += resultSet.getDouble(7) * resultSet.getInt(6);
        }

        if(cantidadTotal_productos >= 5 && total > 1000000){
            total_descuento = total * 0.9;
        }

        output.add(new Consulta(
               num_f, id_c, cantidadTotal_productos, total, total_descuento
        ));
        connection.disconnect();
        return output;
    }
}
