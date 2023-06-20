package arbolesTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ArbolesAB.AB;

public class testAB {
	
	AB<String> ab1, abVacio;

	@Before
	public void setUp() throws Exception {
		abVacio = new AB<String>();

		ab1 = new AB<String>();
		ab1.agregar("A");
		ab1.agregar("B");
		ab1.agregar("C");
		ab1.agregar("D");
		ab1.agregar("E");
		ab1.agregar("F");
		ab1.agregar("G");
	}

	@Test
	public void testPertenece() {
		assertTrue(ab1.pertenece("F"));
		assertFalse(ab1.pertenece("J"));
		assertFalse(abVacio.pertenece("A"));
	}

	@Test
	public void testAltura() {
		assertEquals(4, ab1.altura());
		assertEquals(0, abVacio.altura());
	}

	@Test
	public void testCantNodos() {
		assertEquals(7, ab1.cantNodos());
		assertEquals(0, abVacio.cantNodos());
	}

	@Test
	public void testCantHojas() {
		assertEquals(0, abVacio.cantHojas());
		assertEquals(4, ab1.cantHojas());
		ab1.agregar("H");
		assertEquals(4, ab1.cantHojas());
		ab1.agregar("I");
		assertEquals(5, ab1.cantHojas());
	}

//	@Test
//	public void testBalanceado() {
//		assertFalse(ab1.balanceado());
//		assertTrue(abVacio.balanceado());
//		abVacio.agregar("A1");
//		assertTrue(abVacio.balanceado());
//		abVacio.agregar("B2");
//		assertTrue(abVacio.balanceado());
//		abVacio.agregar("C3");
//		assertTrue(abVacio.balanceado());
//		abVacio.agregar("D4");
//		assertTrue(abVacio.balanceado());
//		abVacio.agregar("E5");
//		assertTrue(abVacio.balanceado());
//		abVacio.agregar("F6");
//		assertFalse(abVacio.balanceado());
//	}
}