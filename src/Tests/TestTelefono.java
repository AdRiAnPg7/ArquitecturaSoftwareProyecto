package Tests;
import Logic.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTelefono {
	
	int numeroTelefono = 77556644;
	Plan planPrePago = new PlanPrePago();
	Plan planPostPago = new PlanPostPago();
	Plan planWow= new PlanWow();
	
	
	@Test
	void obtenerNumeroTelefonico() {
		Telefono telefono = new Telefono(numeroTelefono,null);
		assertEquals(numeroTelefono, telefono.obtenerNumero());
	}
	
	@Test
	void obtenerPlanPrePago() {
		Telefono telefono = new Telefono(numeroTelefono,planPrePago);
		assertEquals("PlanPrePago", telefono.obtenerPlan().obtenerNombre());
	}
	
	@Test
	void obtenerPlanPostPago() {
		Telefono telefono = new Telefono(numeroTelefono,planPostPago);
		assertEquals("PlanPostPago", telefono.obtenerPlan().obtenerNombre());
	}
	
	@Test
	void obtenerPlanWow() {
		Telefono telefono = new Telefono(numeroTelefono,planWow);
		assertEquals("PlanWow", telefono.obtenerPlan().obtenerNombre());
	}


}
