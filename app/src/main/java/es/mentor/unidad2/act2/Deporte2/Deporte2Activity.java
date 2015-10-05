package es.mentor.unidad2.act2.Deporte2;

import java.util.ArrayList;


import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;



public class Deporte2Activity extends  ListActivity {
	AdaptadorOpciones  adaptador = null;
	 
	 @Override
	 public void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  setContentView(R.layout.main);
		 
		  //Generación de la Lista de ArrayList
		  displayListView();
		 
		  checkButtonClick();
	 }
	 
	 private void displayListView() {
	 
		  //Array list de deportes
		  ArrayList<Deporte> deporteList = new ArrayList<Deporte>();
		  Deporte deporte = new Deporte("Atletismo",false,R.drawable.atletismo);
		  deporteList.add(deporte);
		  deporte = new Deporte("Baloncesto",false,R.drawable.baloncesto);
		  deporteList.add(deporte);
		  deporte = new Deporte("Futbol",false,R.drawable.futbol);
		  deporteList.add(deporte);
		  deporte = new Deporte("Golf",false,R.drawable.golf);
		  deporteList.add(deporte);
		  deporte = new Deporte("Motociclismo",false,R.drawable.motociclismo);
		  deporteList.add(deporte);
		  deporte = new Deporte("Natacion",false,R.drawable.natacion);
		  deporteList.add(deporte);
		  deporte = new Deporte("Ping Pong",false,R.drawable.pingpong);
		  deporteList.add(deporte);
		 
		  //Creo el ArrayAdapter para el ArrayList de Deporte
		  adaptador = new AdaptadorOpciones(this,R.layout.deporte_info, deporteList);
		  // Asignamos el adaptador al ListActivity para que sepa cómo dibujar el listado de opciones
		  setListAdapter(adaptador);
	 }
	 
	 
	
	 
	private void checkButtonClick() {
		Button miBoton = (Button) findViewById(R.id.botonAceptar);
		miBoton.setOnClickListener(new OnClickListener() {
			@Override
		 	public void onClick(View v) {
		    StringBuffer respuestaText = new StringBuffer();
			Integer totales=0;
			Integer totalesAux=0;
		    
			ArrayList<Deporte> deporteList = adaptador.getDeporteList();
			    
		    // Vemos el número de checkbox seleccionados
		    for(int i=0;i<deporteList.size();i++){
		    	Deporte deporte = deporteList.get(i);
		    	if(deporte.isSelected()){
			    	 totales+=1;
		    	}
			 }
			    
		    // Preparamos la respuesta
		    respuestaText.append("Te gusta ");
		    
		    for(int i=0;i<deporteList.size();i++){
				 Deporte deporte = deporteList.get(i);
				 if(totalesAux==(totales-1)&&(totales>1)){
					 if(deporte.isSelected()){
						 // Concatenamos contenidos
						 respuestaText.append(" y " + deporte.getName());
						 totalesAux+=1;
					 }
				 }else if((totales>0)&&(totalesAux==0)){
					 if(deporte.isSelected()){
						 totalesAux+=1;
					 	 respuestaText.append(" " + deporte.getName());
					 }
				 } else if((totales==0)){
					 totalesAux+=1;
					 // Borramos el StringBuffer
					 respuestaText.delete(0, respuestaText.length());
					 respuestaText.append("No has seleccionado ninguna opcion");
				 } else{
					 if(deporte.isSelected()){
						 totalesAux+=1;
						 respuestaText.append(", " + deporte.getName());
					 }
				 }
		    }
			// Mostramos la respuesta utilizando la clase Toast
			Toast.makeText(getApplicationContext(), respuestaText, Toast.LENGTH_LONG).show();
		   }
	  	});
	}
}