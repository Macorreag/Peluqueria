package VisorConsultas.controlador;

import  java.sql.Connection;
import 	java.sql.Statement;
import	java.sql.ResultSet;
import 	java.sql.ResultSetMetaData;
import 	java.sql.SQLException;

public class QuerySQL {
	private Connection connection;
	private ResultSet resultQuery;
	private ResultSetMetaData bigData;
	private String query;
	//Creamos  dos  arreglos
	
	private String[][] dataReturned;
	private String [] nameColumn;
	private String error;
	
	public QuerySQL(Connection connectionReceived,String queryReceived){
		connection=connectionReceived;
		query=queryReceived;
		
		
		try{
			/*	Crea una instanciaa para mandar sentencias al servidor
			 * de MySQL
			 */
			Statement judgment =connection.createStatement();
			//Ejecuta la consulta y devuelve el REsultSEt
			resultQuery=judgment.executeQuery(query);
			//obtiene los metadatos del REsultSet
			bigData=resultQuery.getMetaData();
			error=null;
			
		}
		catch(SQLException e){
			error=e.getMessage();
			
		}
		
	}
	public String[][] getDataReturned(){
		if(error==null){
			try{
				//devuelve el numero de columnas de resultSet
				int column=bigData.getColumnCount();
				//lleva el cursor a la ultima columna del resultset
				resultQuery.last();
				//obtiene el numero de fila actual (que aqui es la última)
				int row=resultQuery.getRow();
				//Dimensiona el arreglo de datosDevueltos con los enteros obtenido s
				dataReturned= new String[row][column];
				//ubica el cursor antes de la primera fila
				resultQuery.beforeFirst();
				for(int i=0;i<row;i++){
					//va a la siguiente fila
					resultQuery.next();
					for(int j=0;j<column;j++){
						//obtiene el valor de cada una de las columnas en la fila actual }
						dataReturned[i][j]=resultQuery.getString(j+1);
					}
					
				}
				
			}
			catch(Exception e){
				
			}
		}
		return dataReturned;
	}
	public String[] getNameColumn(){
	if(error==null){
		try{
			//Devuelve el número de columnas 
			int column=bigData.getColumnCount();
			nameColumn=new String[column];
			for(int i=0;i<column;i++){
				//obtiene el nombre de cada una de las columnas
				nameColumn[i]=bigData.getColumnLabel(i+1);
			}
		}
		catch(SQLException ex){
			
		}
	}
	return nameColumn;
}
	
	public String getMessageError(){
		return error;
	}
}
