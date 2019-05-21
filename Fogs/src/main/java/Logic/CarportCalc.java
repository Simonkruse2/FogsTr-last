/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.Material;
import Data.MaterialMapper;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author simon
 */
public class CarportCalc {

    private ArrayList<Material> m = new ArrayList<>();
    int id;
    MaterialMapper map = new MaterialMapper(id);

    public Material poles(int length, int width) throws SQLException, ClassNotFoundException {

        int innerLength = length - 130;
        int extraamount = 0;
        int id = 24; //STOLPE ID
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));

        int amount = 4;
        if (innerLength < 310) {
            extraamount = 0;
        } else {
            extraamount = ((innerLength / 310) - 1) * 2;

        }
        amount += extraamount;
        mat.setAmount(amount);
        mat.setTotalPrice(map.getMaterialPrice(id) * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }

    public double polesDrawing(int length) {
        return (double) ((length - 130) / 310);

    }

    public double poleDist(int length) {
        return (length - 130) / polesDrawing(length);
    }

    public Material beamsLength(int length) throws SQLException, ClassNotFoundException {
        int id = 18;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setAmount(2);
        mat.setLength(length);
        mat.setTotalPrice(map.getMaterialPrice(id) * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }

    public Material rafts(int length, int width) throws SQLException, ClassNotFoundException { //spær
        int id = 21;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setLength(width);
        int numRafts = (int) Math.ceil((length / 60) + 1); //cm cm cm!
        mat.setAmount(numRafts);
        mat.setTotalPrice(map.getMaterialPrice(id) * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }

    public double raftDistance(int length, int width) throws SQLException, ClassNotFoundException {
        double distance = (double) (length / rafts(length, width).getAmount());
        return distance;
    }

    public Material portFittings(int length, int width) throws SQLException, ClassNotFoundException { //corport beslag (til stolper og spær)
        int id = 25;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        int pamount = poles(length, width).getAmount(); // port amount
        int ramount = 2 * rafts(length, width).getAmount(); // raft amount
        mat.setAmount(pamount + ramount);
        mat.setTotalPrice(map.getMaterialPrice(id) * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;

    }

    public Material screwFittings(int length, int width) throws SQLException, ClassNotFoundException {
        int id = 6;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        int amount = 3 * portFittings(length, width).getAmount();
        int count = 1;
        while (amount > 300) {
            amount -= 300;
            count++;
        }
        mat.setAmount(count);
        mat.setTotalPrice(map.getMaterialPrice(id) * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }

    public Material frameLength(int length, int width) throws SQLException, ClassNotFoundException { //frame for the lengthside
        int id = 17; //LAV NY I DATABASE
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setLength(length);
        mat.setAmount(2);
        mat.setTotalPrice(map.getMaterialPrice(id) * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }

    public Material frameWidth(int length, int width) throws SQLException, ClassNotFoundException { //frame for the widthside
        int id = 17; //LAV NY I DATABASE
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setLength(width);
        mat.setAmount(2);
        mat.setTotalPrice(map.getMaterialPrice(id) * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }

    public Material screwFrame(int length, int width) throws SQLException, ClassNotFoundException {
        int id = 10;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));

        int lamount = 2 * 2 * rafts(length, width).getAmount();// length amount (lændgde siden)
        int wamount = 2 * width / 60;
        int screwAmount = lamount + wamount;
        int count = 1;
        while (screwAmount > 300) {
            screwAmount -= 300;
            count++;
        }
        mat.setAmount(count);
        mat.setTotalPrice(map.getMaterialPrice(id) * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }

    /**
     *
     * @param length the outer length of the carport
     * @param width the outer width of the carport
     * @return
     */
    public Material plastmoShort(int length, int width) throws SQLException, ClassNotFoundException {
        int id = 28;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        int carportSqrmtr = length * width / 100;

        mat.setAmount((int) Math.ceil(carportSqrmtr * 0.46 / 360));
        mat.setTotalPrice(map.getMaterialPrice(id) * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }

    public Material plastmoLong(int length, int width) throws SQLException, ClassNotFoundException {
        int id = 29;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        int carportSqrmtr = length * width / 100;

        mat.setAmount((int) Math.ceil(carportSqrmtr * 0.77 / 600));
        mat.setTotalPrice(map.getMaterialPrice(id) * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }

    public void runCalc(int length, int width) throws SQLException, ClassNotFoundException {
        m.add(poles(length, width));
        m.add(beamsLength(length));
        m.add(rafts(length, width));
        m.add(portFittings(length, width));
        m.add(screwFittings(length, width));
        m.add(frameLength(length, width));
        m.add(frameWidth(length, width));
        m.add(screwFrame(length, width));
        m.add(plastmoShort(length, width));
        m.add(plastmoLong(length, width));
    }

    public ArrayList<Material> partLists() {

        return m;
    }

    public int getPrice() {
        int price = 0;
        for (int i = 0; i < partLists().size(); i++) {
            price += partLists().get(i).getPrice() * partLists().get(i).getAmount();
        }
        return price;
    }

}
