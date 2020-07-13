package VisorConsultas.view;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import VisorConsultas.modelo.TableModel;

public class TableResult extends JScrollPane{
	
	public TableModel model; // crea una instancia del modelo 
	public JTable table;
	
	public TableResult()
	{
		model = new TableModel();
		table=new JTable(model);//se asign el modelo de tabla en el momento de construir la tabla 
		// las columnas  se autoajustan
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		setViewportView(table);// la tabla se vera dentro del panel de barras de dezplazamiento 
	}
}
