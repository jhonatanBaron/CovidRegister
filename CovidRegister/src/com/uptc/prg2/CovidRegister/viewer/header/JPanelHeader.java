package com.uptc.prg2.CovidRegister.viewer.header;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.uptc.prg2.CovidRegister.viewer.constants.Constants;
import com.uptc.prg2.CovidRegister.viewer.utilities.Utilities;

public class JPanelHeader extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel tittle;
	private Dimension screenSize;

	public JPanelHeader() {
		super();
		this.initComponents();
	}

	private void initComponents() {
		this.screenSize();
		this.setSize(screenSize.width, (int)(screenSize.height));
		this.setBackground(Color.BLACK);
		this.setLayout(new FlowLayout(FlowLayout.LEFT, getWidth()/19, getHeight()/22));
		this.add(Utilities.image((int)(getWidth()/9.5), (int)(getHeight()/5.3), Constants.LOGO_APP));
		this.add(Utilities.space((int)(getWidth()/3.84), (int)(getHeight()/21.6)));
		tittle = new JLabel();
		this.add(Utilities.text(tittle, Constants.HEADER_FONT_TITTLE,
				Constants.TITTLE, Color.WHITE));	
		this.setVisible(true);
	}

	public void screenSize() {
		screenSize =Toolkit.getDefaultToolkit().getScreenSize();
	}
}