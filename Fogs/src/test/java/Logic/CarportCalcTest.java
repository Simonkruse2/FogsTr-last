/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.Material;
import java.sql.SQLException;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vince
 */
public class CarportCalcTest {

    CarportCalc calc = new CarportCalc();

    public CarportCalcTest() {

    }

    @Test
    public void polesTest() throws SQLException, ClassNotFoundException {
        Material polesExpected = new Material("97x97 mm. trykimp. stolpe", 710);
        polesExpected.setAmount(6);
        polesExpected.setTotalPrice(6 * 710);
        polesExpected.setUnit("Stk");

        Material polesActual = calc.poles(780, 600);
        assertEquals(polesExpected, polesActual);
    }

    @Test
    public void polesDrawingTest() {
        double expected = 2;
        double actual = calc.polesDrawing(780);
        assertThat(actual, is(expected));
    }

    @Test
    public void polesDistTest() {
        double expected = 325;
        double actual = calc.poleDist(780);
        assertThat(actual, is(expected));
    }

    @Test
    public void beamsLengthTest() throws SQLException, ClassNotFoundException {
        Material expected = new Material("38x73 mm. Lægte ubh.", 1000);
        expected.setAmount(2);
        expected.setLength(780);
        expected.setTotalPrice(1000 * 2);
        expected.setUnit("Stk");
        Material actual = calc.beamsLength(780);
        assertEquals(expected, actual);
    }

    @Test
    public void raftTest() throws SQLException, ClassNotFoundException {
        Material expected = new Material("45x195 mm. spærtræ ubh.", 710);
        expected.setAmount(14);
        expected.setLength(600);
        expected.setTotalPrice(710 * 14);
        expected.setUnit("Stk");
        Material actual = calc.rafts(780,600);
        assertEquals(expected, actual);
    }

}
