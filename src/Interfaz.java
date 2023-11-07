
import java.awt.Graphics;

import javax.swing.JPanel;
public class Interfaz  extends JPanel{
    private ArbolBinario arbol;
    private static final int DIAMETRTO = 30;
    private static final int RADIO = DIAMETRTO / 2;
    private static final int ANCHO = 30;
    /**
     * Metodo para asinar el arbol que se dibujara en la pantalla
     * @param arbol Arbol a dibujar
     */
    public void setArbol(ArbolBinario arbol) {
        this.arbol = arbol;
        repaint();
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        pintar(g, (this.getWidth()/2), 20,arbol.raiz);
    }
    /**
     * Metodo para pintar los elementos del arbol en el JPanel
     * @param g Obejcto para determinar que pintar en la pantalla
     * @param x CoOrdenadas en el eje X
     * @param y Coordenadas en el eje Y
     * @param subArbol Nodo de donde se extraen los datos necesarios para pintar en pantalla
     */
    private void pintar(Graphics g, int x, int y, NodoArbol subArbol) {
    	this.setBackground(java.awt.Color.BLACK);
    	g.setColor(java.awt.Color.CYAN);
        if (subArbol != null) {
            int EXTRA = arbol.nodosCompletos(subArbol) * ((ANCHO+20)/2);
            g.drawOval(x, y, DIAMETRTO, DIAMETRTO);
            g.drawString(String.valueOf(subArbol.nombre), x+12, y+18);
            if (subArbol.hijoIzquierdo != null) {
                g.drawLine(x, y + RADIO, x + RADIO - ANCHO - EXTRA, y + ANCHO);
            }
            if (subArbol.hijoDerecho != null) {
                g.drawLine( x + DIAMETRTO, y + RADIO, x + RADIO +ANCHO + EXTRA, y + ANCHO);
            }
            pintar(g, x - ANCHO - EXTRA, y + ANCHO, subArbol.hijoIzquierdo);
            pintar(g, x + ANCHO + EXTRA, y + ANCHO, subArbol.hijoDerecho);
        }
    }
}