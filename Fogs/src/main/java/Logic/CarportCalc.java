/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.Material;

/**
 *
 * @author simon
 */
public class CarportCalc {
    public static void main(String[] args) {
        CarportCalc cc = new CarportCalc();
        System.out.println(cc.poles(0, 1050));
    }

    public Material poles(int width, int length) {
        int innerLength = length - 130;
        int extraamount = 0;
        Material mat = new Material("pole", 500);

        int amount = 4;
        if (innerLength < 310) {
            extraamount = 0;
        } else {
            extraamount = ((innerLength / 300)-1)*2;

        }
        amount += extraamount;
        mat.setAmount(amount);
        return mat;
    }

    public Material beams(){
        
        return mat;
    }
}
