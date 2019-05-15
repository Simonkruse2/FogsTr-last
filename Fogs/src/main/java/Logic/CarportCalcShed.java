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
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        CarportCalcShed cc = new CarportCalcShed();
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
        System.out.println(cc.skeletonShedWidth(780, 600));
        System.out.println(cc.skeletonShedLength(780, 600));
        System.out.println(cc.shedCover(780, 600));
        System.out.println(cc.shedCoverScrewes(780, 600));
        System.out.println(cc.shedDoor(780, 600));
        System.out.println(cc.shedDoorScrews(780, 600));
        System.out.println(cc.doorSkeleton(780, 600));
        System.out.println(cc.doorKnob(780, 600));
    }

    private ArrayList<Material> mArray = new ArrayList<>();
    int id;
    MaterialMapper map = new MaterialMapper(id);

    public Material poles(int length, int width) throws SQLException, ClassNotFoundException {
        id = 24;
        int innerLength = length - (130 + 210);
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
        mArray.add(mat);
        return mat;
    }

    public double polesDrawing(int length) {
        return (double) ((length - (130 + 210)) / 310);

    }

    public double poleDist(int length) {
        return (length - (130 + 210)) / polesDrawing(length);
    }

    public Material beamsLength(int length) throws SQLException, ClassNotFoundException {
        id = 14;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setAmount(2);
        mat.setLength(length);
        mArray.add(mat);
        return mat;
    }

    public Material rafts(int length, int width) throws SQLException, ClassNotFoundException { //spær
        id = 21;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setLength(width);
        int numRafts = (int) Math.ceil((length / 60) + 1); //cm cm cm!
        mat.setAmount(numRafts);
        mArray.add(mat);
        return mat;
    }

    public double raftDistance(int length, int width) throws SQLException, ClassNotFoundException {
        double distance = (double) (length / rafts(length, width).getAmount());
        return distance;
    }

    public Material portFittings(int length, int width) throws SQLException, ClassNotFoundException { //corport beslag (til stolper og spær)
        id = 25;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        int pamount = poles(length, width).getAmount(); // port amount
        int ramount = 2 * rafts(length, width).getAmount(); // raft amount
        mat.setAmount(pamount + ramount);
        mArray.add(mat);
        return mat;

    }

    public Material screwFittings(int length, int width) throws SQLException, ClassNotFoundException {
        id = 6;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        int amount = 3 * portFittings(length, width).getAmount();
        int count = 1;
        while (amount > 300) {
            amount -= 300;
            count++;
        }
        mat.setAmount(count);
        mat.setTotalPrice(map.getMaterialPrice(id) * mat.getAmount());
        mArray.add(mat);
        return mat;
    }

    public Material frameLength(int length, int width) throws SQLException, ClassNotFoundException { //frame for the lengthside
        id = 17;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setLength(length);
        mat.setAmount(2);
        mArray.add(mat);
        return mat;
    }

    public Material frameWidth(int length, int width) throws SQLException, ClassNotFoundException { //frame for the widthside
        id = 17;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setLength(width);
        mat.setAmount(2);
        mArray.add(mat);
        return mat;
    }

    public Material screwFrame(int length, int width) throws SQLException, ClassNotFoundException {
        id = 10;
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
        mArray.add(mat);
        return mat;
    }

    /**
     *
     * @param length the outer length of the carport
     * @param width the outer width of the carport
     * @return
     */
    public Material plastmoShort(int length, int width) throws SQLException, ClassNotFoundException {
        id = 28;
        Material plastmoShort = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        int carportSqrmtr = length * width / 100;

        plastmoShort.setAmount((int) Math.ceil(carportSqrmtr * 0.46 / 360));
        mArray.add(plastmoShort);
        return plastmoShort;
    }

    public Material plastmoLong(int length, int width) throws SQLException, ClassNotFoundException {
        id = 29;
        Material plastmoLong = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        int carportSqrmtr = length * width / 100;

        plastmoLong.setAmount((int) Math.ceil(carportSqrmtr * 0.77 / 600));
        mArray.add(plastmoLong);
        return plastmoLong;
    }

    public Material skeletonShedWidth(int length, int width) throws SQLException, ClassNotFoundException {
        id = 11;
        Material skeleton = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        skeleton.setAmount(4);
        skeleton.setLength(width);
        mArray.add(skeleton);
        return skeleton;

    }

    public Material skeletonShedLength(int length, int width) throws SQLException, ClassNotFoundException {
        id = 12;
        Material skeleton = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        skeleton.setAmount(4);
        skeleton.setLength(210);
        mArray.add(skeleton);
        return skeleton;

    }

    public Material shedCover(int length, int width) throws SQLException, ClassNotFoundException {
        id = 11;
        Material shedcover = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        int amount = 0;
        amount += (210 / 10) * 2; // length amount
        amount += ((width * 0.9) / 10) * 2;
        shedcover.setAmount(amount);
        mArray.add(shedcover);
        return shedcover;
    }

    public Material shedCoverScrewes(int length, int width) throws SQLException, ClassNotFoundException {
        id = 9;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        int screwAmount = shedCover(length, width).getAmount() * 6 + 18;

        int count = 1;
        while (screwAmount > 300) {
            screwAmount -= 300;
            count++;
        }
        mat.setAmount(count);
        mat.setTotalPrice(map.getMaterialPrice(id) * mat.getAmount());
        mArray.add(mat);
        return mat;
    }

    public Material shedDoor(int length, int width) throws SQLException, ClassNotFoundException {
        id = 27;
        Material hinge = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        hinge.setAmount(2);
        mArray.add(hinge);
        return hinge;
    }

    public Material shedDoorScrews(int length, int width) throws SQLException, ClassNotFoundException {
        Material doorScrews = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        doorScrews.setAmount(shedDoor(length, width).getAmount() * 6);
        mArray.add(doorScrews);
        return doorScrews;
    } //kan nok udkommenteres / slettes

    public Material doorSkeleton(int length, int width) throws SQLException, ClassNotFoundException {
        id = 18;
        Material doorSkeleton = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        doorSkeleton.setAmount(1);
        doorSkeleton.setLength(300);
        mArray.add(doorSkeleton);
        return doorSkeleton;
    }

    public Material doorKnob(int length, int width) throws SQLException, ClassNotFoundException {
        id = 26;
        Material doorKnob = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        doorKnob.setAmount(1);
        mArray.add(doorKnob);
        return doorKnob;
    }
        public ArrayList<Material> partLists() {
        return mArray;
    }

}
