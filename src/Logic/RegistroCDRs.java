package Logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;

public class RegistroCDRs {
	
	ArrayList <CDR> CDRs  = new ArrayList<CDR>();
	
	public void leerCDRs() {
		
		Path filePath = Paths.get("C:\\Users\\Adrian\\eclipse-workspace\\TelefoniaViva\\CDRs.csv");

		try {
			BufferedReader br = Files.newBufferedReader(filePath);
			String linea ="";
			
			while((linea = br.readLine())!=null) {
				String[] datosDeLinea = linea.split(",");
			
				var telfOrigen = new Telefono(Integer.parseInt(datosDeLinea[0]), null);
				var telfDestino = new Telefono(Integer.parseInt(datosDeLinea[1]), null);
				var HoraInicioLlamada = LocalTime.parse(datosDeLinea[2]);
				var DuracionLlamada = LocalTime.parse(datosDeLinea[3]);
				
				
				CDR temporal = new CDR(telfOrigen,telfDestino,HoraInicioLlamada,DuracionLlamada);
				CDRs.add(temporal);
			}
			
		} catch(Exception e){
			System.err.println("No se encontro archivo");
		}
	}
	
	public void mostrarCDRs() {
		for (CDR CDR: CDRs) {
		    System.out.println(CDR.obtenerNumeroDelTelefonoOrigen() + " " +
		    				   CDR.obtenerNumeroDelTelefonoDestino() + " " +
		    				   CDR.obtenerHoraInicioLlamada() + " " +
		    				   CDR.obtenerDuracionLlamada());
		}
	}
	
	public void cargarPlanATelefonos() {
		Path filePath = Paths.get("C:\\Users\\Adrian\\eclipse-workspace\\TelefoniaViva\\Telefonos.csv");

		try {
			BufferedReader br = Files.newBufferedReader(filePath);
			String linea ="";
			
			while((linea = br.readLine())!=null) {
				String[] datosDeLinea = linea.split(",");
				if("PlanPrePago".equals(datosDeLinea[1]) ) {
					for (CDR CDR: CDRs) {
					    if(String.valueOf(CDR.obtenerNumeroDelTelefonoOrigen()).equals(datosDeLinea[0])) {
					    	var tarifa = new TarifaHorarios();
					    	var plan = new PlanPrePago();
					    	plan.aniadirTarifa(tarifa);
					    	CDR.telefonoOrigen.aniadirPlan(plan);
					    }
					}
				}
				else if("PlanPostPago".equals(datosDeLinea[1]) ) {
					for (CDR CDR: CDRs) {
					    if(String.valueOf(CDR.obtenerNumeroDelTelefonoOrigen()).equals(datosDeLinea[0])) {
					    	var tarifa = new TarifaNormal();
					    	var plan = new PlanPrePago();
					    	plan.aniadirTarifa(tarifa);
					    	CDR.telefonoOrigen.aniadirPlan(plan);
					    }
					}
				}
				else if("PlanWow".equals(datosDeLinea[1])) {
					for (CDR CDR: CDRs) {
					    if(String.valueOf(CDR.obtenerNumeroDelTelefonoOrigen()).equals(datosDeLinea[0])) {
					    	var tarifa = new TarifaAmigo();
					    	var plan = new PlanWow();
					    	tarifa.aniadirTelefonosAmigos(Integer.parseInt(datosDeLinea[2]));
					    	plan.aniadirTarifa(tarifa);
					    	CDR.telefonoOrigen.aniadirPlan(plan);
					    }
					}
				}
			}
			
		} catch(Exception e){
			System.err.println("No se encontro archivo");
		}
	}
	
	public void cargarCDRs() {
		
        File file = new File("C:\\Users\\Adrian\\eclipse-workspace\\TelefoniaViva\\Persistencia.csv");
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            
            for (CDR CDR: CDRs) {
            	var llamada = new Llamada();
            	llamada.aniadirCDR(CDR);
            	int telefonoOrigen = CDR.obtenerNumeroDelTelefonoOrigen();
            	int telefonoDestino = CDR.obtenerNumeroDelTelefonoDestino();
            	String HoraInicio = CDR.obtenerHoraInicioLlamada().toString();
            	String DuracionLlamada = CDR.obtenerDuracionLlamada().toString();
            	String Costo = String.valueOf(llamada.calcularCosto());
          
            	pw.println(telefonoOrigen + "," + telefonoDestino + "," + HoraInicio + "," + DuracionLlamada + "," + Costo );
            	pw.flush();
            }
            pw.close();
            
        } catch (Exception e) {
        	System.err.println("No se pudo crear archivo");
        }
	}
}
