package PilaGenerica;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PilaTest {
	
	Pila<Integer> p1, p2, pVacia;
	Pila<String> p1s, p2s;
	
	@Before
	public void setUp() throws Exception {
		p1 = new Pila<Integer>();
		p1.apilar(20);
		p1.apilar(15);
		p1.apilar(25);
		
		p2 = new Pila<Integer>();
		p2.apilar(4);
		p2.apilar(8);
		
		pVacia = new Pila<Integer>();
		
		p1s = new Pila<String>();
		p2s = new Pila<String>();
	}

	@Test
	public void testApilar() {
		pVacia.apilar(12);
		assertEquals((Integer)12,pVacia.tope());
		
		p1s.apilar("copiar");
		p1s.apilar("pegar");
		assertEquals("pegar",p1s.tope());
	}

	@Test
	public void testDesapilar() {
		assertEquals((Integer)8,p2.desapilar());
		p1.desapilar();
		assertEquals((Integer)15,p1.tope());
	}

	@Test
	public void testTope() {
		assertEquals((Integer)25,p1.tope());
		assertEquals((Integer)8,p2.tope());
	}

	@Test
	public void testEsVacia() {
		assertFalse(p1.esVacia());
		assertFalse(p2.esVacia());
		assertTrue(pVacia.esVacia());
	}

}
