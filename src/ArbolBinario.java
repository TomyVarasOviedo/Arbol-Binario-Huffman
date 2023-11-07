
public class ArbolBinario {
	NodoArbol raiz;
	
	public ArbolBinario() {
		raiz = null;
	}
	
	public void agregarNodo(NodoArbol nodo) {
		NodoArbol nuevo = nodo;
		if(raiz==null) {
			raiz= nuevo;
		}else {
			NodoArbol aux = raiz;
			NodoArbol padre;
			while(true) {
				padre = aux;
				if (padre.hijoIzquierdo == null) {
					aux = aux.hijoIzquierdo;
					padre.hijoIzquierdo = nuevo;
						break;
				} else if (padre.hijoDerecho == null) {
						padre.hijoDerecho = nuevo;
						break;
				}
				else {
					aux = padre.hijoIzquierdo;
				}
			}
		}
	}
	
	public boolean estaVacio() {
		return raiz == null;
		//si raiz es null retorna un true, sino un false
	}
	
	public void inOrden(NodoArbol r) { // r es la raiz del arbol
		if (r != null) {
			inOrden(r.hijoIzquierdo);
			System.out.println(r.dato);
			inOrden(r.hijoDerecho);
		}
	}
	
	public void preOrden(NodoArbol r) {
		if (r != null) {
			System.out.println(r.dato);
			preOrden(r.hijoIzquierdo);
			preOrden(r.hijoDerecho);
		}
	}
	
	public void postOrden(NodoArbol r) {
		if (r != null) {
			postOrden(r.hijoIzquierdo);
			postOrden(r.hijoDerecho);
			System.out.println(r.dato);
			
		}
	}
	 /**
     * Metodo para saber cuantos nodos con dos hijos hay en el arbol
     * @param subArbol Nodo del arbol
     * @return Numero de nodos completos
     */
    public int nodosCompletos(NodoArbol subArbol) {
        if (subArbol == null) {
            return 0;
        } else {
            if (subArbol.hijoIzquierdo != null && subArbol.hijoDerecho != null) {
                return nodosCompletos(subArbol.hijoIzquierdo) + nodosCompletos(subArbol.hijoDerecho) + 1;
            }
            return nodosCompletos(subArbol.hijoIzquierdo) + nodosCompletos(subArbol.hijoDerecho);
        }
    }
}
