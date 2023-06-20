package Diccionario;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class DiccioStringCompleto {

	static void contarApariciones(String[] arreglo) {
		
	  	Map<String, Integer> apariciones = new TreeMap<String, Integer>();
	    
		for (int i = 0; i < arreglo.length; i++) {
			
			
//			apariciones.put(arreglo[i], apariciones.getOrDefault(arreglo[i], 0) + 1);
			
			if (!apariciones.containsKey(arreglo[i]))			
				apariciones.put(arreglo[i], 1);			
			else
				apariciones.put(arreglo[i], apariciones.get(arreglo[i]) + 1);

		}
		
		System.out.println("Cuantas veces aparecen: ");
	 	System.out.println("------------------------");
		// imprime apariciones de cada elemento
		for (String s : apariciones.keySet())
			System.out.println(s + " aparece " + apariciones.get(s) + " veces.");
	 	System.out.println();
//		//imprime elementos diferentes
//		System.out.println(apariciones.keySet());
	}
	
	static void lugarApariciones(String[] arreglo) {
		
	  	Map<String, LinkedList<Integer>> apariciones = new TreeMap<String, LinkedList<Integer>>();
	  	
	  	
	  	for (int i = 0; i < arreglo.length; i++) {
	  		
//	  		apariciones.putIfAbsent(arreglo[i], new LinkedList<Integer>());
	  		
			if (!apariciones.containsKey(arreglo[i])) {			
				apariciones.put(arreglo[i], new LinkedList<Integer>());
			}
	  		
			apariciones.get(arreglo[i]).add(i);
	  	}
	  	
	  	System.out.println("Lugar de Apariciones: ");
	  	System.out.println("----------------------");
	  	System.out.println();
	  	for (String s : apariciones.keySet())
			System.out.println(s + " aparece en " + apariciones.get(s));
	  	System.out.println();
	}
	
	public static HashSet<String> palabras(){
		  
		
		return null;
	}
	

	
	public static void main(String[] args) {

		String[] pal = new String[10];
		
		pal[0]= "casa";	pal[1]= "hola";	pal[2]= "dia";
		pal[3]= "hola"; pal[4]= "casa";	pal[5]= "hola";
		pal[6]= "taza";	pal[7]= "dia";	pal[8]= "hola"; pal[9]= "casa";	
		
		contarApariciones(pal);
		
		lugarApariciones(pal);
	}

}
