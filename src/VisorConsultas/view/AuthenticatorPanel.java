package VisorConsultas.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.GridLayout;


	// clase que sera un panel 
public class AuthenticatorPanel extends JPanel{
		//Crea los componentes necesarios:
		//3 cuadros de texto
		public JTextField server,user,base;
		//Un cuadro de texto para contraseñas
		public JPasswordField password;
		//dos botones
		public JButton accept,cancel;
	public AuthenticatorPanel()
	{
		startComponents();
		addComponents();
	}
	private void startComponents(){
		server=new JTextField();
		user=new JTextField();
		password=new JPasswordField();
		base=new JTextField();
		
		accept=new JButton("Aceptar");
		accept.setMnemonic('a');
		cancel=new JButton("Cancelar");
		cancel.setMnemonic('c');
	}
	private void addComponents(){
		/*Esta linea convierte el panel en una rejilla de cinco filas y dos columnas 
		 * que acomoda los componentes, conforme son agregados de izquierda a derecha
		 * de arriba abajo
		 */
		setLayout(new GridLayout(5,2));//La manera de acomodar los comoonentes es una rejilla 5x2
		//agrega los componentes al panel segun la rejilla de izquierda a derecha y derecha de arriba abajo
		add(new JLabel("Servidor",JLabel.RIGHT));
		add(server);
		add(new JLabel("Usuario",JLabel.RIGHT));
		add(user);
		add(new JLabel("Contraseña",JLabel.RIGHT));
		add(password);
		add(new JLabel("Base de datos",JLabel.RIGHT));
		add(base);
		add(accept);
		add(cancel);
		
	}
	
	

}
