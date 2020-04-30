package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import Logic.*;

class TestTarifaAmigo {

	int numeroOrigen = 11111111;
	int numeroDestino = 88888888;
	TarifaAmigo tarifaAmigo = new TarifaAmigo();
	
	int numeroAmigo1 = 10101010;
	Telefono telefonoAmigo1 = new Telefono(numeroAmigo1,null);
	int numeroAmigo2 = 22222222;
	Telefono telefonoAmigo2 = new Telefono(numeroAmigo2,null);
	int numeroAmigo3 = 33333333;
	Telefono telefonoAmigo3 = new Telefono(numeroAmigo3,null);
	int numeroAmigo4 = 44444444;
	Telefono telefonoAmigo4 = new Telefono(numeroAmigo4,null);
	Plan planPrePago = new PlanPrePago();
	Plan planPostPago = new PlanPostPago();
	Plan planWow= new PlanWow();
	LocalTime horaInicioLlamada = LocalTime.parse("00:02:35");
	LocalTime Duracion1Minuto = LocalTime.parse("00:01:00");
	LocalTime Duracion2Minutos = LocalTime.parse("00:02:00");
	LocalTime Duracion10Minutos = LocalTime.parse("00:10:00");
	LocalTime Duracion1MinutoY10Segundos = LocalTime.parse("00:01:10");
	LocalTime Duracion2MinutosY30Segundos = LocalTime.parse("00:02:30");
	LocalTime Duracion10MinutosY55Segundos = LocalTime.parse("00:10:55");
	
	Telefono telefonoOrigen = new Telefono(numeroOrigen,null);
	Telefono telefonoDestino = new Telefono(numeroDestino,null);
	Llamada llamada = new Llamada() ;
	
	
	@Test
	void calcularTarifaAmigo() {
		var CDR= new CDR (telefonoOrigen,telefonoAmigo1,horaInicioLlamada,Duracion1Minuto);
		
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo1);
		planPrePago.aniadirTarifa(tarifaAmigo);
		
		telefonoOrigen.aniadirPlan(planPrePago);
		llamada.aniadirCDR(CDR);
		
		assertEquals( 0.00f, llamada.calcularCosto());
	}
	
	@Test
	void calcularTarifaAmigo2() {
		var CDR= new CDR (telefonoOrigen,telefonoAmigo2,horaInicioLlamada,Duracion1Minuto);
		
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo2);
		planPostPago.aniadirTarifa(tarifaAmigo);
		
		telefonoOrigen.aniadirPlan(	planPostPago);
		llamada.aniadirCDR(CDR);
		
		assertEquals( 0.00f, llamada.calcularCosto());
	}
	
	@Test
	void calcularTarifaAmigo3() {
		var CDR= new CDR (telefonoOrigen,telefonoAmigo3,horaInicioLlamada,Duracion1Minuto);
		
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo3);
		planWow.aniadirTarifa(tarifaAmigo);
		
		telefonoOrigen.aniadirPlan(	planWow);
		llamada.aniadirCDR(CDR);
		
		assertEquals( 0.00f, llamada.calcularCosto());
	}
	
	@Test
	void calcularTarifaAmigo4() {
		var CDR= new CDR (telefonoOrigen,telefonoDestino,horaInicioLlamada,Duracion1Minuto);
		
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo1);
		planPrePago.aniadirTarifa(tarifaAmigo);
		
		telefonoOrigen.aniadirPlan(planPrePago);
		llamada.aniadirCDR(CDR);
		
		assertEquals( 0.99f, llamada.calcularCosto());
	}
	
	@Test
	void calcularTarifaAmigo5() {
		var CDR= new CDR (telefonoOrigen,telefonoDestino,horaInicioLlamada,Duracion1Minuto);
		
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo2);
		planPostPago.aniadirTarifa(tarifaAmigo);
		
		telefonoOrigen.aniadirPlan(	planPostPago);
		llamada.aniadirCDR(CDR);
		
		assertEquals( 0.99f, llamada.calcularCosto());
	}
	
	@Test
	void calcularTarifaAmigo6() {
		var CDR= new CDR (telefonoOrigen,telefonoDestino,horaInicioLlamada,Duracion1Minuto);
		
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo3);
		planWow.aniadirTarifa(tarifaAmigo);
		
		telefonoOrigen.aniadirPlan(	planWow);
		llamada.aniadirCDR(CDR);
		
		assertEquals( 0.99f, llamada.calcularCosto());
	}
	
	@Test
	void calcularTarifaAmigo7() {
		var CDR= new CDR (telefonoOrigen,telefonoDestino,horaInicioLlamada,Duracion2Minutos);
		
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo1);
		planPrePago.aniadirTarifa(tarifaAmigo);
		
		telefonoOrigen.aniadirPlan(planPrePago);
		llamada.aniadirCDR(CDR);
		
		assertEquals( 1.98f, llamada.calcularCosto());
	}
	
	@Test
	void calcularTarifaAmigo8() {
		var CDR= new CDR (telefonoOrigen,telefonoDestino,horaInicioLlamada,Duracion10Minutos);
		
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo2);
		planPostPago.aniadirTarifa(tarifaAmigo);
		
		telefonoOrigen.aniadirPlan(	planPostPago);
		llamada.aniadirCDR(CDR);
		
		assertEquals( 9.90f, llamada.calcularCosto());
	}
	
	@Test
	void calcularTarifaAmigo9() {
		var CDR= new CDR (telefonoOrigen,telefonoDestino,horaInicioLlamada,Duracion1MinutoY10Segundos);
		
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo3);
		planWow.aniadirTarifa(tarifaAmigo);
		
		telefonoOrigen.aniadirPlan(	planWow);
		llamada.aniadirCDR(CDR);
		
		assertEquals( 1.15f, llamada.calcularCosto());
	}
	
	@Test
	void calcularTarifaAmigo10() {
		var CDR= new CDR (telefonoOrigen,telefonoDestino,horaInicioLlamada,Duracion2MinutosY30Segundos);
		
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo3);
		planWow.aniadirTarifa(tarifaAmigo);
		
		telefonoOrigen.aniadirPlan(	planWow);
		llamada.aniadirCDR(CDR);
		
		assertEquals( 2.47f, llamada.calcularCosto());
	}
	@Test
	void calcularTarifaAmigo11() {
		var CDR= new CDR (telefonoOrigen,telefonoDestino,horaInicioLlamada,Duracion10MinutosY55Segundos);
		
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo3);
		planWow.aniadirTarifa(tarifaAmigo);
		
		telefonoOrigen.aniadirPlan(	planWow);
		llamada.aniadirCDR(CDR);
	
		assertEquals( 10.81f, llamada.calcularCosto());
	}
}
