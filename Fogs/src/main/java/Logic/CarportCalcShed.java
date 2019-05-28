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

public class CarportCalcShed {

    /**
     *
     * @author simon
     * @param args
     */
    private ArrayList<Material> mArray = new ArrayList<>();
    int id;
    MaterialMapper map = new MaterialMapper(id);


    public Material poles(int length, int width, int shedlength, int shedwidth) throws SQLException, ClassNotFoundException {
        int id = 24;
        int innerLength = length - (130 + shedlength);
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
        mat.setTotalPrice(mat.getPrice() * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }

    public double polesDrawing(int length, int shedlength) {
        return (double) ((length - (130 + shedlength)) / 310);

    }

    public double poleDist(int length, int shedlength) {
        return (length - (130 + shedlength)) / polesDrawing(length, shedlength);
    }

    public Material beamsLength(int length) throws SQLException, ClassNotFoundException {
        int id = 14;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setAmount(2);
        mat.setLength(length);
        mat.setTotalPrice(mat.getPrice() * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }

    public Material rafts(int length, int width, int shedlength, int shedwidth) throws SQLException, ClassNotFoundException { //spær
        int id = 21;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setLength(width);
        int numRafts = (int) Math.ceil((length / 60) + 1); //cm cm cm!
        mat.setAmount(numRafts);
        mat.setTotalPrice(mat.getPrice() * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }

    public double raftDistance(int length, int width, int shedlength, int shedwidth) throws SQLException, ClassNotFoundException {
        double distance = (double) (length / rafts(length, width, shedlength, shedwidth).getAmount());
        return distance;
    }

    public Material portFittings(int length, int width, int shedlength, int shedwidth) throws SQLException, ClassNotFoundException { //corport beslag (til stolper og spær)
        int id = 25;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        int pamount = poles(length, width, shedlength, shedwidth).getAmount(); // port amount
        int ramount = 2 * rafts(length, width, shedlength, shedwidth).getAmount(); // raft amount
        mat.setAmount(pamount + ramount);
        mat.setTotalPrice(mat.getPrice() * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;

    }

    public Material screwFittings(int length, int width, int shedlength, int shedwidth) throws SQLException, ClassNotFoundException {
        int id = 6;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        int amount = 3 * portFittings(length, width, shedlength, shedwidth).getAmount();
        int count = 1;
        while (amount > 300) {
            amount -= 300;
            count++;
        }
        mat.setAmount(count);
        mat.setTotalPrice(mat.getPrice() * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }

    public Material frameLength(int length, int width) throws SQLException, ClassNotFoundException { //frame for the lengthside
        int id = 17;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setLength(length);
        mat.setAmount(2);
        mat.setTotalPrice(mat.getPrice() * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }

    public Material frameWidth(int length, int width) throws SQLException, ClassNotFoundException { //frame for the widthside
        int id = 17;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setLength(width);
        mat.setAmount(2);
        mat.setTotalPrice(mat.getPrice() * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }

    public Material screwFrame(int length, int width, int shedlength, int shedwidth) throws SQLException, ClassNotFoundException {
        int id = 10;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));

        int lamount = 2 * 2 * rafts(length, width, shedlength, shedwidth).getAmount();// length amount (lændgde siden)
        int wamount = 2 * width / 60;
        int screwAmount = lamount + wamount;
        int count = 1;
        while (screwAmount > 300) {
            screwAmount -= 300;
            count++;
        }
        mat.setAmount(count);
        mat.setTotalPrice(mat.getPrice() * mat.getAmount());
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
        mat.setTotalPrice(mat.getPrice() * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }

    public Material plastmoLong(int length, int width) throws SQLException, ClassNotFoundException {
        int id = 29;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        int carportSqrmtr = length * width / 100;

        mat.setAmount((int) Math.ceil(carportSqrmtr * 0.77 / 600));
        mat.setTotalPrice(mat.getPrice() * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }

    public Material skeletonShedWidth(int length, int width, int shedwidth) throws SQLException, ClassNotFoundException {
        int id = 11;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setAmount(4);
        mat.setLength(shedwidth);
        mat.setTotalPrice(mat.getPrice() * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;

    }

    public Material skeletonShedLength(int length, int width, int shedlength, int shedwidth) throws SQLException, ClassNotFoundException {
        int id = 12;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setAmount(4);
        mat.setLength(shedwidth);
        mat.setTotalPrice(mat.getPrice() * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;

    }

    public Material shedCover(int length, int width, int shedlength, int shedwidth) throws SQLException, ClassNotFoundException {
        int id = 11;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        int amount = 0;
        amount += (shedlength / 10) * 2; // length amount
        amount += (shedwidth / 10) * 2;
        mat.setAmount(amount);
        mat.setTotalPrice(mat.getPrice() * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }

    public Material shedCoverScrews(int length, int width, int shedlength, int shedwidth) throws SQLException, ClassNotFoundException {
        int id = 9;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        int screwAmount = shedCover(length, width, shedlength, shedwidth).getAmount() * 6 + 18;

        int count = 1;
        while (screwAmount > 300) {
            screwAmount -= 300;
            count++;
        }
        mat.setAmount(count);
        mat.setTotalPrice(mat.getPrice() * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }

    public Material shedDoor(int length, int width) throws SQLException, ClassNotFoundException {
        int id = 27;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setAmount(2);
        mat.setTotalPrice(mat.getPrice() * mat.getAmount());
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
        mat.setTotalPrice(mat.getPrice() * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    } //kan nok udkommenteres / slettes

    public Material doorSkeleton(int length, int width) throws SQLException, ClassNotFoundException {
        int id = 18;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setAmount(1);
        mat.setLength(300);
        mat.setTotalPrice(mat.getPrice() * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }

    public Material doorKnob(int length, int width) throws SQLException, ClassNotFoundException {
        int id = 26;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setAmount(1);
        mat.setTotalPrice(mat.getPrice() * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }

    public void runCalc(int length, int width, int shedlength, int shedwidth) throws SQLException, ClassNotFoundException {
        mArray.add(poles(length, width, shedlength, shedwidth));
        mArray.add(beamsLength(length));
        mArray.add(rafts(length, width, shedlength, shedwidth));
        mArray.add(portFittings(length, width, shedlength, shedwidth));
        mArray.add(screwFittings(length, width, shedlength, shedwidth));
        mArray.add(frameLength(length, width));
        mArray.add(frameWidth(length, width));
        mArray.add(screwFrame(length, width, shedlength, shedwidth));
        mArray.add(plastmoShort(length, width));
        mArray.add(plastmoLong(length, width));
        mArray.add(skeletonShedWidth(length, width, shedwidth));
        mArray.add(skeletonShedLength(length, width, shedlength, shedwidth));
        mArray.add(shedCover(length, width, shedlength, shedwidth));
        mArray.add(shedCoverScrews(length, width, shedlength, shedwidth));
        mArray.add(shedDoor(length, width));
        mArray.add(shedDoorScrews(length, width));
        mArray.add(doorSkeleton(length, width));
        mArray.add(doorKnob(length, width));
    }

    public ArrayList<Material> partLists() {
        return mArray;
    }

    public int getPrice() {
        int price = 0;
        for (int i = 0; i < partLists().size(); i++) {
            price += partLists().get(i).getAmount() * partLists().get(i).getPrice();
        }
        return price;
    }
}
