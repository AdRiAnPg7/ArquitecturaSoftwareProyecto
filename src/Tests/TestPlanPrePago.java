package Tests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import Logic.*;

class TestPlanPrePago {

	Plan planPrePago = new PlanPrePago();
	
	@Test
	void obtenerNombre() {
		assertEquals("PlanPrePago", planPrePago.obtenerNombre());
	}
	
}
