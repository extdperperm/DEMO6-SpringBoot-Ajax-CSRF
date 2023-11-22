package es.dsw.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import es.dsw.models.Resultado;


@Controller
public class IndexController {

	@GetMapping(value = {"/","/index"})
	public String idx() {
		
		return "index";
	}
	
	@GetMapping(value = {"/ejemplo1"})
	public String ejemplo1(@RequestParam(name="numrepe", defaultValue="0") int NumRepe,
					       @RequestParam(name="palabra", defaultValue="") String Palabra,
					       Model objModel
			) {
		
		String MensajeError = "";
		ArrayList<String> objLista = new ArrayList<String>();
		
		if (NumRepe <= 0) {
			MensajeError = "Error: Valor numérico incorrecto.";
		}
		
		if (Palabra.trim().equals("")) {
			MensajeError = "Error: Palabra vacía.";
		}
		
		if (MensajeError.equals("")) {
			for (int i = 1; i<=NumRepe; i++) {
				objLista.add(Palabra + " " + i);
			}
		}
		
		objModel.addAttribute("MensajeError", MensajeError);
		objModel.addAttribute("Lista", objLista);
		
		return "subviews/ejemplo1";
	}
	
	@PostMapping(value= {"/ejemplo2"}, produces="application/json")
	@ResponseBody
	public Resultado ejemplo2(@RequestParam(name="nom", defaultValue="") String nombre,
						@RequestParam(name="fecha", defaultValue="") String fecha,
						@RequestParam(name="hijos", defaultValue="-1") int hijos
			) {
		
		Resultado objResultado = new Resultado();
		objResultado.setNombre(nombre);
		objResultado.setFecha(fecha);
		objResultado.setNumHijos(hijos);
		objResultado.setIsError(false);
		
		if (nombre.equals("")) {
			objResultado.setIsError(true);
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return objResultado;
	}
	

}
