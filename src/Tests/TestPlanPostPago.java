package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Logic.*;

class TestPlanPostPago {

	Plan planPostPago = new PlanPostPago();
	
	@Test
	void obtenerNombre() {
		assertEquals("PlanPostPago", planPostPago.obtenerNombre());
	}
	
}
