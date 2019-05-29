package Data;

import java.util.Objects;

/**
 *
 * @author Jacob, Renz, Vincent og Simon.
 */

public class Material {

    private int id; // unique id number for product
    private String pname; //Productname - Produkt navn
    private double totalPrice; // total price - total pris
    private double price; // price pr. piece/package/roll - stk/pakke/rulle
    private int amount; // quantity of product
    private int length; // length of product
    private String unit; // unit of product - stk, pakke...

    /**
     * Material class is a constructor for creating a material. eventhought it
     * has more than one variable, it only contains two parameters.
     *
     * @param pname
     * @param price
     */
    public Material(String pname, double price) {
        this.pname = pname;
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getId() {
        return id;
    }

    public String getPname() {
        return pname;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public int getLength() {
        return length;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Material{" + "id=" + id + ", pname=" + pname + ", totalPrice=" + totalPrice + ", price=" + price + ", amount=" + amount + ", length=" + length + ", unit=" + unit + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.id;
        hash = 31 * hash + Objects.hashCode(this.pname);
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.totalPrice) ^ (Double.doubleToLongBits(this.totalPrice) >>> 32));
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 31 * hash + this.amount;
        hash = 31 * hash + this.length;
        hash = 31 * hash + Objects.hashCode(this.unit);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Material other = (Material) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.totalPrice) != Double.doubleToLongBits(other.totalPrice)) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (this.amount != other.amount) {
            return false;
        }
        if (this.length != other.length) {
            return false;
        }
        if (!Objects.equals(this.pname, other.pname)) {
            return false;
        }
        if (!Objects.equals(this.unit, other.unit)) {
            return false;
        }
        return true;
    }

}
