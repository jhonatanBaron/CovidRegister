package com.uptc.prg2.CovidRegister.viewer.information;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.uptc.prg2.CovidRegister.viewer.JFramePrincipal;
import com.uptc.prg2.CovidRegister.viewer.constants.Constants;
import com.uptc.prg2.CovidRegister.viewer.footer.JPanelFooter;
import com.uptc.prg2.CovidRegister.viewer.header.JPanelHeader;
import com.uptc.prg2.CovidRegister.viewer.utilities.Utilities;

public class JDialogInformation extends JDialog {

	private static final long serialVersionUID = 1L;

	private JLabel tittleCovid, tConceptCovid, conceptCovid, tSymptomCovid, symptomCovid;
	private JPanel leftPanel, rightPanel, centerPanel, northPanel, southPanel;
	private Dimension screenSize;

	public JDialogInformation(JFramePrincipal jFramePrincipal) {
		setModal(true);
		this.setTitle("Informacion");
		this.init(jFramePrincipal);
	}


	private void init(JFramePrincipal jFramePrincipal) {
		this.screenSize();
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		this.setSize((int)(screenSize.width/1.4), (int)(screenSize.height/1.4));
		this.setLocationRelativeTo(jFramePrincipal);
		this.add(rightPanel());
		this.add(leftPanel());
		this.add(northPanel(), BorderLayout.NORTH);
		this.add(centerPanel(), BorderLayout.CENTER);
		this.add(southPanel(), BorderLayout.SOUTH);
		
		this.setVisible(false);
	}
	
	public void screenSize() {
		screenSize =Toolkit.getDefaultToolkit().getScreenSize();
	}
	
	private Component northPanel() {
		northPanel = new JPanel();
		northPanel.setBackground(Color.BLACK);
		northPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		tittleCovid = new JLabel();
		northPanel.add(Utilities.text(tittleCovid, Constants.HEADER_FONT_TITTLE_DIALOGS, Constants.TITTLE_COVID, Color.WHITE));
		northPanel.setVisible(true);
		return northPanel;
	}
	
	private Component southPanel() {
		southPanel = new JPanel();
		southPanel.setBackground(Constants.BACKGROUND_FOOTER);
		southPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		southPanel.setVisible(true);
		return southPanel;
	}
	
	private Component centerPanel() {
		centerPanel = new JPanel();
		centerPanel.setBackground(Color.WHITE);
		centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		centerPanel.add(leftPanel());
		centerPanel.add(rightPanel());
		centerPanel.setVisible(true);
		return centerPanel;
	}

	private Component leftPanel() {
		leftPanel = new JPanel();
		leftPanel.setBackground(Color.WHITE);
		leftPanel.setLayout(
				new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		
		tConceptCovid = new JLabel();
		leftPanel.add(Utilities.text(tConceptCovid,Constants.FONT_INFORMATION, Constants.T_CONCEPT_COVID, Color.BLACK));
		
		conceptCovid = new JLabel();
		leftPanel.add(Utilities.text(conceptCovid,Constants.FONT_INFORMATION, Constants.CONCEPT_COVID,Color.BLACK));
		
		tSymptomCovid = new JLabel();
		leftPanel.add(Utilities.text(tSymptomCovid, Constants.FONT_INFORMATION, Constants.T_SYMPTOM_COVID,Color.BLACK));
		
		symptomCovid= new JLabel();
		leftPanel.add(Utilities.text(symptomCovid,Constants.FONT_INFORMATION, Constants.SYMPTOM_COVID, Color.BLACK));

		leftPanel.setVisible(true);
		return leftPanel;

	}

	private Component rightPanel() {
		rightPanel = new JPanel();
		rightPanel.setBackground(Color.WHITE);
		rightPanel.setLayout(new FlowLayout());
		rightPanel.add(Utilities.image((int)(getWidth()/3.2), (int)(getHeight()/3.6), Constants.BODY_IMAGE));
		System.out.println("dialog " +getWidth());
		rightPanel.setVisible(true);
		return rightPanel;
	}
	public void dialogVisibilitie(boolean visibility) {
		this.setVisible(visibility);
	}
}