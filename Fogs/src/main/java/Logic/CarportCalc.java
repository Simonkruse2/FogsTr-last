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

    /**
     * Calculates the amount of poles needed for a carport.
     * id is the id on the material in the database that is used as poles 
     * innerLength is the length of the carport minus 130 cm where 100 cm is 
     * the length the roof can protrude in the front of the carport and the last
     * 30 cm is the length that the roof can protrude in the back.
     * mat is a material with the parameters string description, double price 
     * amount is initialised as 4 cause there is 1 pole in each corner.
     * extraamount will either remain 0 or it will be redefined as the
     * innerLength divided by 310 cm (a predefined maximum distance allowed 
     * between poles). 1 is subtracted from this number since poles are already 
     * placed in the front and back. This is multiplied by 2 because the poles 
     * needs to be placed in both sides.
     * @param length length of carport
     * @param width width of carport
     * @return a material with a new Description, MaterialPrice, Unit and the
     * new calculated Amount, TotalPrice
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
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
        mat.setTotalPrice(mat.getPrice() * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }
    /**
     * Calculates the amount of poles needed for a carport in the drawing of a 
     * carport.
     * the amount is the length of the carport minus 130 cm where 100 cm is the 
     * length the roof can protrude in the front of the carport and the last 
     * 30 cm is the length that the roof can protrude in the back. This is then 
     * divided by 310 cm (a predefined maximum distance allowed between poles).
     * @param length length of the carport
     * @return a double that represents the amount of poles needed for the
     * drawing
     */
    public double polesDrawing(int length) {
        return (double) ((length - 130) / 310);

    }

    /**
     * Calculates the distance between poles for a carport in the drawing of a 
     * carport.
     * the distance is the length of the carport minus 130 cm where 100 cm is 
     * the length the roof can protrude in the front of the carport and the last
     * 30 cm is the length that the roof can protrude in the back
     * this is then divided by number of poles (polesDrawing)
     *
     * @param length
     * @return a double that represents the distance between poles (used for
     * drawing of carport with shed)
     */
    public double poleDist(int length) {
        return (length - 130) / polesDrawing(length);
    }
    /**
     * Calculates the amount of beams needed for a carport.
     * id is the id on the material in the database that is used as beams
     * mat is a material with the parameters string description, double price 
     * amount is initialised as 2 cause there is 2 beams - 1 in each side
     * @param length length of the carport
     * @return a material with a new Description, MaterialPrice, Unit and the
     * new calculated Amount, TotalPrice
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Material beamsLength(int length) throws SQLException, ClassNotFoundException {
        int id = 18;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setAmount(2);
        mat.setLength(length);
        mat.setTotalPrice(mat.getPrice() * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }

    /**
     * Calculates the amount of rafts needed for a carport.
     * id is the id on the material in the database that is used as rafts
     * mat is a material with the parameters String description, double price
     * amount is calculated by taking the length, divide it by 60 (the maximum 
     * distance allowed between each raft) and adding 1 to this because there 
     * needs to be 1 raft at each end of the carport
     * @param length length of the carport
     * @param width width of the carport
     * @return a material with a new Description, MaterialPrice, Unit and the
     * new calculated Amount, TotalPrice
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Material rafts(int length, int width) throws SQLException, ClassNotFoundException { //spær
        int id = 21;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setLength(width);
        int numRafts = (int) Math.ceil((length / 60) + 1); //cm cm cm!
        mat.setAmount(numRafts);
        mat.setTotalPrice(mat.getPrice() * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }

    /**
     * Calculates the distance between rafts for a carport in the
     * drawing of a carport.
     * the distance is the length of the carport divided by amount of rafts 
     * (raftDistance)
     * @param length length of the carport
     * @param width width of the carport
     * @return distance 
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public double raftDistance(int length, int width) throws SQLException, ClassNotFoundException {
        double distance = (double) (length / rafts(length, width).getAmount());
        return distance;
    }

    /**
     * Calculates the amount of fittings for the port is needed for a carport.
     * id is the id on the material in the database that is used as fittings 
     * mat is a material with the parameters String description, double price 
     * pamount is defined as number of poles but represents the
     * number of fittings needed for the poles
     * ramount is defined as 2 times the number of rafts but represents the 
     * number of fittings needed on each raft (1 on each side)
     * amount is the total number of fittings needed for the carport
     * @param length length of the carport
     * @param width width of the carport
     * @return a material with a new Description, MaterialPrice, Unit and the
     * new calculated Amount, TotalPrice
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Material portFittings(int length, int width) throws SQLException, ClassNotFoundException { //corport beslag (til stolper og spær)
        int id = 25;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        int pamount = poles(length, width).getAmount(); // port amount
        int ramount = 2 * rafts(length, width).getAmount(); // raft amount
        mat.setAmount(pamount + ramount);
        mat.setTotalPrice(mat.getPrice() * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;

    }

    /**
     * Calculates the amount of screws needed for the fittings of the carport.
     * id is the id on the material in the database that is used as
     * screws for the fittings 
     * mat is a material with the parameters String description, double price 
     * amount is defined as 6 (number of screws per fitting) times
     * the amount of portFittings 300 is the number of screws in a pack
     * @param length length of the carport
     * @param width with of the carport
     * @return a material with a new Description, MaterialPrice, Unit and the
     * new calculated Amount, TotalPrice
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Material screwFittings(int length, int width) throws SQLException, ClassNotFoundException {
        int id = 6;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        int amount = 6 * portFittings(length, width).getAmount();
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

    /**
     * Calculates the amount of frames needed on the sides for a carport.
     * id is the id on the material in the database that is used as frame
     * mat is a material with the parameters String description, double price
     * amount of frames on the side is 2 because there needs to be one on each
     * side
     *
     * @param length length of carport
     * @param width width of carport
     * @return a material with a new Description, MaterialPrice, Unit and the
     * new calculated Amount, TotalPrice
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Material frameLength(int length, int width) throws SQLException, ClassNotFoundException { //frame for the lengthside
        int id = 17; //LAV NY I DATABASE
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setLength(length);
        mat.setAmount(2);
        mat.setTotalPrice(mat.getPrice() * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }

    /**
     * Calculates the amount of frames needed in the front and back of carport. 
     * id is the id on the material in the database that is used as frame
     * mat is a material with the parameters String description, double price 
     * amount of frames is 2 because there needs to be 1 in the front and
     * 1 in the back of the carport
     *
     * @param length length of carport
     * @param width width of carport
     * @return a material with a new Description, MaterialPrice, Unit and the
     * new calculated Amount, TotalPrice
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Material frameWidth(int length, int width) throws SQLException, ClassNotFoundException { //frame for the widthside
        int id = 17; //LAV NY I DATABASE
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setLength(width);
        mat.setAmount(2);
        mat.setTotalPrice(mat.getPrice() * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }

    /**
     * Calculates the amount of screws needed for the frame of the carport.
     * id is the id on the material in the database that is used as screws for the frames
     * mat is a material with the parameters string description, double price 
     * lamount is initialised as 2 times 2 times the number of rafts because 
     * there is 2 screws per raft but also in both sides.
     * wamount is 2 times the width divided by 60, 2 represents 2 screws per position
     * and the 60 is the distance between each position
     * @param length length of carport
     * @param width width of carport
     * @return a material with a new Description, MaterialPrice, Unit and the
     * new calculated Amount, TotalPrice
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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
    /**
     * runs and adds all the calculation methods that returns a material to the 
     * Material ArrayList
     * @param length length of carport
     * @param width width of carport
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
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

     /**
     * Returns the Material ArrayList
     * @return mArray Material ArrayList
     */
    public ArrayList<Material> partLists() {

        return m;
    }

    /**
 * Calculates a total price for the whole carport with shed.
 * @return price Total price of all materials calculated
 */
    public int getPrice() {
        int price = 0;
        for (int i = 0; i < partLists().size(); i++) {

            price += partLists().get(i).getTotalPrice();

        }
        return price;
    }

}
