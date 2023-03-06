package Uzduotis1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SkaiciuotuvasTest {

    private Skaiciuotuvas skaiciuotuvas;

    @BeforeAll
    void initSkaiciuotuvas() {
        this.skaiciuotuvas = new Skaiciuotuvas();
    }
    @Test
    void sudeti() {
        Assertions.assertEquals(5,skaiciuotuvas.sudeti(2,3));
    }

    @Test
    void sudetiIntegerMax() {
        Assertions.assertEquals(Integer.MAX_VALUE+3,skaiciuotuvas.sudeti(Integer.MAX_VALUE,3));
    }

    @Test
    void dalinti() {
        Assertions.assertEquals(2, skaiciuotuvas.dalinti(6,3));
    }

    @Test
    void dalintiByZero() {
        Exception e = assertThrows(ArithmeticException.class, () ->  skaiciuotuvas.dalinti(6,0));
        assertEquals("Dalyba iš nulio!", e.getMessage());
    }

    @Test
    void istrauktiSakniFromZero() {

        Exception e = assertThrows(ArithmeticException.class, () -> skaiciuotuvas.istrauktiSkaiciausSakni(-2));
        assertEquals("Illegal square root from negative numbers", e.getMessage());
    }




}