/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Data.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jacobfolkehildebrandt
 */
public class MaterialMapper {

    private int id;

    public MaterialMapper(int id) {
        this.id = id;
    }

    public String getMaterialDescription(int id) throws SQLException, ClassNotFoundException {
        String description = "";
        try {
            Connection con = DBConnector.connection();
            String query = "Select `description` from `materials` where `id_material` = " + id + ";";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                description = rs.getString("description");
            }
            return description;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public double getMaterialPrice(int id) throws SQLException, ClassNotFoundException {
        double price = 0;
        try {
            Connection con = DBConnector.connection();
            String query = "Select `price` from `materials` where `id_material` = " + id + ";";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                price = rs.getDouble("price");
            }
            return price;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }

    }

    public void getMaterialUnit(int id) throws SQLException, ClassNotFoundException {
        Connection con = DBConnector.connection();
        String SQL = "Select `unit` from `materials` where `id_material` = (?);";
        PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, id);

        ps.executeQuery();
    }

}
