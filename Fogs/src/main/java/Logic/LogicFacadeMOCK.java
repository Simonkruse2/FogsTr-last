/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author simon
 */
public class LogicFacadeMOCK implements LogicFacade {

    @Override
    public Carport createSimpleCarport(int length, int width) {
        return new Carport(false, false, length, width);
    }

    @Override
    public CarportCalc createSimpleCarportCalc(int length, int width) {
        return new CarportCalc();
    }

}
