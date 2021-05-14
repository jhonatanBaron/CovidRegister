package com.uptc.prg2.CovidRegister.viewer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.uptc.prg2.CovidRegister.viewer.AddRegister.AddDialog;
import com.uptc.prg2.CovidRegister.viewer.body.JPanelBody;
import com.uptc.prg2.CovidRegister.viewer.constants.Constants;
import com.uptc.prg2.CovidRegister.viewer.footer.JPanelFooter;
import com.uptc.prg2.CovidRegister.viewer.header.JPanelHeader;
import com.uptc.prg2.CovidRegister.viewer.information.JDialogInformation;

public class JFramePrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jPanelPrincipal;
	private JPanelHeader jPanelHeader;
	private JPanelBody jPanelBody;
	private JPanelFooter jPanelFooter;
	private JScrollPane scrollbar;
	private JDialogInformation jDialogInformation;
	private AddDialog addDialog;

	public JFramePrincipal(ActionListener actionListener, String [] dataList) {
		super(Constants.TITTLE);
		this.jPanelHeader = new JPanelHeader();
		this.jPanelBody = new JPanelBody(actionListener);
		this.jPanelFooter = new JPanelFooter();
		this.jDialogInformation = new JDialogInformation(this);
		this.addDialog = new AddDialog(actionListener, this);
		this.init();
	}

	private void init() {
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		jPanelPrincipal = new JPanel();
		jPanelPrincipal.setBackground(Color.WHITE);
		jPanelPrincipal.setLayout(new BorderLayout(50, 50));
		jPanelPrincipal.add(jPanelHeader, BorderLayout.NORTH);
		jPanelPrincipal.add(jPanelBody, BorderLayout.CENTER);
		this.add(jPanelFooter, BorderLayout.SOUTH);
		scrollbar = new JScrollPane(jPanelPrincipal,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.add(scrollbar);
		this.setVisible(true);
		System.out.println(this.getWidth());
		System.out.println(this.getHeight());
	}

	public void dialogVisibilitiInfoDialog(boolean visibility) {
		jDialogInformation.setVisible(visibility);
	}
	
	public void dialogVisibilitiAddDialog(boolean visibility) {
		addDialog.setVisible(visibility);
	}
}