/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.Material;

public class CarportCalcShed {

    /**
     *
     * @author simon
     * @param args
     */
    public static void main(String[] args) {
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
    public Material poles(int length, int width) {

        int innerLength = length - (130 + 210);
        int extraamount = 0;
        Material mat = new Material("pole", 500);

        int amount = 8;
        if (innerLength < 310) {
            extraamount = 0;
        } else {
            extraamount = ((innerLength / 310) - 1) * 2;

        }
        amount += extraamount;
        mat.setAmount(amount);
        return mat;
    }

    public double polesDrawing(int length) {
        return (double) ((length - (130 + 210)) / 310);

    }

    public double poleDist(int length) {
        return (length - (130 + 210)) / polesDrawing(length);
    }

    public Material beamsLength(int length) {
        Material mat = new Material("beam", 500);
        mat.setAmount(2);
        mat.setLength(length);
        return mat;
    }

    public Material rafts(int length, int width) { //spær
        Material mat = new Material("raft", 500);
        mat.setLength(width);
        int numRafts = (int) Math.ceil((length / 60) + 1); //cm cm cm!
        mat.setAmount(numRafts);
        return mat;
    }

    public double raftDistance(int length, int width) {
        double distance = (double) (length / rafts(length, width).getAmount());
        return distance;
    }

    public Material portFittings(int length, int width) { //corport beslag (til stolper og spær)
        Material mat = new Material("fitting", 500);
        int pamount = poles(length, width).getAmount(); // port amount
        int ramount = 2 * rafts(length, width).getAmount(); // raft amount
        mat.setAmount(pamount + ramount);
        return mat;

    }

    public Material screwFittings(int length, int width) {
        Material mat = new Material("screws", 500);
        int amount = 3 * portFittings(length, width).getAmount();
        mat.setAmount(amount);
        return mat;
    }

    public Material frameLength(int length, int width) { //frame for the lengthside
        Material mat = new Material("frame", 500);
        mat.setLength(length);
        mat.setAmount(2);
        return mat;
    }

    public Material frameWidth(int length, int width) { //frame for the widthside
        Material mat = new Material("frame", 500);
        mat.setLength(width);
        mat.setAmount(2);
        return mat;
    }

    public Material screwFrame(int length, int width) {
        Material mat = new Material("screws", 500);

        int lamount = 2 * 2 * rafts(length, width).getAmount();// length amount (lændgde siden)
        int wamount = 2 * width / 60;
        mat.setAmount(lamount + wamount);
        return mat;
    }

    /**
     *
     * @param length the outer length of the carport
     * @param width the outer width of the carport
     * @return
     */
    public Material plastmoShort(int length, int width) {
        Material plastmoShort = new Material("plastmoShort", 500);
        int carportSqrmtr = length * width / 100;

        plastmoShort.setAmount((int) Math.ceil(carportSqrmtr * 0.46 / 360));

        return plastmoShort;
    }

    public Material plastmoLong(int length, int width) {
        Material plastmoLong = new Material("plastmoLong", 500);
        int carportSqrmtr = length * width / 100;

        plastmoLong.setAmount((int) Math.ceil(carportSqrmtr * 0.77 / 600));

        return plastmoLong;
    }

    public Material skeletonShedWidth(int length, int width) {
        Material skeleton = new Material("shedbeams", 500);
        skeleton.setAmount(4);
        skeleton.setLength(width);
        return skeleton;

    }

    public Material skeletonShedLength(int length, int width) {
        Material skeleton = new Material("shedbeams", 500);
        skeleton.setAmount(4);
        skeleton.setLength(210);
        return skeleton;

    }

    public Material shedCover(int length, int width) {
        Material shedcover = new Material("shedcover", 500);
        int amount = 0;
        amount += (210/10)*2; // length amount
        amount += ((width*0.9)/10)*2;
        shedcover.setAmount(amount);
        return shedcover;
    }
    
    public Material shedCoverScrewes(int length, int width){
        Material screws = new Material("screws", 500);
        screws.setAmount(shedCover(length, width).getAmount()*6);
        return screws;
    }
    
    public Material shedDoor(int length, int width){
        Material hinge = new Material("hinge", 500);
        hinge.setAmount(2);
        return hinge;
    }
    
    public Material shedDoorScrews(int length, int width){
        Material doorScrews = new Material("doorScrews", 500);
        doorScrews.setAmount(shedDoor(length, width).getAmount() * 6);
        return doorScrews;
    }
    
    public Material doorSkeleton(int length, int width){
        Material doorSkeleton = new Material("doorSkeleton", 500);
        doorSkeleton.setAmount(1);
        doorSkeleton.setLength(300);
        return doorSkeleton;
    }
        public Material doorKnob(int length, int width){
        Material doorKnob = new Material("doorKnob", 500);
        doorKnob.setAmount(1);
        return doorKnob;
    }

}
