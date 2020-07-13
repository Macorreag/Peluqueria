package VisorConsultas.view;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import VisorConsultas.controlador.Control;

public class WindowQuery extends JFrame  implements ActionListener{
			public DialogAuthenticator authenticator;
			public 	TableResult result;
			public 	QueryArea area;
			public 	PanelButtonQuery button;
			public	Control controllerDe;
	public WindowQuery(){
		startComponents();
		addComponents();
		addListeners();
		start();
	}
	private void startComponents(){
		authenticator= new DialogAuthenticator();
		result=new TableResult();
		area=new QueryArea();
		button=new PanelButtonQuery();
	}
		
	private void addComponents (){
		add(result,"South");
		add(area,"West");
		add(button,"East");
		pack();
		setLocation(100,100);
		
	}
	private void addListeners(){
		this.authenticator.panel.accept.addActionListener(this);
		this.authenticator.panel.cancel.addActionListener(this);
		button.query.addActionListener(this);
		button.exit.addActionListener(this);
	}
	public void start(){
	controllerDe=new Control();
		setVisible(true);
		authenticator.setModal(true);
		authenticator.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent evt){
		controllerDe.action(this,evt);
	}
}