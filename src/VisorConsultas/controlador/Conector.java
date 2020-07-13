package VisorConsultas.controlador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conector {
	Connection connection;
	String error;
	
	/* El constructor recibe cuatro parametros 
	 * el nombre del servidor MySQL,el usuario,
	 * la contraseña y la base de datos
	 */
	
public Conector(String host,String user,String pw,String base){
		try{
			/*Creamos la asociacion con el driver 
			 * 
			 */
			Class.forName("com.mysql.jdbc.Driver");
			/*
			 * la conexion se lleva a cabo mediante una cadena que sa 
			 * los parametros recibidos en l constructor
			 */
			//connection=DriverManager.getConnection("jdbc:mysql://"+host+"/"+base,user,pw);
			connection =DriverManager.getConnection("jdbc:mysql://"+host+":3306/"+base+"?useSSL=false",user,pw);
						
		}
		catch(ClassNotFoundException e){//Sucede si el driver no esta
			error=e.getMessage();
		}
		catch(SQLException e){ //sucede si la conexión falla
			error=e.getMessage();
		}
			
}
// metodo para devolver la conexion
	public Connection getConexion()	{
		 return connection;
	}
	public void CloseConnection(){
			try{
				connection.close();
			}
			catch(Exception ex){
				
			}
	}
	//este metodo devolvera el error que impide la conexion
	public String getMessageError(){
			return error;
	}
	
}
