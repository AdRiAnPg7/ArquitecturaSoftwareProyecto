package Tests;
import Logic.*;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

class TestCDR {
	
	int numeroOrigen = 77556644;
	int numeroDestino = 66116611;
	Plan planPrePago = new PlanPrePago();
	Telefono telefonoOrigen = new Telefono(numeroOrigen,planPrePago);
	Telefono telefonoDestino = new Telefono(numeroDestino,null);
	LocalTime horaInicioLlamada = LocalTime.parse("00:01:00");
	LocalTime tiempoDuracionLlamada = LocalTime.parse("00:01:00");
	
	CDR CDR= new CDR (telefonoOrigen,telefonoDestino,horaInicioLlamada,tiempoDuracionLlamada);
	@Test
	void dataCDR() {
		assertEquals(telefonoOrigen, CDR.obtenerTelefonoOrigen());
		assertEquals(telefonoDestino, CDR.obtenerTelefonoDestino());
		assertEquals(horaInicioLlamada, CDR.obtenerHoraInicioLlamada());
		assertEquals(tiempoDuracionLlamada, CDR.obtenerDuracionLlamada());
	}
	
	@Test
	void planNumeroOrigenCDR() {
		assertEquals(planPrePago, CDR.obtenerTelefonoOrigen().obtenerPlan());
	}

}
