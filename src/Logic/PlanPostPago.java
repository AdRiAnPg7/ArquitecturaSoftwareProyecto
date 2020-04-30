package Logic;

public class PlanPostPago implements Plan {
	
	public TarifaStrategy tarifa;
	
	public String obtenerNombre(){
		return "PlanPostPago";
	}

	public void aniadirTarifa(TarifaStrategy tarifa) {
		this.tarifa = tarifa;
	}
	
	public float obtenerTarifa(CDR CDR) {
		return tarifa.calcularTarifa(CDR);
	}

}
