package test;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import operaciones_a_testear.operaciones;
class operaciones_test {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void happyPathEsMayor() {
		boolean ret = operaciones.esMayor(2,4);
		assertEquals(true,ret);
	}
	


}
