package es.mentor.unidad2.act2.Deporte2;

import java.util.ArrayList;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;


//Definimos el Adaptador que dibuja la opciones del listado de la ListActivity
class AdaptadorOpciones extends ArrayAdapter<Deporte> {
	Activity contexto;
	private ArrayList<Deporte> deporteList;
	 
	// Contructor del adaptador usando el contexto de la aplicaci�n actual
	 public AdaptadorOpciones(Activity context, int textViewResourceId, ArrayList<Deporte> deporteList) {
		 
		 super(context, textViewResourceId,deporteList);
		 
		 this.deporteList = new ArrayList<Deporte>();
		 this.deporteList.addAll(deporteList);
		 this.contexto = context;
	  }
	 
	 public  ArrayList<Deporte> getDeporteList(){
		 return this.deporteList;
	 }
	  // Clase que se usa para almacenar 1 etiqueta de tipo TextView, 1 etiqueta tipo CheckBox y un icono de tipo ImageView de una opci�n
	  private  class VistaTag {
		  TextView nombre;
		  CheckBox selected;
		  ImageView icono;
	  }
	 
	  // M�todo que dibuja la Vista de cada Opci�n
	  // Se invoca cada vez que haya que mostrar un elemento de la lista.
	  @Override
	  public View getView(int position, View convertView, ViewGroup parent) {
		   // Esta variable se usa para almacenar un objeto dentro de la Vista que dibuja la opci�n
		   VistaTag vistatag = null;
		   
		   //Log.v("ConvertView", String.valueOf(position));
		   
		   // Si Android indica que no hay una Vista reutilizable para la opci�n, la definimos, 
		   // inflamos el dise�o que se define en el fichero deporte_info.xml y establecemos su contenido
		   if (convertView == null) {
			   // Usamos un Inflater para inflar el dise�o
			   // Ahora tenemos una Vista que se asocia al elemento
			// Ahora tenemos una Vista que se asocia al elemento
				LayoutInflater vi = contexto.getLayoutInflater();


			   // Definimos en la vista de vuelta el tipo de dise�o
			   convertView = vi.inflate(R.layout.deporte_info, null);
		 
			   // Definimos el objeto que vamos a almacenar en el nuevo elemento
			   vistatag = new VistaTag();
			   // Obtenemos los punteros a las etiquetas reci�n infladas
			   vistatag.nombre = (TextView) convertView.findViewById(R.id.LblTitulo);
			   vistatag.selected = (CheckBox) convertView.findViewById(R.id.check);
			   vistatag.icono = (ImageView) convertView.findViewById(R.id.icono);
		  
			   // Guardamos el objeto en el elemento
			   convertView.setTag(vistatag);
		 
			   vistatag.selected.setOnClickListener( new View.OnClickListener() {  
				   public void onClick(View v) {  
					   CheckBox cb = (CheckBox) v ;  
					   Deporte deporte = (Deporte) cb.getTag();  
		      
					   deporte.setSelected(cb.isChecked());
				   }  
			   });  
		   }else {
			   // Si estamos reutilizando una Vista, recuperamos el objeto interno
			   vistatag = (VistaTag) convertView.getTag();
		   }
		 
		   
		   // Cargamos las opciones del elemento del ArrayList
		   Deporte deporte = deporteList.get(position);

		   vistatag.selected.setChecked(deporte.isSelected());
		   vistatag.nombre.setText(deporte.getName());
		   vistatag.icono.setImageResource(deporte.getIcono());
		   
		   vistatag.selected.setTag(deporte);
		 
		   // Devolvemos la Vista (nueva o reutilizada) que dibuja la opci�n
		   return convertView;
	  }
}

