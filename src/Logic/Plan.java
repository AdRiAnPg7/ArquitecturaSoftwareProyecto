package Logic;

public interface Plan {
	
	public void aniadirTarifa(TarifaStrategy tarifa);
	public float obtenerTarifa(CDR CDR);
	public String obtenerNombre();
}
