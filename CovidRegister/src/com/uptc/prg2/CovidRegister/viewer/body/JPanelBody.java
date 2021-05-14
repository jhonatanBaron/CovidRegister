package com.uptc.prg2.CovidRegister.viewer.body;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.uptc.prg2.CovidRegister.viewer.constants.Constants;
import com.uptc.prg2.CovidRegister.viewer.reports.BarrGraphics;
import com.uptc.prg2.CovidRegister.viewer.utilities.Utilities;

public class JPanelBody extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanelBarLanguage jPanelBarLanguage;
	private JPanelDescription jPanelDescription;
	private JPanel tittlePanel;
	private JLabel tittle;
	private BarrGraphics barrGraphics;

	public JPanelBody(ActionListener actionListener) {
		jPanelBarLanguage = new JPanelBarLanguage(actionListener);
		jPanelDescription = new JPanelDescription();
		barrGraphics = new BarrGraphics();
		this.init();
	}

	public void init() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(Color.WHITE);
		this.add(jPanelBarLanguage);
		this.add(Utilities.space(100, 100));
		this.add(tittlePanel());
		this.add(Utilities.space(300, 300));
		this.add(jPanelDescription);
		//this.add(barrGraphics);

		this.setVisible(true);
	}

	public Component tittlePanel() {
		tittlePanel = new JPanel();
		tittlePanel.setBackground(Color.WHITE);
		tittle = new JLabel();
		tittlePanel.add(
				Utilities.text(tittle, Constants.BODY_FONT_TITTLE,
						Constants.TITTLE_BODY, Color.GRAY));
		tittlePanel.setVisible(true);
		return tittlePanel;
	}

}