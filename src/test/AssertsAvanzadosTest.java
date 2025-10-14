package test;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;


import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

public class AssertsAvanzadosTest {

    @Test
    void testArrayEquals() {
        int[] esperado = {1, 2, 3};
        int[] actual = {1, 2, 3};
        assertArrayEquals(esperado, actual, "Los arrays deben coincidir");
    }

    @Test
    void testIterableEquals() {
        List<String> esperado = List.of("uno", "dos", "tres");
        List<String> actual = List.of("uno", "dos", "tres");
        assertIterableEquals(esperado, actual, "Las listas deben ser iguales");
    }

    @Test
    void testTimeout() {
        assertTimeout(Duration.ofMillis(100), () -> Thread.sleep(50), "El método no debe superar los 100 ms");
    }

    @Test
    void testTimeoutPreemptively() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> Thread.sleep(80));
    }

    @Test
    void testSameYNotSame() {
        String texto = "hola";
        String referencia = texto;
        org.junit.jupiter.api.Assertions.assertSame(texto, referencia, "Ambas referencias deben apuntar al mismo objeto");


        String otro = new String("hola");
        org.junit.jupiter.api.Assertions.assertNotSame(texto, otro, "Los objetos son iguales en valor pero no en referencia");
    }

    @Test
    void testLineasTexto() {
        List<String> esperado = List.of("Linea 1", "Linea 2");
        List<String> actual = List.of("Linea 1", "Linea 2");
        assertLinesMatch(esperado, actual);
    }

    @Test
    void testInstanceOf() {
        Object valor = "Texto";
        assertInstanceOf(String.class, valor);
    }
}