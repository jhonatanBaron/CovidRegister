package com.uptc.prg2.CovidRegister.viewer.body;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.uptc.prg2.CovidRegister.controller.Command;
import com.uptc.prg2.CovidRegister.viewer.constants.Constants;
import com.uptc.prg2.CovidRegister.viewer.utilities.Utilities;

public class JBarOption extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JMenu report;
	private JMenuItem report1, report2, report3, report4, report5;
	private JButton registerButton, informationButton;

	public JBarOption(ActionListener actionListener) {
		this.init(actionListener);
	}

	private void init(ActionListener actionListener) {
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 210, 15));
		this.setBackground(Constants.COLOR_MENUBAR);
		registerButton = new JButton();
		registerButton.setBorder(null);
		registerButton.setFont(Constants.FONT_MENUBAR);
		registerButton.setBackground(Constants.COLOR_MENUBAR);
		registerButton.addActionListener(actionListener);
		registerButton.setActionCommand(
				Command.ADD_REGISTER.toString());
		this.add(Utilities.button(registerButton, 400, 60,
				Constants.BUTTON_REGISTER));

		informationButton = new JButton();
		informationButton.setBorder(null);
		informationButton.setFont(Constants.FONT_MENUBAR);
		informationButton.setBackground(Constants.COLOR_MENUBAR);
		informationButton.addActionListener(actionListener);
		informationButton.setActionCommand(Command.INFORMATION.toString());
		this.add(Utilities.button(informationButton, 400, 60,
				Constants.BUTTON_INFORMATION));

		report = new JMenu(Constants.BUTTON_REPORT);
		report.setFont(Constants.FONT_MENUBAR);
		report.setForeground(Color.BLACK);

		report1 = new JMenuItem(Constants.MENUITEM_REPORT1);
		report1.setFont(Constants.FONT_MENUBAR);
		report1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				InputEvent.CTRL_DOWN_MASK));
		report1.addActionListener(actionListener);
		report1.setActionCommand(Command.COMPANY_STATUS.toString());
		report.add(report1);
		this.add(report);

		report.addSeparator();

		report2 = new JMenuItem(Constants.MENUITEM_REPORT2);
		report2.setFont(Constants.FONT_MENUBAR);
		report2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,
				InputEvent.CTRL_DOWN_MASK));
		report2.addActionListener(actionListener);
		report2.setActionCommand(Command.TEMPERATURE_REPORT.toString());
		report.add(report2);
		this.add(report);
		report.addSeparator();

		report3 = new JMenuItem(Constants.MENUITEM_REPORT3);
		report3.setFont(Constants.FONT_MENUBAR);
		report3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
				InputEvent.CTRL_DOWN_MASK));
		report3.addActionListener(actionListener);
		report3.setActionCommand(Command.STATUS_PER_MONTH.toString());
		report.add(report3);
		this.add(report);
		report.addSeparator();

		report4 = new JMenuItem(Constants.MENUITEM_REPORT4);
		report4.setFont(Constants.FONT_MENUBAR);
		report4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,
				InputEvent.CTRL_DOWN_MASK));
		report4.addActionListener(actionListener);
		report4.setActionCommand(Command.SYMPTOM.toString());
		report.add(report4);
		this.add(report);
		report.addSeparator();

		report5 = new JMenuItem(Constants.MENUITEM_REPORT5);
		report5.setFont(Constants.FONT_MENUBAR);
		report5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
				InputEvent.CTRL_DOWN_MASK));
		report5.addActionListener(actionListener);
		report5.setActionCommand(Command.TYPE_EMPLOYEE_PER_STATUS.toString());
		report.add(report5);
		this.add(report);
	}
}