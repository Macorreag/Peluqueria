package VisorConsultas.view;

import javax.swing.JPanel;
import javax.swing.JButton;

public class PanelButtonQuery extends JPanel  {
	
		public JButton query,exit;	
	public PanelButtonQuery(){
		initComponents();
		addComponents();
		
	}
	private void initComponents(){
		query =new JButton("Consultar");
		query.setMnemonic('c');
		exit =new JButton("Salir");
		exit.setMnemonic('s');
	}
	private void addComponents(){
		add(query);
		add(exit);
	}
}
