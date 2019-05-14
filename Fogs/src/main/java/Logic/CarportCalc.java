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

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        CarportCalc cc = new CarportCalc();
        for (int i = 0; i < cc.partLists().size(); i++) {
            System.out.println(cc.partLists().get(i));
        }
        System.out.println(cc.poles(780, 600));
        System.out.println(cc.beamsLength(780));
        System.out.println(cc.rafts(780, 600));
        System.out.println(cc.portFittings(780, 600));
        System.out.println(cc.screwFittings(780, 600));
        System.out.println(cc.frameWidth(780, 600));
        System.out.println(cc.frameLength(780, 600));
        System.out.println(cc.screwFrame(780, 600));
        System.out.println(cc.plastmoShort(780, 600));
        System.out.println(cc.plastmoLong(780, 600));

    }

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
        m.add(mat);
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
        m.add(mat);
        return mat;
    }

    public Material rafts(int length, int width) throws SQLException, ClassNotFoundException { //spær
        int id = 21;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setLength(width);
        int numRafts = (int) Math.ceil((length / 60) + 1); //cm cm cm!
        mat.setAmount(numRafts);
        m.add(mat);
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
        m.add(mat);
        return mat;

    }

    public Material screwFittings(int length, int width) throws SQLException, ClassNotFoundException {
        int id = 6;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        int amount = 3 * portFittings(length, width).getAmount();
        mat.setAmount(amount);
        m.add(mat);
        return mat;
    }

    public Material frameLength(int length, int width) throws SQLException, ClassNotFoundException { //frame for the lengthside
        int id = 17; //LAV NY I DATABASE
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setLength(length);
        mat.setAmount(2);
        m.add(mat);
        return mat;
    }

    public Material frameWidth(int length, int width) throws SQLException, ClassNotFoundException { //frame for the widthside
        int id = 17; //LAV NY I DATABASE
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setLength(width);
        mat.setAmount(2);
        m.add(mat);
        return mat;
    }

    public Material screwFrame(int length, int width) throws SQLException, ClassNotFoundException {
        int id = 10;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));

        int lamount = 2 * 2 * rafts(length, width).getAmount();// length amount (lændgde siden)
        int wamount = 2 * width / 60;
        mat.setAmount(lamount + wamount);
        m.add(mat);
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
        m.add(mat);
        return mat;
    }

    public Material plastmoLong(int length, int width) throws SQLException, ClassNotFoundException {
        int id = 29;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        int carportSqrmtr = length * width / 100;

        mat.setAmount((int) Math.ceil(carportSqrmtr * 0.77 / 600));
        m.add(mat);
        return mat;
    }

    public ArrayList<Material> partLists() {
        return m;
    }

}
