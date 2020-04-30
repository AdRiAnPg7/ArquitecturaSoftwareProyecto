package Logic;

public class PlanPrePago implements Plan {

	public TarifaStrategy tarifa;

	public String obtenerNombre(){
		return "PlanPrePago";
	}
	
	public void aniadirTarifa(TarifaStrategy tarifa) {
		this.tarifa = tarifa;
	}

	public float obtenerTarifa(CDR CDR) {
		return tarifa.calcularTarifa(CDR);
	}
}