package com.uptc.prg2.CovidRegister.viewer.body;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.uptc.prg2.CovidRegister.controller.Command;
import com.uptc.prg2.CovidRegister.viewer.constants.Constants;
import com.uptc.prg2.CovidRegister.viewer.utilities.Utilities;

public class JPanelBarLanguage extends JPanel {

	private static final long serialVersionUID = 1L;
	private JBarOption jBarOption;
	private JButton spanish, english;

	public JPanelBarLanguage(ActionListener actionListener) {
		super();
		this.init(actionListener);	
	}

	private void init(ActionListener actionListener) {
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
		this.setBackground(Color.WHITE);
		jBarOption = new JBarOption(actionListener);
		this.add(jBarOption);
		spanish = new JButton();
		spanish.addActionListener(actionListener);
		spanish.setActionCommand(Command.SPANISH.toString());
		this.add(Utilities.buttonImage(spanish, 70, 70, Constants.LANGUAGE_ES_ICON));
		english = new JButton();
		english.addActionListener(actionListener);
		english.setActionCommand(Command.ENGLISH.toString());
		this.add(Utilities.buttonImage(english, 70, 70, Constants.LANGUAGE_US_ICON));
		this.setVisible(true);
	}
}