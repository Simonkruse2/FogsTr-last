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
    private int price; // price pr. piece/package/roll - stk/pakke/rulle
    private int amount; // quantity of product
    private int length; // length of product

    public Material(String pname, int price) {
        this.pname = pname;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getPname() {
        return pname;
    }

    public int getPrice() {
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

    @Override
    public String toString() {
        return "Material{" + "id=" + id + ", pname=" + pname + ", price=" + price + ", amount=" + amount + ", length=" + length + '}';
    }
    
    
        
    
}
