/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

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

    private final int id;

    public MaterialMapper(int id) {
        this.id = id;
    }
/**
 * this method returns the MaterialDescription
 * @param id
 * @return
 * @throws SQLException
 * @throws ClassNotFoundException 
 */
    public String getMaterialDescription(int id) throws SQLException, ClassNotFoundException {
        String description = "";
        try {
            Connection con = DBConnector.connection();
            String SQL = "Select `description` from `materials` where `id_material` = ?;";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                description = rs.getString("description");
            }
            return description;
        } catch (ClassNotFoundException | SQLException ex) {
            return null;
        }
    }
/**
 * this method returns the materialPrice.
 * @param id
 * @return
 * @throws SQLException
 * @throws ClassNotFoundException 
 */
    public double getMaterialPrice(int id) throws SQLException, ClassNotFoundException {
        double price = 0;
        try {
            Connection con = DBConnector.connection();
            String SQL = "Select `price` from `materials` where `id_material` = ?;";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                price = rs.getDouble("price");
            }
            return price;
        } catch (ClassNotFoundException | SQLException ex) {
            return 0;
        }

    }
/**
 * This method returns the MaterialUnit.
 * @param id
 * @return
 * @throws SQLException
 * @throws ClassNotFoundException 
 */
    public String getMaterialUnit(int id) throws SQLException, ClassNotFoundException {
        String unit = "";
        try {
            Connection con = DBConnector.connection();
            String SQL = "Select `unit` from `materials` where `id_material` = ?;";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                unit = rs.getString("unit");
            }
            return unit;
        } catch (ClassNotFoundException | SQLException ex) {
            return null;
        }
    }

}
