
//import javax.swing.JOptionPane;
// import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


import javax.swing.JFrame;

public class App {

	public static void main(String[] args) {
		String palabra = "califlagilistico";
        Map<Character, Integer> frecuencias = new HashMap<>();
		PriorityQueue<NodoArbol> pilaPrioridad = new PriorityQueue<>();
        ArbolBinario arbol = new ArbolBinario();
        for (char c : palabra.toCharArray()) {
            // Mapea cada caracter de la palabra y la introduce en un diccionario
            frecuencias.put(c, frecuencias.getOrDefault(c, 0) + 1);
        }
		for (Map.Entry<Character, Integer> entrada : frecuencias.entrySet()) {
            // Introduce los nodos con la frecuencia en un lista con prioridad
            NodoArbol nodo = new NodoArbol(entrada.getValue(), String.valueOf(entrada.getKey()));
            pilaPrioridad.add(nodo);
        }
        System.out.println(pilaPrioridad);
		while (pilaPrioridad.size() > 1) { //Se repitira hasta que la lista tenga un solo nodo
            NodoArbol frecuencia1 = pilaPrioridad.poll();
            NodoArbol frecuencia2 = pilaPrioridad.poll();
            // Se sacan los nodos con menor frecuencia de la lista
            int frecuenciaNueva = frecuencia1.getFrecuencia() + frecuencia2.getFrecuencia(); //Suma las frecuencias de las letras
            NodoArbol nuevo = new NodoArbol(frecuenciaNueva,String.valueOf(frecuenciaNueva));
            nuevo.hijoIzquierdo = frecuencia1;
            nuevo.hijoDerecho = frecuencia2;
            // Crea el nodo y lo introduce en la pila con prioridad 
            pilaPrioridad.add(nuevo);
        }
        arbol.agregarNodo(pilaPrioridad.peek());
		Interfaz lienzo = new Interfaz();
        lienzo.setArbol(arbol);
        JFrame ventana = new JFrame();
        ventana.setBackground(java.awt.Color.BLACK);
        ventana.getContentPane().add(lienzo);
        ventana.setSize(800, 600);
        ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        imprimirCodigo(pilaPrioridad.peek(), "");
	}
    private static void imprimirCodigo(NodoArbol nodo, String codigo) {
        if (nodo.hijoIzquierdo == null && nodo.hijoDerecho == null) { //Si el nodo no tiene hijos imprime el codigo en binario
            System.out.println("Caracter: " + nodo.nombre + ", Codigo: " + codigo);
        } else { //Sino recorre el arbol concatenando los valores binarios pertinentes
            imprimirCodigo(nodo.hijoIzquierdo, codigo + '0');
            imprimirCodigo(nodo.hijoDerecho, codigo + '1');
        }
    }
}
