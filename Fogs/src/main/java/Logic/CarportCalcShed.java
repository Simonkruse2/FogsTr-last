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

    /**
     * Calculates the amount of poles needed for a carport with shed. id is the
     * id on the material in the database that is used as poles innerLength is
     * the length of the carport minus 130 cm where 100 cm is the length the
     * roof can protrude in the front of the carport and the last 30 cm is the
     * length that the roof can protrude in the back. The length of the shed
     * (shedLength) is subtracted from the length, because the poles inside the
     * shed is predefined.
     * mat is a material with the parameters string description, double price 
     * amount is initialised as 8 cause there is 2 poles at the front of the 
     * carport and 6 inside the shed.
     * extraamount will either remain 0 or it will be redefined as the
     * innerLength divided by 310 cm (a predefined maximum distance allowed 
     * between poles). 1 is subtracted from this number since poles are already 
     * placed in each corder. This is multiplied by 2 because the poles needs 
     * to be placed in both sides.
     * @param length the length of the carport
     * @param width the width of the carport
     * @param shedlength the length of the shed
     * @param shedwidth the width of the shed
     * @return a material with a new Description, MaterialPrice, Unit and the
     * new calculated Amount, TotalPrice
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Material poles(int length, int width, int shedlength, int shedwidth) throws SQLException, ClassNotFoundException {
        int id = 24;
        int innerLength = length - (130 + shedlength);
        int extraamount;

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

    /**
     * Calculates the amount of poles needed for a carport with shed in the
     * drawing of a carport with shed (not yet implemented).
     * the amount is the length of the carport minus 130 cm where 100 cm is the 
     * length the roof can protrude in the front of the carport and the last 
     * 30 cm is the length that the roof can protrude in the back. The length of
     * the shed (shedLength) is subtracted from the length, because the poles 
     * inside the shed is predefined. This is then divided by 310 cm (a predefined maximum
     * distance allowed between poles).
     *
     * @param length length of the carport
     * @param shedlength length of the shed
     * @return a double that represents the amount of poles needed for the
     * drawing
     */
    public double polesDrawing(int length, int shedlength) {
        return (double) ((length - (130 + shedlength)) / 310);

    }

    /**
     * Calculates the distance between poles for a carport with shed in the
     * drawing of a carport with shed (not yet implemented).
     * the distance is the length of the carport minus 130 cm where 100 cm is 
     * the length the roof can protrude in the front of the carport and the last
     * 30 cm is the length that the roof can protrude in the back
     * the length of the shed (shedLength) is subtracted from the length, 
     * because the poles inside the shed is predefined. This is then divided by 
     * number of poles (polesDrawing)
     *
     * @param length
     * @param shedlength
     * @return a double that represents the distance between poles (used for
     * drawing of carport with shed)
     */
    public double poleDist(int length, int shedlength) {
        return (length - (130 + shedlength)) / polesDrawing(length, shedlength);
    }

    /**
     * Calculates the amount of beams needed for a carport with shed. id is the
     * id on the material in the database that is used as beams mat is a
     * material with the parameters string description, double price amount is
     * initialised as 2 cause there is 2 beams - 1 in each side
     *
     * @param length length of the carport
     * @return a material with a new Description, MaterialPrice, Unit and the
     * new calculated Amount, TotalPrice
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Material beamsLength(int length) throws SQLException, ClassNotFoundException {
        int id = 14;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setAmount(2);
        mat.setLength(length);
        mat.setTotalPrice(mat.getPrice() * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }

    /**
     * Calculates the amount of rafts needed for a carport with shed. id is the
     * id on the material in the database that is used as rafts mat is a
     * material with the parameters String description, double price amount is
     * calculated by taking the length, divide it by 60 (the maximum distance
     * allowed between each raft) and adding 1 to this because there needs to be
     * 1 raft at each end of the carport
     *
     * @param length length of the carport
     * @param width width of the carport
     * @param shedlength length of the shed
     * @param shedwidth width of the shed
     * @return a material with a new Description, MaterialPrice, Unit and the
     * new calculated Amount, TotalPrice
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Material rafts(int length, int width, int shedlength, int shedwidth) throws SQLException, ClassNotFoundException { //spær
        int id = 21;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setLength(width);
        int amount = (int) Math.ceil((length / 60) + 1); //cm cm cm!
        mat.setAmount(amount);
        mat.setTotalPrice(mat.getPrice() * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }

    /**
     * Calculates the distance between rafts for a carport with shed in the
     * drawing of a carport with shed (not yet implemented). the distance is the
     * length of the carport divided by amount of rafts (raftDistance)
     *
     * @param length length of the carport
     * @param width width of the carport
     * @param shedlength length of the shed
     * @param shedwidth width of the shed
     * @return distance
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public double raftDistance(int length, int width, int shedlength, int shedwidth) throws SQLException, ClassNotFoundException {
        double distance = (double) (length / rafts(length, width, shedlength, shedwidth).getAmount());
        return distance;
    }

    /**
     * Calculates the amount of fittings for the port is needed for a carport
     * with shed. id is the id on the material in the database that is used as
     * fittings mat is a material with the parameters String description, double
     *  price pamount is defined as number of poles but represents the
     * number of fittings needed for the poles ramount is defined as 2 times the
     * number of rafts but represents the number of fittings needed on each raft
     * (1 on each side) amount is the total number of fittings needed for the
     * carport
     *
     * @param length length of the carport
     * @param width width of the carport
     * @param shedlength length of the shed
     * @param shedwidth width of the shed
     * @return a material with a new Description, MaterialPrice, Unit and the
     * new calculated Amount, TotalPrice
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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

    /**
     * Calculates the amount of screws needed for the fittings of the carport
     * with shed. id is the id on the material in the database that is used as
     * screws for the fittings mat is a material with the parameters String description, double
     * price amount is defined as 6 (number of screws per fitting) times
     * the amount of portFittings 300 is the number of screws in a pack
     *
     * @param length length of the carport
     * @param width with of the carport
     * @param shedlength length of the shed
     * @param shedwidth width of the shed
     * @return a material with a new Description, MaterialPrice, Unit and the
     * new calculated Amount, TotalPrice
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Material screwFittings(int length, int width, int shedlength, int shedwidth) throws SQLException, ClassNotFoundException {
        int id = 6;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        int amount = 6 * portFittings(length, width, shedlength, shedwidth).getAmount();
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
     * Calculates the amount of frames needed on the sides for a carport with
     * shed. id is the id on the material in the database that is used as frame
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
        int id = 17;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setLength(length);
        mat.setAmount(2);
        mat.setTotalPrice(mat.getPrice() * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }

    /**
     * Calculates the amount of frames needed in the front and back of carport
     * with shed. id is the id on the material in the database that is used as
     * frame mat is a material with the parameters String description, double
     * price amount of frames is 2 because there needs to be 1 in the front and
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
        int id = 17;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setLength(width);
        mat.setAmount(2);
        mat.setTotalPrice(mat.getPrice() * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }

    /**
     * Calculates the amount of screws needed for the frame of the carport with shed.
     * id is the id on the material in the database that is used as screws for the frames
     * mat is a material with the parameters string description, double price 
     * lamount is initialised as 2 times 2 times the number of rafts because 
     * there is 2 screws per raft but also in both sides.
     * wamount is 2 times the width divided by 60, 2 represents 2 screws per position
     * and the 60 is the distance between each position
     * @param length length of carport
     * @param width width of carport
     * @param shedlength length of shed
     * @param shedwidth width of shed
     * @return a material with a new Description, MaterialPrice, Unit and the
     * new calculated Amount, TotalPrice
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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
     * Calculates the amount needed in the skeleton of the shed's width. 
     * id is the id on the material in the database that is used as skeleton
     * mat is a material with the parameters string description, double price 
     * amount is sat as 4 because the skeleton of shed's front and back requires
     * 2 in the front and 2 in the back - 1 in middle and 1 at the bottom
     * @param length length of carport
     * @param width width of carport
     * @param shedwidth width of shed
     * @return a material with a new Description, MaterialPrice, Unit and the
     * new calculated Amount, TotalPrice
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public Material skeletonShedWidth(int length, int width, int shedwidth) throws SQLException, ClassNotFoundException {
        int id = 11;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setAmount(4);
        mat.setLength(shedwidth);
        mat.setTotalPrice(mat.getPrice() * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;

    }
        /**
     * Calculates the amount needed in the skeleton of the shed's width. 
     * id is the id on the material in the database that is used as skeleton
     * mat is a material with the parameters string description, double price 
     * amount is sat as 4 because the skeleton of shed's sides requires
     * 2 in each side - 1 in middle and 1 at the bottom
 * @param length length of carport
 * @param width width of carport
 * @param shedlength length of shed
 * @param shedwidth width of shed
     * @return a material with a new Description, MaterialPrice, Unit and the
     * new calculated Amount, TotalPrice
 * @throws SQLException
 * @throws ClassNotFoundException 
 */
    public Material skeletonShedLength(int length, int width, int shedlength, int shedwidth) throws SQLException, ClassNotFoundException {
        int id = 12;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setAmount(4);
        mat.setLength(shedwidth);
        mat.setTotalPrice(mat.getPrice() * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;

    }
/**
     * Calculates the amount of cover needed for a carport with shed. id is the
     * id on the material in the database that is used as cover for the shed
     * mat is a material with the parameters string description, double price
     * shedlength is divided by the width of the cover material (10 cm) and 
     * multiplied by 2 because the amount is for both sides.
     * shedwidth is divided by the width of the cover material (10 cm) and 
     * multiplied by 2 because the amount is for both ends.
 * @param length
 * @param width
 * @param shedlength
 * @param shedwidth
 * @return a material with a new Description, MaterialPrice, Unit and the
     * new calculated Amount, TotalPrice
 * @throws SQLException
 * @throws ClassNotFoundException 
 */
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
/**
     * Calculates the amount of screws needed for the cover of the shed.
     * id is the id on the material in the database that is used as screws for 
     * the cover of the shed
     * mat is a material with the parameters string description, double price
     * amount is initialised as the amount of cover for the shed multiplied by
     * 6 which represents the amount of screws needed per cover
     * this is multiplied by 18 which is the amount of screws estimated for the
     * door of the shed
 * @param length length of carport
 * @param width width of carport
 * @param shedlength length of shed
 * @param shedwidth width of shed
 * @return a material with a new Description, MaterialPrice, Unit and the
     * new calculated Amount, TotalPrice
 * @throws SQLException
 * @throws ClassNotFoundException 
 */
    public Material shedCoverScrews(int length, int width, int shedlength, int shedwidth) throws SQLException, ClassNotFoundException {
        int id = 9;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        int amount = shedCover(length, width, shedlength, shedwidth).getAmount() * 6 + 18;

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
     * Calculates the amount of t-hinges needed for the shed door. 
     * id is the id on the material in the database that is used as t-hinges for the door
     * mat is a material with the parameters string description, double price
     * amount is sat as 2 since there is 2 t-hinges for the door
 * @param length length of carport
 * @param width width of carport
 * @return a material with a new Description, MaterialPrice, Unit and the
     * new calculated Amount, TotalPrice
 * @throws SQLException
 * @throws ClassNotFoundException 
 */
    public Material shedDoor(int length, int width) throws SQLException, ClassNotFoundException {
        int id = 27;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setAmount(2);
        mat.setTotalPrice(mat.getPrice() * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }

 
/**
     * Calculates the skeleton needed for the shed door.
     * id is the id on the material in the database that is used as skeleton.
     * mat is a material with the parameters string description, double price 
     * amount is sat as 1 and length of the material is sat as 300 cm, this is assuming the customer
     * is cutting this material into the Z-skeleton for the door
 * @param length length of carport
 * @param width width of carport
 * @return a material with a new Description, MaterialPrice, Unit and the
     * new calculated Amount, TotalPrice
 * @throws SQLException
 * @throws ClassNotFoundException 
 */
    public Material doorSkeleton(int length, int width) throws SQLException, ClassNotFoundException {
        int id = 18;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setAmount(1);
        mat.setLength(300);
        mat.setTotalPrice(mat.getPrice() * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }

    /**
     * Calculates the amount of doorknobs needed for the shed door.
     * id is the id on the material in the database that is used as doorknob.
     * mat is a material with the parameters string description, double price 
     * amount is sat as 1 
     * @param length length of carport
     * @param width width of carport
     * @return a material with a new Description, MaterialPrice, Unit and the
     * new calculated Amount, TotalPrice
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public Material doorKnob(int length, int width) throws SQLException, ClassNotFoundException {
        int id = 26;
        Material mat = new Material(map.getMaterialDescription(id), map.getMaterialPrice(id));
        mat.setAmount(1);
        mat.setTotalPrice(mat.getPrice() * mat.getAmount());
        mat.setUnit(map.getMaterialUnit(id));
        return mat;
    }

    /**
     * runs and adds all the calculation methods that returns a material to the 
     * Material ArrayList
     * @param length length of carport
     * @param width width of carport
     * @param shedlength length of shed
     * @param shedwidth length of carport
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
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
        mArray.add(doorSkeleton(length, width));
        mArray.add(doorKnob(length, width));
    }

    /**
     * Returns the Material ArrayList
     * @return mArray Material ArrayList
     */
    public ArrayList<Material> partLists() {
        return mArray;
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
