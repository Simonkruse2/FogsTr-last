/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.Carport;
import Data.Material;
import Data.MaterialMapper;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarportCalcShed {

    /**
     *
     * @author simon
     * @param args
     */

    private ArrayList<Material> mArray = new ArrayList<>();
    int id;
    MaterialMapper map = new MaterialMapper(id);
    int length;
    int width;
    Carport c = new Carport(false, true, length, width);
    public Material poles(int length, int width) throws SQLException, ClassNotFoundException {
        int id = 24;
        int innerLength = length - (130 + c.getShedlength());
        int extraamount = 0;

        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));

        int amount = 8;
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
        return (double) ((length - (130 + c.getShedlength())) / 310);

    }

    public double poleDist(int length) {
        return (length - (130 + c.getShedlength())) / polesDrawing(length);
    }

    public Material beamsLength(int length) throws SQLException, ClassNotFoundException {
        int id = 14;
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
        int id = 17;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setLength(length);
        mat.setAmount(2);
        mat.setTotalPrice(map.getMaterialPrice(id) * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }

    public Material frameWidth(int length, int width) throws SQLException, ClassNotFoundException { //frame for the widthside
        int id = 17;
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

    public Material skeletonShedWidth(int length, int width) throws SQLException, ClassNotFoundException {
        int id = 11;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setAmount(4);
        mat.setLength(c.getShedwidth());
        mat.setTotalPrice(map.getMaterialPrice(id) * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;

    }

    public Material skeletonShedLength(int length, int width) throws SQLException, ClassNotFoundException {
        int id = 12;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setAmount(4);
        mat.setLength(c.getShedlength());
        mat.setTotalPrice(map.getMaterialPrice(id) * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;

    }

    public Material shedCover(int length, int width) throws SQLException, ClassNotFoundException {
        int id = 11;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        int amount = 0;
        amount += (c.getShedwidth() / 10) * 2; // length amount
        amount += ((c.getShedwidth() * 0.9) / 10) * 2;
        mat.setAmount(amount);
        mat.setTotalPrice(map.getMaterialPrice(id) * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }

    public Material shedCoverScrews(int length, int width) throws SQLException, ClassNotFoundException {
        int id = 9;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        int screwAmount = shedCover(length, width).getAmount() * 6 + 18;

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

    public Material shedDoor(int length, int width) throws SQLException, ClassNotFoundException {
        int id = 27;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setAmount(2);
        mat.setTotalPrice(map.getMaterialPrice(id) * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }

    public Material shedDoorScrews(int length, int width) throws SQLException, ClassNotFoundException {
        int id = 5;
        int count = 1;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        int screwAmount = shedDoor(length, width).getAmount() * 6;
        while (screwAmount > 300) {
            screwAmount -= 300;
            count++;
        }
        mat.setAmount(count);
        mat.setTotalPrice(map.getMaterialPrice(id) * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    } //kan nok udkommenteres / slettes

    public Material doorSkeleton(int length, int width) throws SQLException, ClassNotFoundException {
        int id = 18;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setAmount(1);
        mat.setLength(300);
        mat.setTotalPrice(map.getMaterialPrice(id) * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }

    public Material doorKnob(int length, int width) throws SQLException, ClassNotFoundException {
        int id = 26;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setAmount(1);
        mat.setTotalPrice(map.getMaterialPrice(id) * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }
        public void runCalc(int length, int width) throws SQLException, ClassNotFoundException {
        mArray.add(poles(length, width));
        mArray.add(beamsLength(length));
        mArray.add(rafts(length, width));
        mArray.add(portFittings(length, width));
        mArray.add(screwFittings(length, width));
        mArray.add(frameLength(length, width));
        mArray.add(frameWidth(length, width));
        mArray.add(screwFrame(length, width));
        mArray.add(plastmoShort(length, width));
        mArray.add(plastmoLong(length, width));
        mArray.add(skeletonShedWidth(length, width));
        mArray.add(skeletonShedLength(length, width));
        mArray.add(shedCover(length, width));
        mArray.add(shedCoverScrews(length, width));
        mArray.add(shedDoor(length, width));
        mArray.add(shedDoorScrews(length, width));
        mArray.add(doorSkeleton(length, width));
        mArray.add(doorKnob(length, width));
    }
        
        public ArrayList<Material> partLists() {
        return mArray;
    }

}
