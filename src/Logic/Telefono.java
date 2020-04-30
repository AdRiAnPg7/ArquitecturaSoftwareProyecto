package Logic;

public class Telefono {
	private int numero;
	Plan plan;
	
	public Telefono (int numero, Plan plan) {
		this.numero = numero;
		this.plan = plan;
	}
	
	public void aniadirNumero(int numero) {
		this.numero = numero;
	}
	
	public int obtenerNumero() {
		return this.numero;
	}

	public void aniadirPlan(Plan plan) {
		this.plan = plan;
	}
	public Plan obtenerPlan() {
		return this.plan;
	}
	public float obtenerTarifaDelPlan(CDR CDR) {
		return plan.obtenerTarifa(CDR);
	}
}
