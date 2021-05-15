package com.uptc.prg2.CovidRegister.viewer.AddRegister;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.DefaultFormatter;

import com.toedter.calendar.JDateChooser;
import com.uptc.prg2.CovidRegister.controller.Command;
import com.uptc.prg2.CovidRegister.persistence.HandlerLanguage;
import com.uptc.prg2.CovidRegister.viewer.JFramePrincipal;
import com.uptc.prg2.CovidRegister.viewer.constants.Constants;
import com.uptc.prg2.CovidRegister.viewer.utilities.Utilities;

public class AddDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private JDateChooser date;
	private JSpinner age;
	private JComboBox<String> externalCause, gender,
			specialty, diagnosticType, paymentResponsible,
			department, civilStatus, educationLevel;
	private JTextField name, description, diagnosticName,
			contractDescription, town;
	private JPanel centerPanel, northPanel, southPanel;
	private JButton acceptButton, cleanButton, cancelButton;
	private JLabel tittle;
	private Dimension screenSize;

	public AddDialog(ActionListener actionListener,
			JFramePrincipal jFramePrincipal) {
		setModal(true);
		this.setTitle(Constants.ADD_DIALOG_TITTLE);
		this.init(actionListener, jFramePrincipal);
	}

	private void init(ActionListener actionListener, JFramePrincipal jFramePrincipal) {
		this.screenSize();
		this.setLayout(new BorderLayout(5, 5));
		this.setBackground(Color.WHITE);
		this.setSize((int)(screenSize.width/1.4), (int)(screenSize.height/1.4));
		this.getContentPane().setBackground(Color.WHITE);
		this.setLocationRelativeTo(jFramePrincipal);
		this.add(northPanel(), BorderLayout.NORTH);
		this.add(centerPanel(), BorderLayout.CENTER);
		this.add(southPanel(actionListener),BorderLayout.SOUTH);
		this.setVisible(false);
	}
	public void screenSize() {
		screenSize =Toolkit.getDefaultToolkit().getScreenSize();
	}

	private Component northPanel() {
		northPanel = new JPanel();
		northPanel.setBackground(Color.BLACK);
		northPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		tittle = new JLabel();
		northPanel.add(Utilities.text(tittle, Constants.HEADER_FONT_TITTLE_DIALOGS, Constants.ADD_DIALOG_TITTLE,Color.WHITE));
		northPanel.setVisible(true);
		return northPanel;
	}

	private Component southPanel(ActionListener actionListener) {
		southPanel = new JPanel();
		southPanel.setBackground(Constants.BACKGROUND_FOOTER);
		southPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

		acceptButton = new JButton();
		acceptButton.addActionListener(actionListener);
		acceptButton.setActionCommand(Command.BUTTON_ADD_ACCEPT.toString());
		southPanel.add(Utilities.button(acceptButton, 100,50,Constants.DIALOG_BUTTON_ACCEPT));

		cleanButton = new JButton();
		cleanButton.addActionListener(actionListener);
		cleanButton.setActionCommand(Command.BUTTON_ADD_CLEAN_FIELDS.toString());
		southPanel.add(Utilities.button(cleanButton, 100, 50,Constants.DIALOG_ADD_BUTTON_CLEAN_FIELDS));

		cancelButton = new JButton();
		cancelButton.addActionListener(actionListener);
		cancelButton.setActionCommand(Command.BUTTON_ADD_CANCEL.toString());
		southPanel.add(Utilities.button(cancelButton, 100, 50,Constants.DIALOG_BUTTON_CANCEL));

		southPanel.setVisible(true);
		return southPanel;
	}

	private Component centerPanel() {
		centerPanel = new JPanel();
		centerPanel.setBackground(Color.WHITE);
		centerPanel.setLayout(new BoxLayout(centerPanel,
				BoxLayout.X_AXIS));
		centerPanel.add(this.westPanel());
//		centerPanel.add(this.eastPanel());
		centerPanel.setVisible(true);
		return centerPanel;
	}

	private Component westPanel() {
		JPanel westPanel = new JPanel();
		westPanel.setBackground(Color.WHITE);
		westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));

		Dimension sizeRegisterDate = new Dimension();
		sizeRegisterDate.setSize(300, 50);
		date = new JDateChooser();
		date.setMaximumSize(sizeRegisterDate);
		westPanel.add(date);

		westPanel.add(Utilities.space(10, 10));
		
		name = new JTextField();
		westPanel.add(Utilities.textField(name,Constants.ADD_DIALOG_FONT,Constants.ADD_DIALOG_CONTRACT_DESCRIPTION_FIELD,Color.GRAY, 300, 50));

		westPanel.setVisible(true);
		return westPanel;
	}

	private Component eastPanel() {
		JPanel eastPanel = new JPanel();
		eastPanel.setLayout(
				new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
		eastPanel.setBackground(Color.WHITE);

		

		eastPanel.setVisible(true);
		return eastPanel;
	}

	public void cleanTextFields() {
		age.setValue(0);
//		description.setText(Constants.ADD_DIALOG_DESCRIPTION_FIELD);
//		diagnosticName.setText(Constants.ADD_DIALOG_DIAGNOSTIC_NAME_FIELD);
//		contractDescription.setText(Constants.ADD_DIALOG_CONTRACT_DESCRIPTION_FIELD);
//		town.setText(Constants.ADD_DIALOG_TOWN_FIELD);
		externalCause.setSelectedIndex(0);
		gender.setSelectedIndex(0);
		specialty.setSelectedIndex(0);
		diagnosticType.setSelectedIndex(0);
		paymentResponsible.setSelectedIndex(0);
		department.setSelectedIndex(0);
		civilStatus.setSelectedIndex(0);
		educationLevel.setSelectedIndex(0);
	}


	public void dialogVisibilitie(boolean visibility) {
		this.setVisible(visibility);
	}

	public void changeLanguage() {
		tittle.setText(HandlerLanguage.languageProperties
				.getProperty(
						Constants.ADD_DIALOG_TITTLE));
		acceptButton
				.setText(HandlerLanguage.languageProperties
						.getProperty(
								Constants.DIALOG_BUTTON_ACCEPT));
		cleanButton
				.setText(HandlerLanguage.languageProperties
						.getProperty(
								Constants.DIALOG_ADD_BUTTON_CLEAN_FIELDS));
		cancelButton
				.setText(HandlerLanguage.languageProperties
						.getProperty(
								Constants.DIALOG_BUTTON_CANCEL));
//		description
//				.setText(HandlerLanguage.languageProperties
//						.getProperty(
//								Constants.ADD_DIALOG_DESCRIPTION_FIELD));
//		diagnosticName
//				.setText(HandlerLanguage.languageProperties
//						.getProperty(
//								Constants.ADD_DIALOG_DIAGNOSTIC_NAME_FIELD));
//		contractDescription
//				.setText(HandlerLanguage.languageProperties
//						.getProperty(
//								Constants.ADD_DIALOG_CONTRACT_DESCRIPTION_FIELD));
//		town.setText(HandlerLanguage.languageProperties
//				.getProperty(
//						Constants.ADD_DIALOG_TOWN_FIELD));
	}

}
