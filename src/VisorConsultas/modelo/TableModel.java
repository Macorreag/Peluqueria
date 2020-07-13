package VisorConsultas.modelo;
import javax.swing.table.DefaultTableModel;
public class TableModel extends DefaultTableModel{ // hereda de DefaultTableModel

	public	TableModel(){
			//dimensiona la tabla para la presentacion inicial
		setColumnCount(7);
		setRowCount(30);
	}
	
}
