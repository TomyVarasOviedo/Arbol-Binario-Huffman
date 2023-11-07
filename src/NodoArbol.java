
public class NodoArbol implements Comparable<NodoArbol>{
	int dato;
	String nombre;
	NodoArbol hijoIzquierdo;
	NodoArbol hijoDerecho;
	int frecuencia;
	
	public NodoArbol (int frecuencia, String nom){
		this.frecuencia = frecuencia;
		this.hijoDerecho = null;
		this.hijoIzquierdo = null;
		this.nombre = nom; 
	}
	
	public String toString() {
		return nombre + " frecuencia " + frecuencia;
	}

	public int getDato() {
		return dato;
	}

	public String getNombre() {
		return nombre;
	}

	public NodoArbol getHijoIzquierdo() {
		return hijoIzquierdo;
	}

	public NodoArbol getHijoDerecho() {
		return hijoDerecho;
	}

	public int getFrecuencia() {
		return frecuencia;
	}
	@Override
	public int compareTo(NodoArbol otro) {
        return this.frecuencia - otro.frecuencia;
    }
}
