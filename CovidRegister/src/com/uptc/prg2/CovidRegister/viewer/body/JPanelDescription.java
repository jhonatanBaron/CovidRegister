package com.uptc.prg2.CovidRegister.viewer.body;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.uptc.prg2.CovidRegister.viewer.constants.Constants;
import com.uptc.prg2.CovidRegister.viewer.utilities.Utilities;

public class JPanelDescription extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel description;

	public JPanelDescription() {
		super();
		this.init();
	}

	public void init() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setBackground(Color.WHITE);
		this.add(Utilities.image(700, 550, Constants.BODY_IMAGE));
		description = new JLabel();
		this.add(Utilities.text(description,
				Constants.FONT_INFORMATION, Constants.INFORMATION_APP,
				Color.BLACK));
		this.setVisible(true);
	}
}