package Logic;

public class PlanWow implements Plan {

	public TarifaStrategy tarifa;
	
	public String obtenerNombre(){
		return "PlanWow";
	}
	public void aniadirTarifa(TarifaStrategy tarifa) {
		this.tarifa = tarifa;
	}

	public float obtenerTarifa(CDR CDR) {
		return tarifa.calcularTarifa(CDR);
	}
}