import java.util.Comparator;

public class Ordenamiento implements Comparator<NodoArbol>{

    @Override
    public int compare(NodoArbol o1, NodoArbol o2) {
        if ((o1.hijoDerecho != null && o1.hijoIzquierdo != null) ) {
            return o1.getFrecuencia() - o2.getFrecuencia();
        }else if(o2.hijoDerecho != null && o2.hijoIzquierdo != null){
            return o1.getFrecuencia() - o2.getFrecuencia();
        }else{
            return o2.getFrecuencia() - o1.getFrecuencia();
        }
    }
    
}
