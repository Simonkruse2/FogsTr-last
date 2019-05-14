/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author jacobfolkehildebrandt
 */
public class Material {

    private int id; // unique id number for product
    private String pname; //Productname - Produkt navn
    private double totalPrice; // total price - total pris
    private double price; // price pr. piece/package/roll - stk/pakke/rulle
    private int amount; // quantity of product
    private int length; // length of product

    public Material(String pname, double price) {
        this.pname = pname;
        this.price = price;
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
        return "Material{" + "id=" + id + ", pname=" + pname + ", totalPrice=" + totalPrice + ", price=" + price + ", amount=" + amount + ", length=" + length + '}';
    }

}
