package VisorConsultas.controlador;

import VisorConsultas.view.WindowQuery;
import java.awt.event.ActionEvent;
public class Control {
	Conector conMySQL;
	public  Control(){
		
	}
	public void action (WindowQuery viewfinder,ActionEvent evt){
		Object click=evt.getSource();
		if(click==viewfinder.authenticator.panel.accept){
			String host=viewfinder.authenticator.panel.server.getText();
			String user=viewfinder.authenticator.panel.user.getText();
			String  pw=new String(viewfinder.authenticator.panel.password.getPassword());
			String base=viewfinder.authenticator.panel.base.getText();
			conMySQL=new Conector(host,user,pw,base);
			if(conMySQL.getConexion()!=null)
				viewfinder.authenticator.dispose();
			else
				showError("El error que manda MySQL es :/n"+conMySQL.getMessageError());
			
		}
		if(click==viewfinder.button.query){
			QuerySQL query	=new QuerySQL(conMySQL.getConexion(),viewfinder.area.text.getText());
			if(query.getMessageError()==null)
				viewfinder.result.model.setDataVector(query.getDataReturned(), query.getNameColumn());
			else
				showError("El error que manda MySQL es:\n"+query.getMessageError());
		}
		if(click==viewfinder.authenticator.panel.cancel||click==viewfinder.button.exit)
			System.exit(0);
	}
	private void showError(String e){
		javax.swing.JOptionPane.showMessageDialog(null, e);
	}
	public static void main(String[] args){
		new VisorConsultas.view.WindowQuery();
		
	}
	

}
