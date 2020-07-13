package VisorConsultas.view;

import javax.swing.JDialog;

public class DialogAuthenticator extends JDialog {
	public AuthenticatorPanel panel;
	/*Este codigo solo muestra el panelautenticador
	 * es un cuadro de dialogo
	 */
	public DialogAuthenticator(){
		panel=new AuthenticatorPanel();//instancia nuestro panel autenticador
		add(panel);//añade el panel a. autenticador
		setSize(300,150);//dimesiona el dialog
		
		
	}
}


