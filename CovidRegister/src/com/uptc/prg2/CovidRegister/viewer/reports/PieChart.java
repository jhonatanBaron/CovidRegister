package com.uptc.prg2.CovidRegister.viewer.reports;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

class PieChart extends JPanel {

	private static final long serialVersionUID = 1L;
	private String[] variableName;
	private Double[] variableValius;
	private double XCenter, YCenter;

	PieChart() {
		this.setBackground(Color.WHITE);
		variableName = new String[2];
		variableValius = new Double[2];
	}

//	public void infoExtractor(
//			ArrayList<DataReport> dataList) {
//		for (int i = 0; i < dataList.size(); i++) {
//			variableName[i] = dataList.get(i)
//					.getDataTypeName();
//			variableValius[i] = dataList.get(i)
//					.getDataValue();
//		}
//	}

	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D graphics2d = (Graphics2D) graphics;
		RenderingHints render = new RenderingHints(
				RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics2d.setRenderingHints(render);
		graphics.setColor(Color.CYAN);
		this.updateCoordinates(graphics2d);
		this.paintPieChart(graphics2d);
	}

	public void updateCoordinates(Graphics graphics) {
		this.XCenter = (this.getWidth() / 3);
		this.YCenter = (this.getHeight() / 4);
	}

	public void paintPieChart(Graphics graphics) {
		double grados1 = variableValius[0] * 360
				/ (variableValius[0] + variableValius[1]);
		double grados2 = variableValius[1] * 360
				/ (variableValius[0] + variableValius[1]);

		graphics.setColor(Color.decode("#ceeff7"));
		graphics.fillArc((int) XCenter, (int) YCenter,
				(int) (getWidth() / 3.14),
				(int) (getHeight() / 1.646), 0, (int) grados1);
		graphics.fillRect((int) (XCenter * 2.1), (int) YCenter, 40,
				40);
		graphics.setColor(Color.BLACK);
		graphics.drawArc((int) XCenter, (int) YCenter,
				(int) (getWidth() / 3.14),
				(int) (getHeight() / 1.646), 0, (int) grados1);
		graphics.drawRect((int) (XCenter * 2.1), (int) YCenter, 40,
				40);
		graphics.drawString(variableName[0], (int) (XCenter * 2.2),
				(int) (YCenter));

		graphics.setColor(Color.decode("#f7d3a6"));
		graphics.fillArc((int) XCenter, (int) YCenter,
				(int) (getWidth() / 3.14),
				(int) (getHeight() / 1.646), (int) grados1,
				(int) grados2);
		graphics.fillRect((int) (XCenter * 2.1),
				(int) (YCenter / 0.5), 40, 40);

		graphics.setColor(Color.BLACK);
		graphics.drawArc((int) XCenter, (int) YCenter,
				(int) (getWidth() / 3.14),
				(int) (getHeight() / 1.646), (int) grados1,
				(int) grados2);
		graphics.drawRect((int) (XCenter * 2.1),
				(int) (YCenter / 0.5), 40, 40);
		graphics.drawString(variableName[1], (int) (XCenter * 2.2),
				(int) (YCenter / 0.5));

	}

	public void graficVisibility(boolean visibility) {
		this.setVisible(visibility);
	}
}
