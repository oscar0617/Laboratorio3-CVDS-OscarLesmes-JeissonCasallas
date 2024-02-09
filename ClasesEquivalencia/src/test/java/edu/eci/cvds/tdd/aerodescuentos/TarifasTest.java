package edu.eci.cvds.tdd.aerodescuentos;

import org.junit.Assert;
import org.junit.Test;

public class TarifasTest {

    @Test
    public void validateInvalidAge() {
        try {
            double tarifa = CalculadorDescuentos.calculoTarifa(1000000, 20, -15);
            Assert.assertTrue(false);
        } catch (Exception e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void validateZeroAge() {
        try {
            double tarifa = CalculadorDescuentos.calculoTarifa(1000000, 20, 0);
            Assert.assertTrue(false);
        } catch (Exception e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void validateOverAge() {
        try {
            double tarifa = CalculadorDescuentos.calculoTarifa(1000000, 20, 190);
            Assert.assertTrue(false);
        } catch (Exception e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void validateNegativeDiscount() {
        try {
            double tarifa = CalculadorDescuentos.calculoTarifa(-1000000, 20, 35);
            Assert.assertTrue(false);
        } catch (Exception e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void validateNegativeAnticipateDays() {
        try {
            double tarifa = CalculadorDescuentos.calculoTarifa(1000000, -20, 35);
            Assert.assertTrue(false);
        } catch (Exception e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void validateUnderAgeDiscount() {
        double tarifa = CalculadorDescuentos.calculoTarifa(1000000, 15, 15);
        Assert.assertEquals(950000, tarifa, 0);
    }

    @Test
    public void validateNormalAge() {
        double tarifa = CalculadorDescuentos.calculoTarifa(1000000, 12, 25);
        Assert.assertEquals(1000000, tarifa, 0);
    }

    @Test
    public void validateOverAge1() {
        double tarifa = CalculadorDescuentos.calculoTarifa(1000000, 10, 70);
        Assert.assertEquals(920000, tarifa, 0);
    }

    @Test
    public void validateNormalPrice() {
        double tarifa = CalculadorDescuentos.calculoTarifa(1000000, 25, 17);
        Assert.assertEquals(800000, tarifa, 0);
    }

    @Test
    public void validateAnticipateDaysDiscount() {
        double tarifa = CalculadorDescuentos.calculoTarifa(1000000, 15, 25);
        Assert.assertEquals(1000000, tarifa, 0);
    }

    @Test
    public void validateAnticipateDaysOver20() {
        double tarifa = CalculadorDescuentos.calculoTarifa(1000000, 25, 75);
        Assert.assertEquals(770000, tarifa, 0);
    }
}
