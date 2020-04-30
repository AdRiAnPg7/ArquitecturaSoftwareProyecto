package Logic;
import java.time.LocalTime;

public class CDR {
	Telefono telefonoOrigen;
	Telefono telefonoDestino;
	
	LocalTime horaInicioLlamada; 
	LocalTime tiempoDuracionLlamada;
	
	public CDR (Telefono telefonoOrigen, Telefono telefonoDestino, LocalTime horaInicioLlamada, LocalTime tiempoDuracionLlamada) {
		this.telefonoOrigen = telefonoOrigen;
		this.telefonoDestino = telefonoDestino;
		this.horaInicioLlamada = horaInicioLlamada;
		this.tiempoDuracionLlamada = tiempoDuracionLlamada;
	}
	
	public Telefono obtenerTelefonoOrigen() {
		return this.telefonoOrigen;
	}
	
	public Telefono obtenerTelefonoDestino() {
		return this.telefonoDestino;
	}
	
	public LocalTime obtenerHoraInicioLlamada() {
		return this.horaInicioLlamada;
	}
	
	public LocalTime obtenerDuracionLlamada() {
		return this.tiempoDuracionLlamada;
	}
	
	public void aniadirTelefonoOrigen(Telefono telefono) {
		this.telefonoOrigen = telefono;
	}
	
	public void aniadirTelefonoDestino(Telefono telefono) {
		this.telefonoDestino = telefono;
	}
	
	public void aniadirHoraInicioLlamada(LocalTime Hora) {
		this.horaInicioLlamada = Hora;
	}
	
	public void aniadirDuracionLlamada(LocalTime DuracionLlamada) {
		this.tiempoDuracionLlamada = DuracionLlamada;
	}
	
	public int obtenerNumeroDelTelefonoDestino() {
		return telefonoDestino.obtenerNumero();
	}
	
	public int obtenerNumeroDelTelefonoOrigen() {
		return telefonoOrigen.obtenerNumero();
	}
	
	public float obtenerTarifa(CDR CDR) {
		return telefonoOrigen.obtenerTarifaDelPlan(CDR);
	}
}
