package Logic;

public class Main {

	public static void main(String [ ] args) {
		
		RegistroCDRs CDRs = new RegistroCDRs();
		CDRs.leerCDRs();
		CDRs.cargarPlanATelefonos();
		CDRs.cargarCDRs();
		CDRs.mostrarCDRs();
		
	}

}
