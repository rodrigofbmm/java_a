package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CalculadoraTest {

    private Calculadora calc;

    @BeforeEach
    void configurar() {
        calc = new Calculadora();
    }

    @Test
    void testSuma() {
        assertEquals(5, calc.sumar(2, 3));
    }

    @Test
    void testResta() {
        // assertTrue(calc.restar(5, 3) == 2);
        //mejor:
        assertEquals(2, calc.restar(5, 3));
    }

    @Test
    void testEsPar() {
        assertAll(
                () -> assertTrue(calc.esPar(4)),
                () -> assertFalse(calc.esPar(5))
        );
    }

    @Test
    void testDivision() {
        assertEquals(5.0, calc.dividir(10, 2), 0.001);
    }

    @Test
    void testDivisionPorCero() {
        assertThrows(IllegalArgumentException.class, () -> calc.dividir(10, 0));
    }

    @Test
    void testObjetoNoNulo() {
        assertNotNull(calc);
    }
}