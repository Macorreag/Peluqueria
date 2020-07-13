package VisorConsultas.view;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
public class QueryArea extends JScrollPane {// est clase es un panel desplazable
	
	public JTextArea text;
	
	public QueryArea(){
		text=new JTextArea(4,30);
		text.setLineWrap(true);//hace que las lineas corten en el limite del area 
		text.setWrapStyleWord(true);
		setViewportView(text);//dentro de las barras se vera el área de texto
		
	}

}
 
