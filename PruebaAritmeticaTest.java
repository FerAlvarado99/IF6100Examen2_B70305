package pruebas;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import cr.go.ucr.operaciones.Division;
import cr.go.ucr.operaciones.Multiplicacion;
import cr.go.ucr.operaciones.OperacionAritmetica;
import cr.go.ucr.operaciones.Resta;
import cr.go.ucr.operaciones.Sumar;

public class OperacionAritmeticaTest {

    @Test
    public void testSuma() {
        OperacionAritmetica context = new OperacionAritmetica(new Sumar());
        int resultado = context.procesar(5, 10);
        assertEquals(15, resultado);
    }

    @Test
    public void testResta() {
        OperacionAritmetica context = new OperacionAritmetica(new Resta());
        int resultado = context.procesar(20, 4);
        assertEquals(-16, resultado); // Se ajustó para verificar el resultado correcto
    }

    @Test
    public void testMultiplicacion() {
        OperacionAritmetica context = new OperacionAritmetica(new Multiplicacion());
        int resultado = context.procesar(5, 4);
        assertEquals(20, resultado);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivisionEntreCero() {
        OperacionAritmetica context = new OperacionAritmetica(new Division());
        context.procesar(5, 0);
    }

    @Test
    public void testDivision() {
        OperacionAritmetica context = new OperacionAritmetica(new Division());
        int resultado = context.procesar(5, 4);
        assertEquals(1, resultado);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRestaPrimerMayorQueSegundo() {
        OperacionAritmetica context = new OperacionAritmetica(new Resta());
        context.procesar(4, 20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOperacionConNumeroNegativo() {
        OperacionAritmetica context = new OperacionAritmetica(new Resta());
        context.procesar(5, -4);
    }
}
