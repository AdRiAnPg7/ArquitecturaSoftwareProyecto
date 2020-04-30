package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Logic.*;

class TestPlanWow {

	Plan planWow = new PlanWow();
	
	@Test
	void obtenerNombre() {
		assertEquals("PlanWow", planWow.obtenerNombre());
	}

}
