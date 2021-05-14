package com.uptc.prg2.CovidRegister.viewer.footer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.uptc.prg2.CovidRegister.viewer.constants.Constants;
import com.uptc.prg2.CovidRegister.viewer.utilities.Utilities;

public class JPanelFooter extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel info;
	private Dimension size;

	public JPanelFooter() {
		super();
		this.initComponents();
	}

	private void initComponents() {
		this.getSize();
		this.setBackground(Constants.BACKGROUND_FOOTER);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 25));

		this.add(Utilities.image(50, 50, Constants.GMAIL_LOGO));
		info = new JLabel();
		this.add(Utilities.text(info, Constants.FOOTER_FONT_INFO, Constants.INFORMATION_FOOTER, Color.WHITE));
		this.setVisible(true);
	}

	public Dimension getSize() {
		size = Toolkit.getDefaultToolkit().getScreenSize();
		return size;
	}
}
