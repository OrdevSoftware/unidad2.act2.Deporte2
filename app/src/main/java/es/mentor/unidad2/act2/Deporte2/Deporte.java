package es.mentor.unidad2.act2.Deporte2;

public class Deporte {
	
	 // Atributos
	 String name = null;
	 boolean selected = false;
	 private int icono;
	 
	 // Constructor
	 public Deporte(String titulo,  boolean selected, int icono) {
		 super();
		 this.icono = icono;
		 this.name = titulo;
		 this.selected = selected;
	 }
	  
	 
	 public String getName() {
		 return name;
	 }
	 public void setName(String name) {
		 this.name = name;
	 }
	 
	 public boolean isSelected() {
		 return selected;
	 }
	 public void setSelected(boolean selected) {
		 this.selected = selected;
	 }
	 
	 public int getIcono() {
		 return icono;
	 }

	 public void setIcono(int icono) {
		this.icono = icono;
	 }
}
