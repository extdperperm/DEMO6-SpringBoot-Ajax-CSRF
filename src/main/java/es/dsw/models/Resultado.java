package es.dsw.models;

public class Resultado {

	private String Nombre;
	private String Fecha;
	private int NumHijos;
	private boolean IsError;
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	public int getNumHijos() {
		return NumHijos;
	}
	public void setNumHijos(int numHijos) {
		NumHijos = numHijos;
	}
	public boolean isIsError() {
		return IsError;
	}
	public void setIsError(boolean isError) {
		IsError = isError;
	}
	
	
}
